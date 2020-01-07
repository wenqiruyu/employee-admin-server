package com.employee.admin.controller;

import com.employee.admin.service.IDeptService;
import com.employee.admin.vo.DeptVO;
import com.employee.admin.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 项目名称：employee-admin-server
 * 类名称：DeptController
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2020/1/7
 * 修改人：yingx
 * 修改时间： 2020/1/7
 * 修改备注：
 */
@RestController
@RequestMapping("dept")
public class DeptController {

    private static final Logger logger = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private IDeptService deptService;

    /**
     * 获取部门列表
     *
     * @param
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2020/1/7
     */
    @PostMapping("/getAllDept")
    @CrossOrigin
    public ResultVO getAllDept() {

        logger.info("DeptController getAllDept start ...");
        List<DeptVO> allDept = deptService.getAllDept();
        logger.info("DeptController getAllDept end ... Result:{}", allDept);
        return new ResultVO(allDept);
    }
}
