package com.employee.admin.vo;

/**
 * 项目名称：employee-admin-server
 * 类名称：StaffUserVO
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2020/1/13
 * 修改人：yingx
 * 修改时间： 2020/1/13
 * 修改备注：
 */
public class StaffUserVO {

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
        return "StaffUserVO{" +
                "empId='" + empId + '\'' +
                ", userId=" + userId +
                '}';
    }
}
