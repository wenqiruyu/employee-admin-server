package com.employee.admin.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.employee.admin.entity.StaffBase;
import com.employee.admin.entity.StaffDetail;
import com.employee.admin.enums.ExceptionEnum;
import com.employee.admin.exception.ExtenException;
import com.employee.admin.mapper.IStaffBaseMapper;
import com.employee.admin.service.IStaffBaseService;
import com.employee.admin.vo.EmpParamVO;
import com.employee.admin.vo.QueryUserVO;
import com.employee.admin.vo.StaffBaseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 项目名称：employee-admin-server
 * 类名称：StaffBaseServiceImpl
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2019/12/27
 * 修改人：yingx
 * 修改时间： 2019/12/27
 * 修改备注：
 */
@Service
public class StaffBaseServiceImpl implements IStaffBaseService {

    @Autowired
    private IStaffBaseMapper staffBaseMapper;

    @Override
    public void addStaffBase(StaffBaseVO staffBaseVO) {

        JSONObject jsonObject = (JSONObject) JSON.toJSON(staffBaseVO);
        StaffBase staffBase = jsonObject.toJavaObject(StaffBase.class);
        staffBase.setDeleteFlag(0);
        staffBase.setCreateTime(LocalDateTime.now());
        int result = staffBaseMapper.addStaffBase(staffBase);
        if (result != 1) {
            throw new ExtenException("addStaffBase", ExceptionEnum.UNEXPECTED_ERROR.getCode(),
                    ExceptionEnum.UNEXPECTED_ERROR.getMessage());
        }
    }

    @Override
    public StaffBaseVO getStaffBase(StaffBaseVO staffBaseVO) {

        StaffBaseVO staffBase = staffBaseMapper.getStaffBase(staffBaseVO);
        return staffBase;
    }

    @Override
    public StaffBaseVO getStaffBaseByEmp(EmpParamVO empParamVO) {

        StaffBaseVO staffBaseByEmp = staffBaseMapper.getStaffBaseByEmp(empParamVO);
        return staffBaseByEmp;
    }

    @Override
    public StaffBaseVO getStaffBaseByUser(QueryUserVO queryUserVO) {

        StaffBaseVO staffBaseByUser = staffBaseMapper.getStaffBaseByUser(queryUserVO);
        return staffBaseByUser;
    }
}
