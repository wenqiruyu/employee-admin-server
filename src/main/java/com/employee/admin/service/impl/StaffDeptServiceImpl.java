package com.employee.admin.service.impl;

import com.employee.admin.entity.StaffDept;
import com.employee.admin.enums.ExceptionEnum;
import com.employee.admin.exception.ExtenException;
import com.employee.admin.mapper.IStaffDeptMapper;
import com.employee.admin.service.IStaffDeptService;
import com.employee.admin.vo.EmpParamVO;
import com.employee.admin.vo.QueryUserVO;
import com.employee.admin.vo.ResultVO;
import com.employee.admin.vo.StaffDeptVO;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目名称：employee-admin-server
 * 类名称：StaffDeptServiceImpl
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2020/1/7
 * 修改人：yingx
 * 修改时间： 2020/1/7
 * 修改备注：
 */
@Service
public class StaffDeptServiceImpl implements IStaffDeptService {


    private static final Logger logger = LoggerFactory.getLogger(StaffDeptServiceImpl.class);

    @Autowired
    private IStaffDeptMapper staffDeptMapper;

    @Override
    public void addStaffDept(StaffDept staffDept) {

        int result = staffDeptMapper.addStaffDept(staffDept);
        if (result != 1) {
            throw new ExtenException("addStaffDept", ExceptionEnum.UNEXPECTED_ERROR.getCode(),
                    ExceptionEnum.UNEXPECTED_ERROR.getMessage());
        }
    }

    @Override
    public StaffDeptVO getStaffDept(String empId) {

        StaffDeptVO staffDept = staffDeptMapper.getStaffDept(empId);
        return staffDept;
    }

    @Override
    public StaffDeptVO getSuperEmp(QueryUserVO queryUserVO) {

        StaffDeptVO superEmp = staffDeptMapper.getSuperEmp(queryUserVO);
        return superEmp;
    }

    @Override
    public List<StaffDeptVO> getSubEmp(String empId) {

        logger.info("StaffDeptServiceImpl getSubEmp start ... empId:{}", empId);
        if (StringUtils.isBlank(empId)) {
            throw new ExtenException("getSubEmp", ExceptionEnum.PARAM_VALIDATED_UN_PASS.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS.getMessage());
        }

        EmpParamVO empParamVO = new EmpParamVO();
        empParamVO.setEmpId(empId);

        List<StaffDeptVO> subEmp = staffDeptMapper.getSubEmp(empParamVO);
        logger.info("StaffDeptServiceImpl getSubEmp end ... result:{}", subEmp);
        return subEmp;
    }

    @Override
    public ResultVO updateEmpSuper(List<StaffDeptVO> staffDeptVO) {

        staffDeptMapper.updateEmpSuper(staffDeptVO);
        return new ResultVO();
    }
}
