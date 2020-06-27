package com.employee.admin.entity;

/**
 * 项目名称：employee-admin-server
 * 类名称：EmailVerifyCode
 * 类描述：TDD
 * 创建人：yingx
 * 创建时间： 2020/5/7
 * 修改人：yingx
 * 修改时间： 2020/5/7
 * 修改备注：
 */
public class EmailVerifyCode {

    private String email;

    private String verifyCode;

    private Long startTime;

    private String emailMsg;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public String getEmailMsg() {
        return emailMsg;
    }

    public void setEmailMsg(String emailMsg) {
        this.emailMsg = emailMsg;
    }

    @Override
    public String toString() {
        return "EmailVerifyCode{" +
                "email='" + email + '\'' +
                ", verifyCode='" + verifyCode + '\'' +
                ", startTime=" + startTime +
                ", emailMsg='" + emailMsg + '\'' +
                '}';
    }
}
