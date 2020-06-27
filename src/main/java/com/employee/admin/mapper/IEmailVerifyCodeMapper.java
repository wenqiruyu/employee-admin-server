package com.employee.admin.mapper;

import com.employee.admin.entity.EmailVerifyCode;

/**
 * 项目名称：employee-admin-server
 * 类名称：IEmailVerifyCodeMapper
 * 类描述：TDD
 * 创建人：yingx
 * 创建时间： 2020/5/7
 * 修改人：yingx
 * 修改时间： 2020/5/7
 * 修改备注：
 */
public interface IEmailVerifyCodeMapper {

    void insertEmailVerifyCode(EmailVerifyCode emailVerifyCode);

    EmailVerifyCode getEmailVerifyCode(String email);

    void updateEmailVerifyCodeStatus(EmailVerifyCode emailVerifyCode);
}
