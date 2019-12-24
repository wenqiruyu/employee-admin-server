package com.employee.admin.service;

import com.employee.admin.entity.StaffRole;
import com.employee.admin.vo.QueryUserVO;
import com.employee.admin.vo.RegisterUserVO;
import com.employee.admin.vo.StaffDetailVO;

/**
 * 项目名称：employee-admin-server
 * 类名称：IUserService
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2019/12/24
 * 修改人：yingx
 * 修改时间： 2019/12/24
 * 修改备注：
 */
public interface IUserService {

    void userRegister(RegisterUserVO registerUserVO);

    StaffDetailVO getUser(QueryUserVO queryUserVO);

    void addStaffRole(StaffRole staffRole);
}
