package com.employee.admin.mapper;

import com.employee.admin.entity.StaffLeave;
import com.employee.admin.vo.QueryUserVO;

import java.util.List;

/**
 * 项目名称：employee-admin-server
 * 类名称：IStaffLeaveMapper
 * 类描述：TDD
 * 创建人：yingx
 * 创建时间： 2020/4/9
 * 修改人：yingx
 * 修改时间： 2020/4/9
 * 修改备注：
 */
public interface IStaffLeaveMapper {

    int addStaffLeave(StaffLeave staffLeave);

    List<StaffLeave> getSubEmpLeave(QueryUserVO queryUserVO);

    List<StaffLeave> getSubEmpLeaveByPlus(QueryUserVO queryUserVO);

    int updateEmpLeaveSuccess(Long id);

    int updateEmpLeave(Long id);

    int updateEmpLeaveError(Long id);

    StaffLeave getEmpLeaveById(Long id);

    List<StaffLeave> getEmpAllLeave(QueryUserVO queryUserVO);
}
