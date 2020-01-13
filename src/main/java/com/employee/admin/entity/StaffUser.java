package com.employee.admin.entity;

/**
 * 项目名称：employee-admin-server
 * 类名称：StaffUser
 * 类描述：员工号和用户id的关联表
 * 创建人：yingx
 * 创建时间： 2020/1/13
 * 修改人：yingx
 * 修改时间： 2020/1/13
 * 修改备注：
 */
public class StaffUser {

    /**
     * 员工号
     */
    private String empId;

    /**
     * 用户id
     */
    private Long userId;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "StaffUser{" +
                "empId='" + empId + '\'' +
                ", userId=" + userId +
                '}';
    }
}
