package com.employee.admin.controller;

import com.employee.admin.entity.StaffDetail;
import com.employee.admin.enums.ExceptionEnum;
import com.employee.admin.exception.ExtenException;
import com.employee.admin.mapper.IStaffDetailMapper;
import com.employee.admin.service.IStaffBaseService;
import com.employee.admin.service.IStaffDeptService;
import com.employee.admin.service.IUserService;
import com.employee.admin.vo.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：employee-admin-server
 * 类名称：StaffDeptController
 * 类描述：TDD
 * 创建人：yingx
 * 创建时间： 2020/2/24
 * 修改人：yingx
 * 修改时间： 2020/2/24
 * 修改备注：
 */
@RestController
@RequestMapping("/staffDept")
public class StaffDeptController {

    private static final Logger logger = LoggerFactory.getLogger(StaffDeptController.class);

    @Autowired
    private IUserService userService;

    @Autowired
    private IStaffBaseService staffBaseService;

    @Autowired
    private IStaffDeptService staffDeptService;

    @Autowired
    private IStaffDetailMapper staffDetailMapper;

    @PostMapping("/getSubEmp")
    @CrossOrigin
    public ResultVO getSubEmp(@RequestBody QueryUserVO queryUserVO){

        logger.info("StaffDeptController getSubEmp start ... QueryUserVO:{}", queryUserVO);
        if (StringUtils.isBlank(queryUserVO.getUsername()) && StringUtils.isBlank(queryUserVO.getUserId() + "")) {
            throw new ExtenException("getSubEmp", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
        // 通过用户名查询用户id
        if (queryUserVO.getUserId() == null) {
            StaffDetailVO user = userService.getUser(queryUserVO);
            queryUserVO.setUserId(Long.parseLong(user.getUserId()));
        }
        // 根据用户id查询用户员工号
        StaffBaseVO staffBaseByUser = staffBaseService.getStaffBaseByUser(queryUserVO);
        List<StaffDeptVO> subEmp = staffDeptService.getSubEmp(staffBaseByUser.getEmpId());
        logger.info("StaffDeptController getSubEmp end ... Result:{}", subEmp);
        return new ResultVO(subEmp);
    }

    /**
     * 获取上级员工
     *
     * @param queryUserVO
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2020/4/6
     */
    @PostMapping("/getSuperEmp")
    @CrossOrigin
    public ResultVO getSuperEmp(@RequestBody QueryUserVO queryUserVO) {

        logger.info("StaffBaseController getSuperEmp start ...");
        if (queryUserVO == null) {
            throw new ExtenException("getSuperEmp", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
        // 处理不传userId的情况
        if (queryUserVO.getUserId() == null) {
            StaffDetail staffDetail = new StaffDetail();
            staffDetail.setUsername(queryUserVO.getUsername());
            // 根据用户名查找用户信息
            StaffDetailVO staffDetailResult = staffDetailMapper.getStaffDetail(staffDetail);
            queryUserVO.setUserId(Long.parseLong(staffDetailResult.getUserId()));
        }
        // 获取用户一级上级员工
        StaffDeptVO superEmp = staffDeptService.getSuperEmp(queryUserVO);
        // 获取员工二级上级员工
        StaffDeptVO staffDept = staffDeptService.getStaffDept(superEmp.getSuperEmpId());

        if (superEmp.getSuperEmpId() == null) {
            throw new ExtenException("getSuperEmp", ExceptionEnum.UNEXPECTED_ERROR.getCode(),
                    "管理员账号请勿进行请假操作哦");
        }

        StaffBaseVO staffBaseByEmp = staffBaseService.getStaffBaseByEmp(new EmpParamVO(superEmp.getSuperEmpId(), null));

        List<GetSuperEmpVO> list = new ArrayList<>();

        list.add(new GetSuperEmpVO(staffBaseByEmp.getEmpId(), staffBaseByEmp.getEmpName()));
        if (staffDept != null && staffDept.getSuperEmpId() != null) {
            StaffBaseVO staffBaseByEmpSuper = staffBaseService.getStaffBaseByEmp(new EmpParamVO(staffDept.getSuperEmpId(), null));
            if (staffBaseByEmpSuper != null) {
                list.add(new GetSuperEmpVO(staffBaseByEmpSuper.getEmpId(), staffBaseByEmpSuper.getEmpName()));
            }
        }

        logger.info("StaffBaseController getSuperEmp end ... result:{}", list);
        return new ResultVO(list);
    }

    /**
     * 修改上级员工
     *
     * @param staffDeptVO
     * @return com.employee.admin.vo.ResultVO
     * @author yingx
     * @date 2020/4/6
     */
    @PostMapping("/updateEmpSuper")
    @CrossOrigin
    public ResultVO updateEmpSuper(@RequestBody StaffDeptVO staffDeptVO) {

        logger.info("StaffBaseController updateEmpSuper start ... staffDeptVO:{}", staffDeptVO);
        if (staffDeptVO == null) {
            throw new ExtenException("getSuperEmp", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
        // 获取该员工的下级名单
        List<StaffDeptVO> subEmp = staffDeptService.getSubEmp(staffDeptVO.getEmpId());
        List<StaffDeptVO> newSta = new ArrayList<>();
        for (StaffDeptVO sta : subEmp) {
            StaffDeptVO staffDept = new StaffDeptVO();
            staffDept.setEmpId(sta.getEmpId());
            staffDept.setSuperEmpId(staffDeptVO.getSuperEmpId());
            newSta.add(staffDept);
        }

        if (newSta != null && newSta.size() > 0) {

            ResultVO resultVO = staffDeptService.updateEmpSuper(newSta);
            return resultVO;
        }
        return new ResultVO();
    }
}
