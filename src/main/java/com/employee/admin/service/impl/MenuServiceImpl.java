package com.employee.admin.service.impl;

import com.employee.admin.mapper.IMenuMapper;
import com.employee.admin.service.IMenuService;
import com.employee.admin.vo.MenuVO;
import com.employee.admin.vo.QueryUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目名称：employee-admin-server
 * 类名称：MenuServiceImpl
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2019/12/25
 * 修改人：yingx
 * 修改时间： 2019/12/25
 * 修改备注：
 */
@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private IMenuMapper menuMapper;

    @Override
    public List<MenuVO> getAllMenu() {

        List<MenuVO> allMenu = menuMapper.getAllMenu();
        return allMenu;
    }

    @Override
    public List<MenuVO> getMenuByUser(QueryUserVO queryUserVO) {

        List<MenuVO> menuByUser = menuMapper.getMenuByUser(queryUserVO);
        return menuByUser;
    }
}
