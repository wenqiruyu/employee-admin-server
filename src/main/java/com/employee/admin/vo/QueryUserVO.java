package com.employee.admin.vo;

/**
 * 项目名称：employee-admin-server
 * 类名称：QueryUserVo
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2019/12/24
 * 修改人：yingx
 * 修改时间： 2019/12/24
 * 修改备注：
 */
public class QueryUserVO {

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户昵称
     */
    private String username;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "QueryUserVO{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                '}';
    }
}
