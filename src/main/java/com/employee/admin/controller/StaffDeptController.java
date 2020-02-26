package com.employee.admin.controller;

import com.employee.admin.enums.ExceptionEnum;
import com.employee.admin.exception.ExtenException;
import com.employee.admin.service.IStaffBaseService;
import com.employee.admin.service.IStaffDeptService;
import com.employee.admin.service.IUserService;
import com.employee.admin.vo.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目名称：employee-admin-server
 * 类名称：StaffDeptController
 * 类描述：TDD
 * 创建人：yingx
 * 创建时间： 2020/2/24
 * 修改人：yingx
 * 修改时间： 2020/2/24
 * 修改备注：
 */
@RestController
@RequestMapping("/staffDept")
public class StaffDeptController {

    private static final Logger logger = LoggerFactory.getLogger(StaffDeptController.class);

    @Autowired
    private IUserService userService;

    @Autowired
    private IStaffBaseService staffBaseService;

    @Autowired
    private IStaffDeptService staffDeptService;

    @PostMapping("/getSubEmp")
    @CrossOrigin
    public ResultVO getSubEmp(@RequestBody QueryUserVO queryUserVO){

        logger.info("StaffDeptController getSubEmp start ... QueryUserVO:{}", queryUserVO);
        if (StringUtils.isBlank(queryUserVO.getUsername()) && StringUtils.isBlank(queryUserVO.getUserId() + "")) {
            throw new ExtenException("getSubEmp", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
        // 通过用户名查询用户id
        if (queryUserVO.getUserId() == null) {
            StaffDetailVO user = userService.getUser(queryUserVO);
            queryUserVO.setUserId(Long.parseLong(user.getUserId()));
        }
        // 根据用户id查询用户员工号
        StaffBaseVO staffBaseByUser = staffBaseService.getStaffBaseByUser(queryUserVO);
        List<StaffDeptVO> subEmp = staffDeptService.getSubEmp(staffBaseByUser.getEmpId());
        logger.info("StaffDeptController getSubEmp end ... Result:{}", subEmp);
        return new ResultVO(subEmp);
    }
}
