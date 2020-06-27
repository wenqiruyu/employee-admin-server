package com.employee.admin.vo;

/**
 * 项目名称：employee-admin-server
 * 类名称：GetEmailVO
 * 类描述：TDD
 * 创建人：yingx
 * 创建时间： 2020/5/6
 * 修改人：yingx
 * 修改时间： 2020/5/6
 * 修改备注：
 */
public class GetEmailVO {

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "GetEmailVO{" +
                "email='" + email + '\'' +
                '}';
    }
}
