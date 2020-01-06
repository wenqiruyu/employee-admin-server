package com.employee.admin.vo;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 项目名称：employee-admin-server
 * 类名称：WorkAttendanceVO
 * 类描述：职工出勤记录
 * 创建人：yingx
 * 创建时间： 2020/1/3
 * 修改人：yingx
 * 修改时间： 2020/1/3
 * 修改备注：
 */
public class WorkAttendanceVO {

    /**
     * 员工号
     */
    private String empId;

    /**
     * 员工姓名
     */
    private String empName;

    /**
     * 签到时间
     */
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalDateTime startTime;

    /**
     * 签退时间
     */
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalDateTime endTime;

    /**
     * 签到电脑IP
     */
    private String startIp;

    /**
     * 签退电脑IP
     */
    private String endIp;

    /**
     * 考勤标识
     */
    private Integer absenceDutyFlag;

    /**
     * 缺勤原因
     */
    private String reason;

    /**
     * 考勤日期
     */
    private String attendanceTime;

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

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getStartIp() {
        return startIp;
    }

    public void setStartIp(String startIp) {
        this.startIp = startIp;
    }

    public String getEndIp() {
        return endIp;
    }

    public void setEndIp(String endIp) {
        this.endIp = endIp;
    }

    public Integer getAbsenceDutyFlag() {
        return absenceDutyFlag;
    }

    public void setAbsenceDutyFlag(Integer absenceDutyFlag) {
        this.absenceDutyFlag = absenceDutyFlag;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getAttendanceTime() {
        return attendanceTime;
    }

    public void setAttendanceTime(String attendanceTime) {
        this.attendanceTime = attendanceTime;
    }

    @Override
    public String toString() {
        return "WorkAttendanceVO{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", startIp='" + startIp + '\'' +
                ", endIp='" + endIp + '\'' +
                ", absenceDutyFlag=" + absenceDutyFlag +
                ", reason='" + reason + '\'' +
                ", attendanceTime='" + attendanceTime + '\'' +
                '}';
    }
}
