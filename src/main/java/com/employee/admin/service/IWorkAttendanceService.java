package com.employee.admin.service;

import com.employee.admin.entity.WorkAttendance;
import com.employee.admin.vo.WorkAttendanceVO;

import java.util.List;

/**
 * 项目名称：employee-admin-server
 * 类名称：IWorkAttendanceService
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2020/1/3
 * 修改人：yingx
 * 修改时间： 2020/1/3
 * 修改备注：
 */
public interface IWorkAttendanceService {

    List<WorkAttendanceVO> getAllWorkAttendance();

    void addAllStaffWages(List<WorkAttendance> workAttendanceList);
}