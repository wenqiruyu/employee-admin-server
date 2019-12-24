package com.employee.admin.entity;

/**
 * 项目名称：employee-admin-server
 * 类名称：StaffDept
 * 类描述：员工部门映射表
 * 创建人：yingx
 * 创建时间： 2019/12/24
 * 修改人：yingx
 * 修改时间： 2019/12/24
 * 修改备注：
 */
public class StaffDept {

    /**
     * 用户表id
     */
    private Long userId;

    /**
     * 员工上级id
     */
    private Long superUserId;

    /**
     * 部门id
     */
    private Long deptId;
    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 数据状态
     */
    private Integer deleteFlag;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSuperUserId() {
        return superUserId;
    }

    public void setSuperUserId(Long superUserId) {
        this.superUserId = superUserId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public String toString() {
        return "StaffDept{" +
                "userId=" + userId +
                ", superUserId=" + superUserId +
                ", deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", deleteFlag=" + deleteFlag +
                '}';
    }
}
