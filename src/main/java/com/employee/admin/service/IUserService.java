package com.employee.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.employee.admin.entity.StaffRole;
import com.employee.admin.vo.*;
import org.apache.tomcat.util.http.fileupload.FileItem;

import java.util.List;

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

    ResultVO userLogin(LoginUserVO loginUserVO);

    ResultVO getEmail(String email);

    StaffDetailVO getUser(QueryUserVO queryUserVO);

    StaffDetailVO getUserByEmpId(String empId);

    IPage<AllStaffDetailVO> getAllUser(AllStaffDetailVO allStaffDetailVO, int page, int pageSize);

    IPage<AllStaffDetailVO> getUserByDept(String deptName, int page, int pageSize);

    void updateUser(StaffDetailVO staffDetailVO);

    void addStaffRole(StaffRole staffRole);

    ResultVO updateUserByEmail(UpdateUserPwdVO updateUserPwdVO);

    ResultVO getUserByName(String empName);

    ResultVO getUserByEmail(String email);

    ResultVO updateUserFace(UpdateUserFaceVO updateUserFaceVO);

    ResultVO deleteUser(StaffUserVO staffUserVO);

    ResultVO getAllSuperEmp();
}
