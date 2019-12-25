package com.employee.admin.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.employee.admin.entity.StaffDetail;
import com.employee.admin.entity.StaffRole;
import com.employee.admin.mapper.IStaffDetailMapper;
import com.employee.admin.service.IUserService;
import com.employee.admin.vo.QueryUserVO;
import com.employee.admin.vo.RegisterUserVO;
import com.employee.admin.vo.StaffDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public void userRegister(RegisterUserVO registerUserVO) {

        JSONObject jsonObject = (JSONObject) JSON.toJSON(registerUserVO);
        StaffDetail staffDetail = jsonObject.toJavaObject(StaffDetail.class);
        staffDetail.setDeleteFlag(0);
        staffDetailMapper.addStaffDetail(staffDetail);
    }

    @Override
    public StaffDetailVO getUser(QueryUserVO queryUserVO) {

        return null;
    }

    @Override
    public void addStaffRole(StaffRole staffRole) {

    }
}
