package com.employee.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.employee.admin.entity.StaffWages;
import com.employee.admin.enums.ExceptionEnum;
import com.employee.admin.exception.ExtenException;
import com.employee.admin.mapper.IStaffWagesMapper;
import com.employee.admin.service.IStaffWagesService;
import com.employee.admin.vo.EmpParamVO;
import com.employee.admin.vo.GetEmpByWagesVO;
import com.employee.admin.vo.ResultVO;
import com.employee.admin.vo.StaffWagesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：employee-admin-server
 * 类名称：StaffWagesServiceImpl
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2019/12/26
 * 修改人：yingx
 * 修改时间： 2019/12/26
 * 修改备注：
 */
@Service
public class StaffWagesServiceImpl implements IStaffWagesService {

    @Autowired
    private IStaffWagesMapper staffWagesMapper;

    @Override
    public IPage<StaffWagesVO> getAllStaffWages(StaffWagesVO staffWagesVO, int page, int pageSize) {

//        List<StaffWagesVO> allStaffWages = staffWagesMapper.getAllStaffWages();
//        return allStaffWages;
        Page<StaffWagesVO> staffWagesVOPage = new Page<>(page, pageSize);
        staffWagesVOPage.setRecords(staffWagesMapper.getPageWages(staffWagesVOPage, staffWagesVO));
        return staffWagesVOPage;
    }

    @Override
    public ResultVO getWagesByEmpName(EmpParamVO empParamVO) {

        List<StaffWagesVO> wagesByEmpName = staffWagesMapper.getWagesByEmpName(empParamVO.getEmpName());
        return new ResultVO(wagesByEmpName);
    }

    @Override
    public IPage<StaffWagesVO> getStaffWagesByUserId(String empId, int page, int pageSize) {

        Page<StaffWagesVO> staffWagesVOPage = new Page<>(page, pageSize);

        IPage<StaffWagesVO> staffWagesPageByUserId = staffWagesMapper.getStaffWagesPageByUserId(staffWagesVOPage, empId);
        return staffWagesPageByUserId;
    }

    @Override
    public void updateAllWages(List<StaffWagesVO> staffWagesVOS) {

        int result = staffWagesMapper.updateAllWages(staffWagesVOS);
    }

    @Override
    public void addStaffWages(StaffWagesVO staffWagesVO) {

        int result = staffWagesMapper.addStaffWages(staffWagesVO);
        if (result != 1) {
            throw new ExtenException("addAllStaffWages", ExceptionEnum.UNEXPECTED_ERROR.getCode(),
                    ExceptionEnum.UNEXPECTED_ERROR.getMessage());
        }
    }

    @Override
    public void addAllUserWages(String period) {

        List<GetEmpByWagesVO> empByWages = staffWagesMapper.getEmpByWages();

        ArrayList<StaffWages> list = new ArrayList<>();

        for (GetEmpByWagesVO emp :empByWages) {
            StaffWages staffWages = new StaffWages();
            staffWages.setEmpId(emp.getEmpId());
            staffWages.setEmpName(emp.getEmpName());
            staffWages.setBaseWages("ROLE003".equalsIgnoreCase(emp.getRoleId()) ? new BigDecimal(8000) : new BigDecimal(15000));
            staffWages.setPeriod(period);
            staffWages.setSubsidy(new BigDecimal(150));
            staffWages.setTax(staffWages.getBaseWages().multiply(new BigDecimal(0.2083)).setScale(2, BigDecimal.ROUND_HALF_UP));
            staffWages.setRealWages(staffWages.getBaseWages().subtract(staffWages.getTax()).setScale(2, BigDecimal.ROUND_HALF_UP));
            staffWages.setCreateTime(LocalDateTime.now());
            staffWages.setUpdateTime(LocalDateTime.now());
            staffWages.setDeleteFlag(1);

            list.add(staffWages);
        }

        int result = staffWagesMapper.addAllStaffWages(list);
        if (result == 0) {
            throw new ExtenException("addAllStaffWages", ExceptionEnum.UNEXPECTED_ERROR.getCode(),
                    ExceptionEnum.UNEXPECTED_ERROR.getMessage());
        }
    }

    @Override
    public List<StaffWagesVO> getAllWagesByPeriod(String period) {

        List<StaffWagesVO> allWagesByPeriod = staffWagesMapper.getAllWagesByPeriod(period);
        return allWagesByPeriod;
    }
}
