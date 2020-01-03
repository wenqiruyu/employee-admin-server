package com.employee.admin.controller;

import com.employee.admin.enums.ExceptionEnum;
import com.employee.admin.exception.ExtenException;
import com.employee.admin.service.IMenuService;
import com.employee.admin.vo.MenuVO;
import com.employee.admin.vo.QueryUserVO;
import com.employee.admin.vo.ResultVO;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenusController {

    private static final Logger logger = LoggerFactory.getLogger(MenusController.class);

    @Autowired
    private IMenuService menuService;

    @PostMapping("/getMenu")
    @CrossOrigin
    public ResultVO getMenu(@RequestBody QueryUserVO queryUserVO) {

        logger.info("MenusController getMenu start ... Username:{}, UserId:{}",
                queryUserVO.getUsername(), queryUserVO.getUserId());
        if (StringUtils.isBlank(queryUserVO.getUserId()) && StringUtils.isBlank(queryUserVO.getUsername())) {
            throw new ExtenException("login", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
        List<MenuVO> menuByUser = menuService.getMenuByUser(queryUserVO);
        logger.info("MenusController getMenu end ... result:{}", menuByUser);
        return new ResultVO(menuByUser);
    }
}
