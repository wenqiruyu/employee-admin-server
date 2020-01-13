package com.employee.admin.service.impl;

import com.employee.admin.entity.StaffRole;
import com.employee.admin.enums.ExceptionEnum;
import com.employee.admin.exception.ExtenException;
import com.employee.admin.mapper.IStaffRoleMapper;
import com.employee.admin.service.IStaffRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 项目名称：employee-admin-server
 * 类名称：StaffRoleServiceImpl
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2020/1/13
 * 修改人：yingx
 * 修改时间： 2020/1/13
 * 修改备注：
 */
@Service
public class StaffRoleServiceImpl implements IStaffRoleService {

    @Autowired
    private IStaffRoleMapper staffRoleMapper;

    @Override
    public void addStaffRole(StaffRole staffRole) {

        int result = staffRoleMapper.addStaffRole(staffRole);
        if (result != 1) {
            throw new ExtenException("addStaffRole", ExceptionEnum.UNEXPECTED_ERROR.getCode(),
                    ExceptionEnum.UNEXPECTED_ERROR.getMessage());
        }
    }
}
