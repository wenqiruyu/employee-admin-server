package com.employee.admin.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 项目名称：employee-admin-server
 * 类名称：WorkAttendance
 * 类描述：职工工作出勤实体类
 * 创建人：yingx
 * 创建时间： 2019/12/30
 * 修改人：yingx
 * 修改时间： 2019/12/30
 * 修改备注：
 */
public class WorkAttendance {

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
    private String startTime;

    /**
     * 签退时间
     */
    private String endTime;

    /**
     * 签到电脑IP
     */
    private String startIp;

    /**
     * 签退电脑IP
     */
    private String endIp;

    /**
     * 考勤标识 0正常 1缺勤 2未签退 3早退 4迟到
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

    /**
     * 数据状态
     */
    private Integer deleteFlag;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 修改人
     */
    private String lastUpdateBy;

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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
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

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    @Override
    public String toString() {
        return "WorkAttendance{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", startIp='" + startIp + '\'' +
                ", endIp='" + endIp + '\'' +
                ", absenceDutyFlag=" + absenceDutyFlag +
                ", reason='" + reason + '\'' +
                ", attendanceTime='" + attendanceTime + '\'' +
                ", deleteFlag=" + deleteFlag +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", createBy='" + createBy + '\'' +
                ", lastUpdateBy='" + lastUpdateBy + '\'' +
                '}';
    }
}
