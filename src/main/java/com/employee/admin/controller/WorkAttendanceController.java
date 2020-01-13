package com.employee.admin.controller;

import com.employee.admin.entity.WorkAttendance;
import com.employee.admin.enums.ExceptionEnum;
import com.employee.admin.enums.ResultEnum;
import com.employee.admin.exception.ExtenException;
import com.employee.admin.service.IStaffBaseService;
import com.employee.admin.service.IUserService;
import com.employee.admin.service.IWorkAttendanceService;
import com.employee.admin.utils.IpUtils;
import com.employee.admin.vo.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * 项目名称：employee-admin-server
 * 类名称：WorkAttendanceController
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2020/1/3
 * 修改人：yingx
 * 修改时间： 2020/1/3
 * 修改备注：
 */
@RestController
@RequestMapping("/attendance")
public class WorkAttendanceController {

    private static final Logger logger = LoggerFactory.getLogger(WorkAttendanceController.class);

    @Autowired
    private IUserService userService;

    @Autowired
    private IStaffBaseService staffBaseService;

    @Autowired
    private IWorkAttendanceService workAttendanceService;

    /**
     * 获取全部员工的考勤记录信息
     *
     * @param
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2020/1/6
     */
    @PostMapping("/getAllWorkAttendance")
    @CrossOrigin
    public ResultVO getAllWorkAttendance() {

        logger.info("WorkAttendanceController getAllWorkAttendance start ...");
        List<WorkAttendanceVO> allWorkAttendance = workAttendanceService.getAllWorkAttendance();
        if (allWorkAttendance != null) {
            logger.info("WorkAttendanceController getAllWorkAttendance end ... WorkAttendanceVO:{}", allWorkAttendance);
            return new ResultVO(allWorkAttendance);
        } else {
            logger.error("WorkAttendanceController getAllWorkAttendance end ... ");
            throw new ExtenException("getAllWorkAttendance", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
    }

    /**
     * 获取员工的考勤信息
     *
     * @param queryUserVO
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2020/1/6
     */
    @PostMapping("/getWorkAttendance")
    @CrossOrigin
    public ResultVO getWorkAttendance(@RequestBody QueryUserVO queryUserVO) {

        logger.info("WorkAttendanceController getWorkAttendance start ...");
        if (StringUtils.isBlank(queryUserVO.getUsername()) && StringUtils.isBlank(queryUserVO.getUserId() + "")) {
            throw new ExtenException("getWorkAttendance", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
        if (queryUserVO.getUserId() == null) {
            // 通过用户名查询用户id
            StaffDetailVO user = userService.getUser(queryUserVO);
            queryUserVO.setUserId(Long.parseLong(user.getUserId()));
        }
        WorkAttendanceVO workAttendance = workAttendanceService.getWorkAttendance(queryUserVO);
        if (workAttendance != null) {
            logger.info("WorkAttendanceController getWorkAttendance end ... WorkAttendanceVO:{}", workAttendance);
            return new ResultVO(workAttendance);
        } else {
            logger.error("WorkAttendanceController getWorkAttendance end ... ");
            throw new ExtenException("getAllWorkAttendance", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
    }

    /**
     * 员工签到
     *
     * @param queryUserVO
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2020/1/6
     */
    @PostMapping("/addWorkAttendance")
    @CrossOrigin
    public ResultVO addWorkAttendance(@RequestBody QueryUserVO queryUserVO, HttpServletRequest request) {

        logger.info("WorkAttendanceController addWorkAttendance start ...");
        if (StringUtils.isBlank(queryUserVO.getUsername()) && StringUtils.isBlank(queryUserVO.getUserId() + "")) {
            throw new ExtenException("addWorkAttendance", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
        if (queryUserVO.getUserId() == null) {
            // 通过用户名查询用户id
            StaffDetailVO user = userService.getUser(queryUserVO);
            queryUserVO.setUserId(Long.parseLong(user.getUserId()));
        }
        // 查询用户基本信息
        StaffBaseVO staffBaseByUser = staffBaseService.getStaffBaseByUser(queryUserVO);
        WorkAttendance workAttendance = new WorkAttendance();
        workAttendance.setEmpId(staffBaseByUser.getEmpId());
        workAttendance.setEmpName(staffBaseByUser.getEmpName());
        workAttendance.setStartTime(DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now()));
        // 获取签退使用的电脑ip
        workAttendance.setStartIp(IpUtils.getIpAddr(request));
        workAttendance.setAttendanceTime(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now()));
        workAttendanceService.updateWorkAttendance(workAttendance);
        logger.info("WorkAttendanceController addWorkAttendance end ... ");
        return new ResultVO();
    }

    /**
     * 员工签退
     *
     * @param queryUserVO
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2020/1/6
     */
    @PostMapping("/addEndWorkAttendance")
    @CrossOrigin
    public ResultVO addEndWorkAttendance(@RequestBody QueryUserVO queryUserVO, HttpServletRequest request) {

        logger.info("WorkAttendanceController addEndWorkAttendance start ...");
        if (StringUtils.isBlank(queryUserVO.getUsername()) && StringUtils.isBlank(queryUserVO.getUserId() + "")) {
            throw new ExtenException("addEndWorkAttendance", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
        if (queryUserVO.getUserId() == null) {
            // 通过用户名查询用户id
            StaffDetailVO user = userService.getUser(queryUserVO);
            queryUserVO.setUserId(Long.parseLong(user.getUserId()));
        }
        // 查询用户基本信息
        StaffBaseVO staffBaseByUser = staffBaseService.getStaffBaseByUser(queryUserVO);
        WorkAttendance workAttendance = new WorkAttendance();
        workAttendance.setEmpId(staffBaseByUser.getEmpId());
        workAttendance.setEmpName(staffBaseByUser.getEmpName());
        workAttendance.setEndTime(DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now()));
        // 获取签退使用的电脑ip
        workAttendance.setEndIp(IpUtils.getIpAddr(request));
        workAttendance.setAttendanceTime(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now()));
        workAttendanceService.updateWorkAttendance(workAttendance);
        logger.info("WorkAttendanceController addWorkAttendance end ... ");
        return new ResultVO();
    }
}
