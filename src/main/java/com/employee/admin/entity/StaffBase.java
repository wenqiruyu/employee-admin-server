package com.employee.admin.entity;

import java.time.LocalDateTime;

/**
 * 项目名称：employee-admin-server
 * 类名称：StaffBase
 * 类描述：企业员工基础类
 * 创建人：yingx
 * 创建时间： 2019/12/20
 * 修改人：yingx
 * 修改时间： 2019/12/20
 * 修改备注：
 */
public class StaffBase {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 员工号
     */
    private String empId;

    /**
     * 员工姓名
     */
    private String empName;

    /**
     * 入职时间
     */
    private String participateTime;

    /**
     * 离职时间
     */
    private String leaveTime;

    /**
     * 离职原因
     */
    private String leaveReason;

    /**
     * 是否离职
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

    public String getParticipateTime() {
        return participateTime;
    }

    public void setParticipateTime(String participateTime) {
        this.participateTime = participateTime;
    }

    public String getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
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
        return "StaffBase{" +
                "userId=" + userId +
                ", empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", participateTime='" + participateTime + '\'' +
                ", leaveTime='" + leaveTime + '\'' +
                ", leaveReason='" + leaveReason + '\'' +
                ", deleteFlag=" + deleteFlag +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", createBy='" + createBy + '\'' +
                ", lastUpdateBy='" + lastUpdateBy + '\'' +
                '}';
    }
}
