package com.employee.admin.controller;

import com.employee.admin.entity.StaffLeave;
import com.employee.admin.enums.ExceptionEnum;
import com.employee.admin.exception.ExtenException;
import com.employee.admin.service.IStaffLeaveService;
import com.employee.admin.vo.LoginUserVO;
import com.employee.admin.vo.QueryUserVO;
import com.employee.admin.vo.ResultVO;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * 项目名称：employee-admin-server
 * 类名称：StaffLeaveController
 * 类描述：TDD
 * 创建人：yingx
 * 创建时间： 2020/4/10
 * 修改人：yingx
 * 修改时间： 2020/4/10
 * 修改备注：
 */
@RestController
@RequestMapping("/leave")
public class StaffLeaveController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IStaffLeaveService staffLeaveService;

    /**
     * 添加请假信息
     *
     * @param staffLeave
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2020/4/10
     */
    @PostMapping("/addLeave")
    @CrossOrigin
    public ResultVO addLeave(@RequestBody StaffLeave staffLeave) {

        logger.info("StaffLeaveController addLeave start ... StaffLeave:{}", staffLeave);

        ResultVO resultVO = staffLeaveService.addStaffLeave(staffLeave);

        logger.info("StaffLeaveController addLeave end ...");

        return resultVO;
    }

    /**
     * 上级获取请假审批信息
     *
     * @param queryUserVO
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2020/4/10
     */
    @PostMapping("/getSubEmpLeave")
    @CrossOrigin
    public ResultVO getSubEmpLeave(@RequestBody QueryUserVO queryUserVO) {

        logger.info("StaffLeaveController getSubEmpLeave start ... QueryUserVO:{}", queryUserVO);

        ResultVO resultVO = staffLeaveService.getSubEmpLeave(queryUserVO);

        logger.info("StaffLeaveController getSubEmpLeave end ...");

        return resultVO;
    }

    /**
     * 更新为下一状态
     *
     * @param staffLeave
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2020/4/10
     */
    @PostMapping("/updateEmpLeave")
    @CrossOrigin
    public ResultVO updateEmpLeave(@RequestBody StaffLeave staffLeave) {

        logger.info("StaffLeaveController updateEmpLeave start ... id:{}", staffLeave.getId());

        ResultVO resultVO = staffLeaveService.updateEmpLeave(staffLeave.getId());

        logger.info("StaffLeaveController updateEmpLeave end ...");

        return resultVO;
    }

    /**
     * 请假不通过
     *
     * @param staffLeave
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2020/4/10
     */
    @PostMapping("/updateEmpLeaveError")
    @CrossOrigin
    public ResultVO updateEmpLeaveError(@RequestBody StaffLeave staffLeave) {

        logger.info("StaffLeaveController updateEmpLeaveError start ... id:{}", staffLeave.getId());

        ResultVO resultVO = staffLeaveService.updateEmpLeaveError(staffLeave.getId());

        logger.info("StaffLeaveController updateEmpLeaveError end ...");

        return resultVO;
    }

    /**
     * 上级获取请假审批信息
     *
     * @param queryUserVO
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2020/4/10
     */
    @PostMapping("/getEmpAllLeave")
    @CrossOrigin
    public ResultVO getEmpAllLeave(@RequestBody QueryUserVO queryUserVO) {

        logger.info("StaffLeaveController getSubEmpLeave start ... QueryUserVO:{}", queryUserVO);

        ResultVO resultVO = staffLeaveService.getEmpAllLeave(queryUserVO);

        logger.info("StaffLeaveController getSubEmpLeave end ...");

        return resultVO;
    }
}
