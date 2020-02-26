package com.employee.admin.vo;

/**
 * 项目名称：employee-admin-server
 * 类名称：MonthWorkAttendanceVO
 * 类描述：TDD
 * 创建人：yingx
 * 创建时间： 2020/2/21
 * 修改人：yingx
 * 修改时间： 2020/2/21
 * 修改备注：
 */
public class MonthWorkAttendanceVO {

    /**正常次数*/
    private Long normalNum;

    /**缺勤次数*/
    private Long lackNum;

    /**迟到次数*/
    private Long lateNum;

    /**早退次数*/
    private Long leaveEarlyNum;

    /**未签退*/
    private Long noSignBackNum;

    public Long getNormalNum() {
        return normalNum;
    }

    public void setNormalNum(Long normalNum) {
        this.normalNum = normalNum;
    }

    public Long getLackNum() {
        return lackNum;
    }

    public void setLackNum(Long lackNum) {
        this.lackNum = lackNum;
    }

    public Long getLateNum() {
        return lateNum;
    }

    public void setLateNum(Long lateNum) {
        this.lateNum = lateNum;
    }

    public Long getLeaveEarlyNum() {
        return leaveEarlyNum;
    }

    public void setLeaveEarlyNum(Long leaveEarlyNum) {
        this.leaveEarlyNum = leaveEarlyNum;
    }

    public Long getNoSignBackNum() {
        return noSignBackNum;
    }

    public void setNoSignBackNum(Long noSignBackNum) {
        this.noSignBackNum = noSignBackNum;
    }

    @Override
    public String toString() {
        return "MonthWorkAttendanceVO{" +
                "normalNum=" + normalNum +
                ", lackNum=" + lackNum +
                ", lateNum=" + lateNum +
                ", leaveEarlyNum=" + leaveEarlyNum +
                ", noSignBackNum=" + noSignBackNum +
                '}';
    }
}
