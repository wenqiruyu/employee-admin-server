package com.employee.admin.service;

import com.employee.admin.vo.MenuVO;
import com.employee.admin.vo.QueryUserVO;

import java.util.List;

/**
 * 项目名称：employee-admin-server
 * 类名称：IMenuService
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2019/12/25
 * 修改人：yingx
 * 修改时间： 2019/12/25
 * 修改备注：
 */
public interface IMenuService {

    List<MenuVO> getAllMenu();

    List<MenuVO> getMenuByUser(QueryUserVO queryUserVO);
}
