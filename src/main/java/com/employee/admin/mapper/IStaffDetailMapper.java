package com.employee.admin.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.employee.admin.entity.StaffDetail;
import com.employee.admin.vo.*;

import java.util.List;

/**
 * 项目名称：employee-admin-server
 * 类名称：IStaffDetailMapper
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2019/12/24
 * 修改人：yingx
 * 修改时间： 2019/12/24
 * 修改备注：
 */
public interface IStaffDetailMapper {

    List<StaffDetailAllUserVO> getAllUserId();

    void addStaffDetail(StaffDetail staffDetail);

    String getUserPassword(String username);

    StaffDetailVO getStaffDetail(StaffDetail staffDetail);

    StaffDetailVO getStaffDetailByEmpId(String empId);

    List<AllStaffDetailVO> getPageUser(Page<AllStaffDetailVO> venusUserPage, AllStaffDetailVO venusUser);

    List<AllStaffDetailVO> getPageUserByDept(Page<AllStaffDetailVO> venusUserPage, String deptName);

    int updateStaffDate(StaffDetailVO staffDetailVO);

    StaffDetailVO getEmail(String email);

    int updateUserByEmail(UpdateUserPwdVO updateUserPwdVO);

    List<StaffDetailAllUserVO> getUserByName(String empName);

    List<StaffDetailVO> getUserByEmail(String email);

    void updateUserFace(UpdateUserFaceVO updateUserFaceVO);

    void updateUserStatus(Long userId);
}
