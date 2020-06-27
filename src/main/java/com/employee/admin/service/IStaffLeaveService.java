package com.employee.admin.service;

import com.employee.admin.entity.StaffLeave;
import com.employee.admin.vo.QueryUserVO;
import com.employee.admin.vo.ResultVO;

/**
 * 项目名称：employee-admin-server
 * 类名称：IStaffLeaveService
 * 类描述：TDD
 * 创建人：yingx
 * 创建时间： 2020/4/9
 * 修改人：yingx
 * 修改时间： 2020/4/9
 * 修改备注：
 */
public interface IStaffLeaveService {

    ResultVO addStaffLeave(StaffLeave staffLeave);

    ResultVO getSubEmpLeave(QueryUserVO queryUserVO);

    ResultVO updateEmpLeave(Long id);

    ResultVO updateEmpLeaveError(Long id);

    ResultVO getEmpAllLeave(QueryUserVO queryUserVO);
}
