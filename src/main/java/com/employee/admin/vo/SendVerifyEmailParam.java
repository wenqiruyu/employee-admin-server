package com.employee.admin.vo;

/**
 * 项目名称：employee-admin-server
 * 类名称：SendVerifyEmail
 * 类描述：TDD
 * 创建人：yingx
 * 创建时间： 2020/4/13
 * 修改人：yingx
 * 修改时间： 2020/4/13
 * 修改备注：
 */
public class SendVerifyEmailParam {

    private Long userId;

    private String username;

    private String email;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "SendVerifyEmailParam{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
