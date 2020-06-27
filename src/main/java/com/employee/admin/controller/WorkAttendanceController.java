package com.employee.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.employee.admin.entity.WorkAttendance;
import com.employee.admin.enums.ExceptionEnum;
import com.employee.admin.exception.ExtenException;
import com.employee.admin.service.IStaffBaseService;
import com.employee.admin.service.IStaffDeptService;
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
    private IStaffDeptService staffDeptService;

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
     * 获取员工当天的考勤信息
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
     * 获取员工的考勤信息
     *
     * @param userAndPageParam
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2020/1/6
     */
    @PostMapping("/getUserWorkAttendance")
    @CrossOrigin
    public ResultVO getUserWorkAttendance(@RequestBody UserAndPageParam userAndPageParam) {

        logger.info("WorkAttendanceController getUserWorkAttendance start ... UserAndPageParam:{}", userAndPageParam);
        if (StringUtils.isBlank(userAndPageParam.getUsername()) && StringUtils.isBlank(userAndPageParam.getUserId() + "")
                && StringUtils.isBlank(userAndPageParam.getEmpId()) && StringUtils.isBlank(userAndPageParam.getEmpName())) {
            throw new ExtenException("getUserWorkAttendance", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
        // 通过用户名查询用户id
        QueryUserVO queryUserVO = new QueryUserVO();
        if (userAndPageParam.getUserId() == null && userAndPageParam.getUsername() != null) {
            queryUserVO.setUsername(userAndPageParam.getUsername());
            StaffDetailVO user = userService.getUser(queryUserVO);
            queryUserVO.setUserId(Long.parseLong(user.getUserId()));
        }
        // 根据用户id查询用户员工号
        StaffBaseVO staffBaseByUser = staffBaseService.getStaffBaseByUser(queryUserVO);
        WorkAttendanceVO workAttendanceVO = new WorkAttendanceVO();
        if (StringUtils.isBlank(userAndPageParam.getEmpId()) && StringUtils.isBlank(userAndPageParam.getEmpName())) {
            workAttendanceVO.setEmpId(staffBaseByUser.getEmpId());
        }else{
            workAttendanceVO.setEmpId(userAndPageParam.getEmpId());
        }
        List<WorkAttendanceVO> records = null;
        try {
            IPage<WorkAttendanceVO> workAttendance = workAttendanceService.getUserWorkAttendance(workAttendanceVO,
                    userAndPageParam.getPage(), userAndPageParam.getPageSize());
            records = workAttendance.getRecords();
        } catch (Exception e) {
            logger.error("WorkAttendanceController getWorkAttendance error ...", e);
            throw new ExtenException("getWorkAttendance", ExceptionEnum.UNEXPECTED_ERROR.getCode(), ExceptionEnum.UNEXPECTED_ERROR.getMessage());
        }
        logger.info("WorkAttendanceController getWorkAttendance end ...result:{}", records);
        return new ResultVO(records);
    }

    /**
     * 获取员工下属的考勤信息
     *
     * @param userAndPageParam
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2020/1/6
     */
    @PostMapping("/getSubEmpWorkAttendance")
    @CrossOrigin
    public ResultVO getSubEmpWorkAttendance(@RequestBody UserAndPageParam userAndPageParam) {

        logger.info("WorkAttendanceController getSubEmpWorkAttendance start ... UserAndPageParam:{}", userAndPageParam);
        if (StringUtils.isBlank(userAndPageParam.getUsername()) && StringUtils.isBlank(userAndPageParam.getUserId() + "")) {
            throw new ExtenException("getSubEmpWorkAttendance", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
        // 通过用户名查询用户id
        QueryUserVO queryUserVO = new QueryUserVO();
        if (userAndPageParam.getUserId() == null) {
            queryUserVO.setUsername(userAndPageParam.getUsername());
            StaffDetailVO user = userService.getUser(queryUserVO);
            queryUserVO.setUserId(Long.parseLong(user.getUserId()));
        }
        // 根据用户id查询用户员工号
        StaffBaseVO staffBaseByUser = staffBaseService.getStaffBaseByUser(queryUserVO);
        // 通过员工号查询下属列表
        List<StaffDeptVO> subEmp = staffDeptService.getSubEmp(staffBaseByUser.getEmpId());

        if (subEmp == null || subEmp.size() == 0) {
            return new ResultVO();
        }

        // 批量查询
        List<WorkAttendanceVO> records = null;
        try {
            IPage<WorkAttendanceVO> workAttendance = workAttendanceService.getUseSubEmpAttendance(subEmp,
                    userAndPageParam.getPage(), userAndPageParam.getPageSize());
            records = workAttendance.getRecords();
        } catch (Exception e) {
            logger.error("WorkAttendanceController getSubEmpWorkAttendance error ...", e);
            throw new ExtenException("getSubEmpWorkAttendance", ExceptionEnum.UNEXPECTED_ERROR.getCode(), ExceptionEnum.UNEXPECTED_ERROR.getMessage());
        }
        logger.info("WorkAttendanceController getSubEmpWorkAttendance end ...result:{}", records);
        return new ResultVO(records);
    }

    /**
      * 获取员工的考勤统计
      *
      * @param monthWorkAttendanceParam
      * @return com.employee.admin.vo.ResultVO
      * @author yingx
      * @date 2020/2/21
     */
    @PostMapping("/getMonthWorkAttendance")
    @CrossOrigin
    public ResultVO getMonthWorkAttendance(@RequestBody MonthWorkAttendanceParam monthWorkAttendanceParam){

        logger.info("WorkAttendanceController getMonthWorkAttendance start ... monthWorkAttendance:{}", monthWorkAttendanceParam);
        if (StringUtils.isBlank(monthWorkAttendanceParam.getUsername()) && StringUtils.isBlank(monthWorkAttendanceParam.getUserId() + "")) {
            throw new ExtenException("getMonthWorkAttendance", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
        if (monthWorkAttendanceParam.getUserId() == null) {
            QueryUserVO queryUserVO = new QueryUserVO();
            queryUserVO.setUsername(monthWorkAttendanceParam.getUsername());
            StaffDetailVO user = userService.getUser(queryUserVO);
            monthWorkAttendanceParam.setUserId(Long.parseLong(user.getUserId()));
        }
        MonthWorkAttendanceVO monthWorkAttendanceVO = workAttendanceService.getMonthWorkAttendance(monthWorkAttendanceParam);
        logger.info("WorkAttendanceController getMonthWorkAttendance end ...result:{}", monthWorkAttendanceVO);
        return new ResultVO(monthWorkAttendanceVO);
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

    /**
      * 获取员工需要补签的信息
      *
      * @param queryUserVO
      * @return com.employee.admin.vo.ResultVO
      * @author yingx
      * @date 2020/2/26
     */
    public ResultVO getStaffSupplement(@RequestBody QueryUserVO queryUserVO){

        logger.info("WorkAttendanceController getStaffSupplement start ...");
        if (StringUtils.isBlank(queryUserVO.getUsername()) && StringUtils.isBlank(queryUserVO.getUserId() + "")) {
            throw new ExtenException("getStaffSupplement", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
        if (queryUserVO.getUserId() == null) {
            // 通过用户名查询用户id
            StaffDetailVO user = userService.getUser(queryUserVO);
            queryUserVO.setUserId(Long.parseLong(user.getUserId()));
        }
        // 查询用户基本信息
        StaffBaseVO staffBaseByUser = staffBaseService.getStaffBaseByUser(queryUserVO);
        
        return null;
    }
}
