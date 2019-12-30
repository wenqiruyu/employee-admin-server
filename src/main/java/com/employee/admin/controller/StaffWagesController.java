package com.employee.admin.controller;

import com.employee.admin.enums.ExceptionEnum;
import com.employee.admin.exception.ExtenException;
import com.employee.admin.service.IStaffWagesService;
import com.employee.admin.vo.QueryUserVO;
import com.employee.admin.vo.ResultVO;
import com.employee.admin.vo.StaffWagesVO;
import org.apache.commons.lang.StringUtils;
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
 * 类名称：StaffWagesController
 * 类描述：职工薪资Cotroller类
 * 创建人：yingx
 * 创建时间： 2019/12/26
 * 修改人：yingx
 * 修改时间： 2019/12/26
 * 修改备注：
 */

@RestController
@RequestMapping("/wages")
public class StaffWagesController {

    private static final Logger logger = LoggerFactory.getLogger(StaffWagesController.class);

    @Autowired
    private IStaffWagesService staffWagesService;

    @PostMapping("/addAllWages")
    @CrossOrigin
    public ResultVO addAllWages(List<StaffWagesVO> staffWagesVOS) {

        logger.info("StaffWagesController addAllWages start ...");
        if (staffWagesVOS == null || staffWagesVOS.size() == 0) {
            throw new ExtenException("addAllWages", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
        staffWagesService.addAllStaffWages(staffWagesVOS);
        logger.info("StaffWagesController addAllWages end ...");
        return new ResultVO();
    }

    @PostMapping("/addWages")
    @CrossOrigin
    public ResultVO addWages(StaffWagesVO staffWagesVO) {

        logger.info("StaffWagesController addWages start ...");
        if (staffWagesVO == null) {
            throw new ExtenException("addWages", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
        staffWagesService.addStaffWages(staffWagesVO);
        logger.info("StaffWagesController addWages end ...");
        return new ResultVO();
    }

    @PostMapping("/getAllWages")
    @CrossOrigin
    public ResultVO getAllWages() {

        logger.info("StaffWagesController getAllWages start ...");
        List<StaffWagesVO> allStaffWages = staffWagesService.getAllStaffWages();
        logger.info("StaffWagesController getAllWages end ... result:{}", allStaffWages);
        return new ResultVO(allStaffWages);
    }

    @PostMapping("/getWages")
    @CrossOrigin
    public ResultVO getWages(QueryUserVO queryUserVO) {

        logger.info("StaffWagesController getWages start ...");
        if (StringUtils.isBlank(queryUserVO.getUserId().toString())) {
            throw new ExtenException("getWages", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
        List<StaffWagesVO> allStaffWages = staffWagesService.getAllStaffWages();
        logger.info("StaffWagesController getWages end ... result:{}", allStaffWages);
        return new ResultVO(allStaffWages);
    }
}
