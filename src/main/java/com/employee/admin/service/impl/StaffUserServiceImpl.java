package com.employee.admin.service.impl;

import com.employee.admin.entity.StaffUser;
import com.employee.admin.enums.ExceptionEnum;
import com.employee.admin.exception.ExtenException;
import com.employee.admin.mapper.IStaffUserMapper;
import com.employee.admin.service.IStaffUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 项目名称：employee-admin-server
 * 类名称：StaffUserServiceImpl
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2020/1/13
 * 修改人：yingx
 * 修改时间： 2020/1/13
 * 修改备注：
 */
@Service
public class StaffUserServiceImpl implements IStaffUserService {

    @Autowired
    private IStaffUserMapper staffUserMapper;

    @Override
    public void addStaffUser(StaffUser staffUser) {

        int result = staffUserMapper.addStaffUser(staffUser);
        if (result != 1) {
            throw new ExtenException("addStaffUser", ExceptionEnum.UNEXPECTED_ERROR.getCode(),
                    ExceptionEnum.UNEXPECTED_ERROR.getMessage());
        }
    }
}
