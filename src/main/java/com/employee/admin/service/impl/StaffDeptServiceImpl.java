package com.employee.admin.service.impl;

import com.employee.admin.entity.StaffDept;
import com.employee.admin.enums.ExceptionEnum;
import com.employee.admin.exception.ExtenException;
import com.employee.admin.mapper.IStaffDeptMapper;
import com.employee.admin.service.IStaffDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 项目名称：employee-admin-server
 * 类名称：StaffDeptServiceImpl
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2020/1/7
 * 修改人：yingx
 * 修改时间： 2020/1/7
 * 修改备注：
 */
@Service
public class StaffDeptServiceImpl implements IStaffDeptService {

    @Autowired
    private IStaffDeptMapper staffDeptMapper;

    @Override
    public void addStaffDept(StaffDept staffDept) {

        int result = staffDeptMapper.addStaffDept(staffDept);
        if (result != 1) {
            throw new ExtenException("addStaffDept", ExceptionEnum.UNEXPECTED_ERROR.getCode(),
                    ExceptionEnum.UNEXPECTED_ERROR.getMessage());
        }
    }
}
