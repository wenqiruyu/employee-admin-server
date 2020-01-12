package com.employee.admin.vo;

/**
 * 项目名称：employee-admin-server
 * 类名称：StaffRoleVO
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2019/12/24
 * 修改人：yingx
 * 修改时间： 2019/12/24
 * 修改备注：
 */
public class StaffRoleVO {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 权限id
     */
    private String roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "StaffRoleVO{" +
                "userId=" + userId +
                ", roleId='" + roleId + '\'' +
                '}';
    }
}
