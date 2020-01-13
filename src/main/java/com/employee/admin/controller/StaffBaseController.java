package com.employee.admin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.employee.admin.entity.StaffRole;
import com.employee.admin.entity.StaffUser;
import com.employee.admin.entity.WorkAttendance;
import com.employee.admin.enums.ExceptionEnum;
import com.employee.admin.exception.ExtenException;
import com.employee.admin.service.*;
import com.employee.admin.utils.IdWorkerUtils;
import com.employee.admin.vo.AddStaffBaseParam;
import com.employee.admin.vo.ResultVO;
import com.employee.admin.vo.StaffBaseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
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

    @Autowired
    private IUserService userService;

    @Autowired
    private IStaffRoleService staffRoleService;

    @Autowired
    private IStaffUserService staffUserService;

    @Autowired
    private IWorkAttendanceService workAttendanceService;

    @Value("${idWorker.workerId}")
    private Integer workerId;

    @Value("${idWorker.datacenterId}")
    private Integer datacenterId;

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

        logger.info("StaffBaseController addStaffBase start ... requestParam:{}", requestParam);
        JSONObject jsonObject = (JSONObject) JSON.toJSON(requestParam.get("params"));
        AddStaffBaseParam params = jsonObject.toJavaObject(AddStaffBaseParam.class);
        if (params.getStaffBase() == null || params.getStaffDept() == null || params.getStaffDetail() == null) {
            throw new ExtenException("addEmp", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
        // 生成userId
        long userId = new IdWorkerUtils(workerId, datacenterId).nextId();
        params.getStaffDetail().setUserId(userId);
        // 用户注册需将用户密码进行加密
        params.getStaffDetail().setPassword(new BCryptPasswordEncoder().encode(params.getStaffDetail().getPassword()));
        // 还需要进行对该用户的直属上级进行指定
        staffBaseService.addStaffBase(params.getStaffBase());
        userService.userRegister(params.getStaffDetail());
        staffDeptService.addStaffDept(params.getStaffDept());
        // 员工默认权限为企业员工
        StaffRole staffRole = new StaffRole();
        staffRole.setUserId(userId);
        staffRole.setRoleId("ROLE003");
        staffRoleService.addStaffRole(staffRole);
        // 关联员工的员工号和用户id
        StaffUser staffUser = new StaffUser();
        staffUser.setEmpId(params.getStaffBase().getEmpId());
        staffUser.setUserId(params.getStaffDetail().getUserId());
        staffUserService.addStaffUser(staffUser);
        // 为当前用户添加注册当天的签到信息
        WorkAttendance workAttendance = new WorkAttendance();
        workAttendance.setEmpId(params.getStaffBase().getEmpId());
        workAttendance.setEmpName(params.getStaffBase().getEmpName());
        workAttendance.setAttendanceTime(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now()));
        workAttendance.setCreateTime(LocalDateTime.now());
        workAttendanceService.addWorkAttendance(workAttendance);
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
