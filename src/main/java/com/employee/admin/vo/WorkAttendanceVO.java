package com.employee.admin.vo;

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
     * 用户ID
     */
    private Long userId;

    /**
     * 签到时间
     */
    private LocalDateTime startTime;

    /**
     * 签退时间
     */
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
     * 缺勤原因
     */
    private String reason;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "WorkAttendanceVO{" +
                "userId=" + userId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", startIp='" + startIp + '\'' +
                ", endIp='" + endIp + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
