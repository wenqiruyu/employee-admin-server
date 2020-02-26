package com.employee.admin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.employee.admin.entity.StaffDetail;
import com.employee.admin.enums.ExceptionEnum;
import com.employee.admin.exception.ExtenException;
import com.employee.admin.mapper.IStaffDetailMapper;
import com.employee.admin.service.IMenuService;
import com.employee.admin.vo.MenuVO;
import com.employee.admin.vo.QueryUserVO;
import com.employee.admin.vo.ResultVO;
import com.employee.admin.vo.StaffDetailVO;
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
    private IStaffDetailMapper staffDetailMapper;

    @Autowired
    private IMenuService menuService;

    /**
      * 获取用户的相应菜单列表
      *
      * @param queryUserVO
      * @return com.employee.admin.vo.ResultVO
      * @author yingx
      * @date 2020/2/18
     */
    @PostMapping("/getMenu")
    @CrossOrigin
    public ResultVO getMenu(@RequestBody QueryUserVO queryUserVO) {

        logger.info("MenusController getMenu start ... Username:{}, UserId:{}",
                queryUserVO.getUsername(), queryUserVO.getUserId());
        if (StringUtils.isBlank(queryUserVO.getUserId() + "") && StringUtils.isBlank(queryUserVO.getUsername())) {
            throw new ExtenException("getMenu", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
        // 处理不传userId的情况
        if (queryUserVO.getUserId() == null) {
            JSONObject jsonObject = (JSONObject) JSON.toJSON(queryUserVO);
            StaffDetail staffDetail = jsonObject.toJavaObject(StaffDetail.class);
            // 根据用户名查找用户信息
            StaffDetailVO staffDetailResult = staffDetailMapper.getStaffDetail(staffDetail);
            queryUserVO.setUserId(Long.parseLong(staffDetailResult.getUserId()));
        }
        List<MenuVO> menuByUser = menuService.getMenuByUser(queryUserVO);
        logger.info("MenusController getMenu end ... result:{}", menuByUser);
        return new ResultVO(menuByUser);
    }
}
