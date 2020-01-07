package com.employee.admin.controller;

import com.employee.admin.entity.StaffBase;
import com.employee.admin.entity.StaffDept;
import com.employee.admin.enums.ExceptionEnum;
import com.employee.admin.exception.ExtenException;
import com.employee.admin.mapper.IStaffDeptMapper;
import com.employee.admin.service.IStaffBaseService;
import com.employee.admin.service.IStaffDeptService;
import com.employee.admin.vo.DeptVO;
import com.employee.admin.vo.ResultVO;
import com.employee.admin.vo.StaffBaseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private IStaffDeptService staffDeptService;

    /**
     * 获取员工号
     *
     * @param
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2020/1/7
     */
    @PostMapping("/getEmpId")
    @CrossOrigin
    public ResultVO getEmpId() {

        logger.info("StaffBaseController getEmpId start ...");
        int staffBaseNum = staffBaseService.getStaffBaseNum();
        String empId = "JXNC" + String.format("%04d", staffBaseNum + 1);
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("empId", empId);
        logger.info("StaffBaseController getEmpId end ... Result:{}", empId);
        return new ResultVO(resultMap);
    }

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
    public ResultVO addStaffBase(@RequestBody Map<String, Object> requestParam) {

        logger.info("StaffBaseController addStaffBase start ...");
        if (requestParam.get("staffBase") == null || requestParam.get("staffDept") == null) {
            throw new ExtenException("addEmp", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
        // 还需要进行对该用户的直属上级进行指定
        staffBaseService.addStaffBase((StaffBase) requestParam.get("staffBase"));
        staffDeptService.addStaffDept((StaffDept) requestParam.get("staffDept"));
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
        return new ResultVO();
    }
}
