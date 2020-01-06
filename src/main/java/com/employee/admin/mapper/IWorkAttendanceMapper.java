package com.employee.admin.mapper;

import com.employee.admin.entity.WorkAttendance;
import com.employee.admin.vo.QueryUserVO;
import com.employee.admin.vo.WorkAttendanceVO;

import java.util.List;

/**
 * 项目名称：employee-admin-server
 * 类名称：IWorkAttendanceMapper
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2020/1/3
 * 修改人：yingx
 * 修改时间： 2020/1/3
 * 修改备注：
 */
public interface IWorkAttendanceMapper {

    List<WorkAttendanceVO> getAllWorkAttendance();

    WorkAttendanceVO getWorkAttendance(QueryUserVO queryUserVO);

    int addAllWorkAttendance(List<WorkAttendance> workAttendanceList);
}