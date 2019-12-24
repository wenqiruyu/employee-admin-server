package com.employee.admin.entity;

/**
 * 项目名称：employee-admin-server
 * 类名称：StaffRole
 * 类描述：员工角色映射
 * 创建人：yingx
 * 创建时间： 2019/12/24
 * 修改人：yingx
 * 修改时间： 2019/12/24
 * 修改备注：
 */
public class StaffRole {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 权限id
     */
    private Long roleId;

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

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public String toString() {
        return "StaffRole{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                ", deleteFlag=" + deleteFlag +
                '}';
    }
}
