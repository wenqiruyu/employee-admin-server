package com.employee.admin.vo;

/**
 * 项目名称：employee-admin-server
 * 类名称：StaffBaseVO
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2019/12/25
 * 修改人：yingx
 * 修改时间： 2019/12/25
 * 修改备注：
 */
public class StaffBaseVO {

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

    @Override
    public String toString() {
        return "StaffBaseVO{" +
                ", empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", participateTime='" + participateTime + '\'' +
                ", leaveTime='" + leaveTime + '\'' +
                ", leaveReason='" + leaveReason + '\'' +
                ", deleteFlag=" + deleteFlag +
                '}';
    }
}
