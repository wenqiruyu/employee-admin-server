package com.employee.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.employee.admin.entity.WorkAttendance;
import com.employee.admin.vo.*;

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

    WorkAttendanceVO getWorkAttendance(QueryUserVO queryUserVO);

    MonthWorkAttendanceVO getMonthWorkAttendance(MonthWorkAttendanceParam monthWorkAttendanceParam);

    IPage<WorkAttendanceVO> getUserWorkAttendance(WorkAttendanceVO workAttendanceVO, int page, int pageSize);

    IPage<WorkAttendanceVO> getUseSubEmpAttendance(List<StaffDeptVO> staffDeptVOS, int page, int pageSize);

    void updateWorkAttendance(WorkAttendance workAttendance);

    void addWorkAttendance(WorkAttendance workAttendance);

    void addAllWorkAttendance(List<WorkAttendance> workAttendanceList);
}
