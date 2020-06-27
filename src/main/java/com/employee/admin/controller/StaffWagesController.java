package com.employee.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.employee.admin.entity.StaffDetail;
import com.employee.admin.enums.ExceptionEnum;
import com.employee.admin.exception.ExtenException;
import com.employee.admin.mapper.IStaffDetailMapper;
import com.employee.admin.service.IStaffBaseService;
import com.employee.admin.service.IStaffWagesService;
import com.employee.admin.vo.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private IStaffDetailMapper staffDetailMapper;

    @Autowired
    private IStaffBaseService staffBaseService;

    /**
     * 批量添加员工薪资 发放工资
     *
     * @param staffWagesVO
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2020/1/6
     */
    @PostMapping("/addAllUserWages")
    @CrossOrigin
    public ResultVO addAllUserWages(@RequestBody StaffWagesVO staffWagesVO) {

        logger.info("StaffWagesController addAllUserWages start ...");
        if (staffWagesVO.getPeriod() == null) {
            throw new ExtenException("addAllUserWages", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }

        List<StaffWagesVO> wagesByPeriod = staffWagesService.getAllWagesByPeriod(staffWagesVO.getPeriod());

        if(wagesByPeriod != null && wagesByPeriod.size() != 0){
            logger.info("StaffWagesController addAllUserWages end ...Result:{}", wagesByPeriod);
            return new ResultVO(wagesByPeriod);
        }else{
            // 获取所有员工信息
            staffWagesService.addAllUserWages(staffWagesVO.getPeriod());
        }
        // 获取当月的薪资列表
        List<StaffWagesVO> allWagesByPeriod = staffWagesService.getAllWagesByPeriod(staffWagesVO.getPeriod());

        logger.info("StaffWagesController addAllUserWages end ...Result:{}", allWagesByPeriod);
        return new ResultVO(allWagesByPeriod);
    }

    /**
     * 批量添加员工薪资 发放工资
     *
     * @param staffWagesVOS
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2020/1/6
     */
    @PostMapping("/updateAllWages")
    @CrossOrigin
    public ResultVO updateAllWages(@RequestBody UpdateAllWagesVO updateAllWagesVO) {

        logger.info("StaffWagesController updateAllWages start ... param:{}", updateAllWagesVO.getStaffWagesVOS());
        if (updateAllWagesVO.getStaffWagesVOS() == null || updateAllWagesVO.getStaffWagesVOS().size() == 0) {
            throw new ExtenException("updateAllWages", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }

        staffWagesService.updateAllWages(updateAllWagesVO.getStaffWagesVOS());

        logger.info("StaffWagesController updateAllWages end ...");
        return new ResultVO();
    }

    /**
     * 单人发放工资
     *
     * @param staffWagesVO
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2020/1/6
     */
    @PostMapping("/addWages")
    @CrossOrigin
    public ResultVO addWages(@RequestBody StaffWagesVO staffWagesVO) {

        logger.info("StaffWagesController addWages start ...");
        if (staffWagesVO == null) {
            throw new ExtenException("addWages", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
        staffWagesService.addStaffWages(staffWagesVO);
        logger.info("StaffWagesController addWages end ...");
        return new ResultVO();
    }

    /**
     * 管理员获取全部员工薪资信息
     *
     * @param
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2020/1/6
     */
    @PostMapping("/getAllWages")
    @CrossOrigin
    public ResultVO getAllWages(@RequestBody PageVO pageVO) {

        logger.info("StaffWagesController getAllWages start ...");
        List<StaffWagesVO> records;
        try {
            IPage<StaffWagesVO> allStaffWages = staffWagesService.getAllStaffWages(new StaffWagesVO(), pageVO.getPage(), pageVO.getPageSize());
            records = allStaffWages.getRecords();
        } catch (Exception e) {
            logger.error("UserController getAllUser error ...", e);
            throw new ExtenException("getAllUser", ExceptionEnum.UNEXPECTED_ERROR.getCode(), ExceptionEnum.UNEXPECTED_ERROR.getMessage());
        }
        logger.info("StaffWagesController getAllWages end ... result:{}", records);
        return new ResultVO(records);
    }

    /**
     * 管理员获取全部员工薪资信息
     *
     * @param
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2020/1/6
     */
    @PostMapping("/getWagesByEmpName")
    @CrossOrigin
    public ResultVO getWagesByEmpName(@RequestBody EmpParamVO empParamVO) {

        logger.info("StaffWagesController getWagesByEmpName start ...empName:{}", empParamVO.getEmpName());

        ResultVO wagesByEmpName = staffWagesService.getWagesByEmpName(empParamVO);

        return wagesByEmpName;
    }

    /**
     * 员工获取本人薪资信息
     *
     * @param getWages
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2020/1/6
     */
    @PostMapping("/getWages")
    @CrossOrigin
    public ResultVO getWages(@RequestBody GetWages getWages) {

        logger.info("StaffWagesController getWages start ...");
        if (getWages == null) {
            throw new ExtenException("getWages", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }

        StaffDetail staffDetail = new StaffDetail();
        staffDetail.setUsername(getWages.getUsername());
        // 根据用户名查找用户信息
        StaffDetailVO staffDetailResult = staffDetailMapper.getStaffDetail(staffDetail);

        QueryUserVO queryUserVO = new QueryUserVO();
        queryUserVO.setUserId(Long.parseLong(staffDetailResult.getUserId()));
        StaffBaseVO staffBaseByUser = staffBaseService.getStaffBaseByUser(queryUserVO);

        IPage<StaffWagesVO> staffWagesByUserId = staffWagesService.getStaffWagesByUserId(staffBaseByUser.getEmpId(),
                getWages.getPage(), getWages.getPageSize());
        List<StaffWagesVO> records = staffWagesByUserId.getRecords();
        logger.info("StaffWagesController getWages end ... result:{}", records);
        return new ResultVO(records);
    }
}
