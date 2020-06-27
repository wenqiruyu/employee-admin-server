package com.employee.admin.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.employee.admin.entity.StaffDetail;
import com.employee.admin.entity.StaffRole;
import com.employee.admin.enums.ExceptionEnum;
import com.employee.admin.enums.ResultEnum;
import com.employee.admin.exception.ExtenException;
import com.employee.admin.mapper.*;
import com.employee.admin.service.IUserService;
import com.employee.admin.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 项目名称：employee-admin-server
 * 类名称：UserServiceImpl
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2019/12/24
 * 修改人：yingx
 * 修改时间： 2019/12/24
 * 修改备注：
 */
@Service
public class UserServiceImpl implements IUserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private IStaffDetailMapper staffDetailMapper;

    @Autowired
    private IStaffBaseMapper staffBaseMapper;

    @Override
    public void userRegister(RegisterUserVO registerUserVO) {

        JSONObject jsonObject = (JSONObject) JSON.toJSON(registerUserVO);
        StaffDetail staffDetail = jsonObject.toJavaObject(StaffDetail.class);
        staffDetail.setDeleteFlag(0);
        staffDetail.setCreateTime(LocalDateTime.now());
        staffDetailMapper.addStaffDetail(staffDetail);
    }

    @Override
    public ResultVO userLogin(LoginUserVO loginUserVO) {

        JSONObject jsonObject = (JSONObject) JSON.toJSON(loginUserVO);
        StaffDetail staffDetail = jsonObject.toJavaObject(StaffDetail.class);
        // 根据用户名查找用户信息
        String staffDetailResult = staffDetailMapper.getUserPassword(loginUserVO.getUsername());
        if (staffDetailResult != null) {
            boolean flag = new BCryptPasswordEncoder().matches(loginUserVO.getPassword(), staffDetailResult);
            if (!flag) {
                throw new ExtenException("updateUser", ResultEnum.UNKNOWN_USER.getCode(),
                        ResultEnum.UNKNOWN_USER.getMsg());
            }else {
                return new ResultVO();
            }
        }
        return new ResultVO(ResultEnum.UNKNOWN_USER.getCode(), ResultEnum.UNKNOWN_USER.getMsg());
    }

    @Override
    public ResultVO getEmail(String email) {

        StaffDetailVO staffDetail = staffDetailMapper.getEmail(email);
        logger.info("UserServiceImpl getEmail end ... result:{}", staffDetail);
        if (staffDetail != null) {
            return new ResultVO();
        }
        return new ResultVO(ResultEnum.UNKNOWN_USER_EMAIL.getCode(), ResultEnum.UNKNOWN_USER_EMAIL.getMsg());
    }

    @Override
    public StaffDetailVO getUser(QueryUserVO queryUserVO) {

        JSONObject jsonObject = (JSONObject) JSON.toJSON(queryUserVO);
        StaffDetail staffDetail = jsonObject.toJavaObject(StaffDetail.class);
        // 根据用户名查找用户信息
        StaffDetailVO staffDetailResult = staffDetailMapper.getStaffDetail(staffDetail);
        return staffDetailResult;
    }

    @Override
    public StaffDetailVO getUserByEmpId(String empId) {

        StaffDetailVO staffDetailByEmpId = staffDetailMapper.getStaffDetailByEmpId(empId);
        return staffDetailByEmpId;
    }

    @Override
    public List<StaffDetailVO> getAllUser() {

//        staffDetailMapper.get
        return null;
    }

    @Override
    public IPage<AllStaffDetailVO> getAllUserPage(AllStaffDetailVO allStaffDetailVO, int page, int pageSize) {

        Page<AllStaffDetailVO> staffDetailVOPage = new Page<>(page, pageSize);
        staffDetailVOPage.setRecords(staffDetailMapper.getPageUser(staffDetailVOPage, allStaffDetailVO));
        return staffDetailVOPage;
    }

    @Override
    public IPage<AllStaffDetailVO> getUserByDept(String deptName, int page, int pageSize) {

        Page<AllStaffDetailVO> staffDetailVOPage = new Page<>(page, pageSize);
        staffDetailVOPage.setRecords(staffDetailMapper.getPageUserByDept(staffDetailVOPage, deptName));
        return staffDetailVOPage;
    }

    @Override
    public void updateUser(StaffDetailVO staffDetailVO) {

        int result = staffDetailMapper.updateStaffDate(staffDetailVO);
        if (result != 1) {
            throw new ExtenException("updateUser", ExceptionEnum.UNEXPECTED_ERROR.getCode(),
                    ExceptionEnum.UNEXPECTED_ERROR.getMessage());
        }
    }

    @Override
    public void addStaffRole(StaffRole staffRole) {

    }

    @Override
    public ResultVO updateUserByEmail(UpdateUserPwdVO updateUserPwdVO) {

        int result = staffDetailMapper.updateUserByEmail(updateUserPwdVO);
        if (result != 1) {
            new ResultVO(ExceptionEnum.UNEXPECTED_ERROR.getCode(), ExceptionEnum.UNEXPECTED_ERROR.getMessage());
        }
        return new ResultVO();
    }

    @Override
    public ResultVO getUserByName(String empName) {

        List<StaffDetailAllUserVO> userByName = staffDetailMapper.getUserByName(empName);
        return new ResultVO(userByName);
    }

    @Override
    public ResultVO getUserByEmail(String email) {

        List<StaffDetailVO> userByEmail = staffDetailMapper.getUserByEmail(email);
        return new ResultVO(userByEmail);
    }

    @Override
    public ResultVO updateUserFace(UpdateUserFaceVO updateUserFaceVO) {

        staffDetailMapper.updateUserFace(updateUserFaceVO);

        return new ResultVO();
    }

    @Autowired
    private IStaffDeptMapper staffStaffDept;

    @Autowired
    private IStaffRoleMapper staffRoleMapper;

    @Autowired
    private IStaffWagesMapper staffWagesMapper;

    @Override
    public ResultVO deleteUser(StaffUserVO staffUserVO) {

        // 使employee_staff_base_t表数据失效
        staffBaseMapper.updateUserStatus(staffUserVO.getEmpId());
        // 使employee_staff_detail_t表数据失效
        staffDetailMapper.updateUserStatus(staffUserVO.getUserId());
        // 使employee_staff_dept_t表数据失效
        staffStaffDept.updateStatus(staffUserVO.getEmpId());
        // 使employee_staff_role_t表数据失效
        staffRoleMapper.updateStatus(staffUserVO.getUserId());
        // 使employee_staff_wages_t表数据失效
        staffWagesMapper.updateStatus(staffUserVO.getEmpId());
        return new ResultVO();
    }

    @Override
    public ResultVO getAllSuperEmp() {

        List<StaffBaseVO> allSuperEmp = staffBaseMapper.getAllSuperEmp();
        return new ResultVO(allSuperEmp);
    }
}