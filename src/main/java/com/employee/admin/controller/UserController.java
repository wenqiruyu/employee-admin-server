package com.employee.admin.controller;

import com.employee.admin.entity.StaffRole;
import com.employee.admin.enums.ExceptionEnum;
import com.employee.admin.enums.ResultEnum;
import com.employee.admin.exception.ExtenException;
import com.employee.admin.service.IUserService;
import com.employee.admin.utils.IdWorkerUtils;
import com.employee.admin.vo.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：employee-admin-server
 * 类名称：UserController
 * 类描述：处理针对用户的逻辑操作
 * 创建人：yingx
 * 创建时间： 2019/12/24
 * 修改人：yingx
 * 修改时间： 2019/12/24
 * 修改备注：
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Value("${idWorker.workerId}")
    private Integer workerId;

    @Value("${idWorker.datacenterId}")
    private Integer datacenterId;

    @Autowired
    private IUserService userService;


    /**
     * 用户登录后台管理系统
     *
     * @param loginUserVO
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2019/12/24
     */
    @PostMapping("/login")
    @CrossOrigin
    public ResultVO userLogin(@RequestBody LoginUserVO loginUserVO) {

        return null;
    }

    /**
     * 用户注册账号
     *
     * @param registerUserVO
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2019/12/24
     */
    @PostMapping("/register")
    @CrossOrigin
    public ResultVO userRegister(@RequestBody RegisterUserVO registerUserVO) {

        logger.info("UserController register start ... Username:{}, Password:{}",
                registerUserVO.getUsername(), StringUtils.isBlank(registerUserVO.getPassword()) ? null : "******");
        if (StringUtils.isBlank(registerUserVO.getUsername()) || StringUtils.isBlank(registerUserVO.getPassword())) {
            throw new ExtenException("register", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
        // 用户注册需将用户密码进行加密
//        registerUserVO.setPassword(new BCryptPasswordEncoder().encode(registerUserVO.getPassword()));
        QueryUserVO queryUserVO = new QueryUserVO();
        queryUserVO.setUsername(registerUserVO.getUsername());
        // 排除昵称同名的情况
        StaffDetailVO user = userService.getUser(queryUserVO);
        if (user == null) {
            // 生成userId
            long userId = new IdWorkerUtils(workerId, datacenterId).nextId();
            registerUserVO.setUserId(userId);
            userService.userRegister(registerUserVO);
            // 注册成功添加用户权限 注册用户都默认为普通用户
            StaffRole staffRole = new StaffRole();
            staffRole.setUserId(userId);
            staffRole.setRoleId(1L);
            userService.addStaffRole(staffRole);
            logger.info("UserController register end ... userId:{}", userId);
            return new ResultVO();
        } else {
            logger.info("UserController register end ... result:{}", "注册失败,用户名已存在");
            List<ErrorDataVO> errorList = new ArrayList<>();
            errorList.add(new ErrorDataVO("name", "用户名已存在"));
            throw new ExtenException("register", ResultEnum.FAIL.getCode(), ResultEnum.FAIL.getMsg(), errorList);
        }
    }

    @PostMapping("/getUser")
    @CrossOrigin
    public ResultVO getUserInfo(@RequestBody QueryUserVO queryUserVO) {

        logger.info("UserController getUserInfo start ... UserId:{}, Username:{}, empId:{}",
                queryUserVO.getUserId(), queryUserVO.getUsername(), queryUserVO.getEmpId());
        if (StringUtils.isBlank(queryUserVO.getUserId().toString()) && StringUtils.isBlank(queryUserVO.getUsername())
            && StringUtils.isBlank(queryUserVO.getEmpId())) {
            throw new ExtenException("register", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
        StaffDetailVO user = userService.getUser(queryUserVO);
        if (user != null) {
            logger.info("UserController getUserInfo end ... StaffDetailVO:{}", user);
            return new ResultVO(user);
        }else{
            logger.info("UserController getUserInfo end ... result:{}", "查找用户信息失败，该用户信息不存在");
            return new ResultVO(ResultEnum.UNKNOWN_USER_INFO.getCode(), ResultEnum.UNKNOWN_USER_INFO.getMsg());
        }
    }

    public ResultVO deleteUser() {

        return null;
    }

    public ResultVO updateUser() {

        return null;
    }

    public ResultVO logout() {

        return null;
    }
}
