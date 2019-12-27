package com.employee.admin.controller;

import com.employee.admin.enums.ExceptionEnum;
import com.employee.admin.exception.ExtenException;
import com.employee.admin.service.IStaffBaseService;
import com.employee.admin.vo.ResultVO;
import com.employee.admin.vo.StaffBaseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 项目名称：employee-admin-server
 * 类名称：StaffBaseController
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2019/12/27
 * 修改人：yingx
 * 修改时间： 2019/12/27
 * 修改备注：
 */
@RestController
@RequestMapping("/emp")
public class StaffBaseController {

    private static final Logger logger = LoggerFactory.getLogger(StaffBaseController.class);

    @Autowired
    private IStaffBaseService staffBaseService;

    /**
     * 管理员进行录入新员工
     *
     * @param
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2019/12/27
     */
    @PostMapping("/addEmp")
    @CrossOrigin
    public ResultVO addStaffBase(@RequestBody StaffBaseVO staffBaseVO) {

        logger.info("StaffBaseController addEmp start ...");
        if (staffBaseVO == null) {
            throw new ExtenException("addEmp", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
        staffBaseService.addStaffBase(staffBaseVO);
        return new ResultVO();
    }

    /**
     * 员工经管理员注册完进行的首次登录
     *
     * @param staffBaseVO
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2019/12/27
     */
    @PostMapping("/login")
    @CrossOrigin
    public ResultVO empLogin(@RequestBody StaffBaseVO staffBaseVO) {

        logger.info("StaffBaseController empLogin start ...");
        if (staffBaseVO == null) {
            throw new ExtenException("empLogin", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
        staffBaseService.addStaffBase(staffBaseVO);
        return new ResultVO();
    }
}
