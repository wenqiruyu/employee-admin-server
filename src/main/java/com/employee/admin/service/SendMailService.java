package com.employee.admin.service;

import com.employee.admin.vo.ResultVO;
import com.employee.admin.vo.SendMailVO;

/**
 * 项目名称：wen-item
 * 类名称：SendMailService
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2020/3/25
 * 修改人：yingx
 * 修改时间： 2020/3/25
 * 修改备注：
 */
public interface SendMailService {

    ResultVO sendMail(SendMailVO sendMailVO);
}
