package com.employee.admin.service;

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

    void addStaffBase(StaffBaseVO staffBaseVO);

    StaffBaseVO getStaffBase(StaffBaseVO staffBaseVO);
}
