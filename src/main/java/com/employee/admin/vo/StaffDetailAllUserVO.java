package com.employee.admin.vo;

import java.time.LocalDateTime;

/**
 * 项目名称：employee-admin-server
 * 类名称：StaffDetailAllUserVO
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2020/1/3
 * 修改人：yingx
 * 修改时间： 2020/1/3
 * 修改备注：
 */
public class StaffDetailAllUserVO {

    /**
     * 员工id
     */
    private String empId;

    /** 员工名*/
    private String empName;

    /**
     * 当天时间
     */
    private String attendanceTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getAttendanceTime() {
        return attendanceTime;
    }

    public void setAttendanceTime(String attendanceTime) {
        this.attendanceTime = attendanceTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "StaffDetailAllUserVO{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", attendanceTime='" + attendanceTime + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
