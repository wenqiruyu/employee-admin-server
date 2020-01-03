package com.employee.admin.controller;

import com.employee.admin.enums.ExceptionEnum;
import com.employee.admin.enums.ResultEnum;
import com.employee.admin.exception.ExtenException;
import com.employee.admin.service.IWorkAttendanceService;
import com.employee.admin.vo.ResultVO;
import com.employee.admin.vo.WorkAttendanceVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private IWorkAttendanceService workAttendanceService;

    @PostMapping("/getAllWorkAttendance")
    @CrossOrigin
    public ResultVO getAllWorkAttendance() {

        logger.info("WorkAttendanceController getAllWorkAttendance start ...");
        List<WorkAttendanceVO> allWorkAttendance = workAttendanceService.getAllWorkAttendance();
        if (allWorkAttendance != null) {
            logger.info("UserController getUserInfo end ... WorkAttendanceVO:{}", allWorkAttendance);
            return new ResultVO(allWorkAttendance);
        } else {
            logger.error("UserController getUserInfo end ... ");
            throw new ExtenException("getAllWorkAttendance", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
    }
}
