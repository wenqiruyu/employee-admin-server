package com.employee.admin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 项目名称：employee-admin-server
 * 类名称：StaffLeave
 * 类描述：TDD
 * 创建人：yingx
 * 创建时间： 2020/4/9
 * 修改人：yingx
 * 修改时间： 2020/4/9
 * 修改备注：
 */
public class StaffLeave {

    private Long id;
    /** 用户id 用于后台系统*/
    private Long userId;
    /** 员工号*/
    private String empId;
    /** 员工号*/
    private String empName;
    /** 开始时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    /** 结束时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    /** 请假类型*/
    private String leaveType;
    /** 請假原因*/
    private String leaveReason;
    /** 直系上级员工号*/
    private String superEmpId;
    /** 直系上级员工名*/
    private String superEmpName;
    /** 上级员工号*/
    private String superPlusEmpId;
    /** 上级员工名*/
    private String superPlusEmpName;
    /** 流程状态 0审批未通过 1直系未审批 2直系通过上级未审批 3上级审批通过*/
    private String procedureFlag;
    /** 请假详情*/
    private String leaveDetail;

    private Integer deleteFlag;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public String getSuperEmpId() {
        return superEmpId;
    }

    public void setSuperEmpId(String superEmpId) {
        this.superEmpId = superEmpId;
    }

    public String getSuperEmpName() {
        return superEmpName;
    }

    public void setSuperEmpName(String superEmpName) {
        this.superEmpName = superEmpName;
    }

    public String getSuperPlusEmpId() {
        return superPlusEmpId;
    }

    public void setSuperPlusEmpId(String superPlusEmpId) {
        this.superPlusEmpId = superPlusEmpId;
    }

    public String getSuperPlusEmpName() {
        return superPlusEmpName;
    }

    public void setSuperPlusEmpName(String superPlusEmpName) {
        this.superPlusEmpName = superPlusEmpName;
    }

    public String getProcedureFlag() {
        return procedureFlag;
    }

    public void setProcedureFlag(String procedureFlag) {
        this.procedureFlag = procedureFlag;
    }

    public String getLeaveDetail() {
        return leaveDetail;
    }

    public void setLeaveDetail(String leaveDetail) {
        this.leaveDetail = leaveDetail;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "StaffLeave{" +
                "userId=" + userId +
                ", empId='" + empId + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", leaveType='" + leaveType + '\'' +
                ", leaveReason='" + leaveReason + '\'' +
                ", superEmpId=" + superEmpId +
                ", superEmpName=" + superEmpName +
                ", superPlusEmpId=" + superPlusEmpId +
                ", superPlusEmpName=" + superPlusEmpName +
                ", procedureFlag=" + procedureFlag +
                ", leaveDetail=" + leaveDetail +
                '}';
    }
}
