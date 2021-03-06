package com.employee.admin.service;

import com.employee.admin.entity.StaffBase;
import com.employee.admin.vo.EmpParamVO;
import com.employee.admin.vo.QueryUserVO;
import com.employee.admin.vo.StaffBaseVO;

/**
 * 项目名称：employee-admin-server
 * 类名称：IStaffBaseService
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2019/12/27
 * 修改人：yingx
 * 修改时间： 2019/12/27
 * 修改备注：
 */
public interface IStaffBaseService {

    int getStaffBaseNum();

    void addStaffBase(StaffBase staffBase);

    StaffBaseVO getStaffBase(StaffBaseVO staffBaseVO);

    StaffBaseVO getStaffBaseByEmp(EmpParamVO empParamVO);

    StaffBaseVO getStaffBaseByUser(QueryUserVO queryUserVO);
}
