package com.employee.admin.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.employee.admin.entity.WorkAttendance;
import com.employee.admin.vo.*;
import org.apache.ibatis.annotations.Param;

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

    MonthWorkAttendanceVO getMonthWorkAttendance(MonthWorkAttendanceParam monthWorkAttendanceParam);

    List<WorkAttendanceVO> getUserWorkAttendance(Page<WorkAttendanceVO> workAttendanceVOPage, @Param("empId")String empId);

    List<WorkAttendanceVO> getUserSubEmpWorkAttendance(Page<WorkAttendanceVO> workAttendanceVOPage, List<StaffDeptVO> staffDeptVOS);

    int updateWorkAttendance(WorkAttendance workAttendance);

    int addWorkAttendance(WorkAttendance workAttendance);

    int addAllWorkAttendance(List<WorkAttendance> workAttendanceList);

    void updateAbsenceDuty(List<WorkAttendanceVO> allWorkAttendance);

    List<WorkAttendanceVO> getAllWorkAttendanceByDate(String attendanceTime);
}