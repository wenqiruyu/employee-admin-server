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
import com.employee.admin.mapper.IStaffBaseMapper;
import com.employee.admin.mapper.IStaffDetailMapper;
import com.employee.admin.service.IUserService;
import com.employee.admin.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
    public void userLogin(LoginUserVO loginUserVO) {

        JSONObject jsonObject = (JSONObject) JSON.toJSON(loginUserVO);
        StaffDetail staffDetail = jsonObject.toJavaObject(StaffDetail.class);
        // 根据用户名查找用户信息
        String staffDetailResult = staffDetailMapper.getUserPassword(loginUserVO.getUsername());
        if (staffDetailResult != null) {
            boolean flag = new BCryptPasswordEncoder().matches(loginUserVO.getPassword(), staffDetailResult);
            if (!flag) {
                throw new ExtenException("updateUser", ResultEnum.UNKNOWN_USER.getCode(),
                        ResultEnum.UNKNOWN_USER.getMsg());
            }
        }
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
    public IPage<AllStaffDetailVO> getAllUser(AllStaffDetailVO allStaffDetailVO, int page, int pageSize) {

        Page<AllStaffDetailVO> staffDetailVOPage = new Page<>(page, pageSize);
        staffDetailVOPage.setRecords(staffDetailMapper.getPageUser(staffDetailVOPage, allStaffDetailVO));
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
}