package com.employee.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.employee.admin.enums.ExceptionEnum;
import com.employee.admin.exception.ExtenException;
import com.employee.admin.mapper.IStaffWagesMapper;
import com.employee.admin.service.IStaffWagesService;
import com.employee.admin.vo.AllStaffDetailVO;
import com.employee.admin.vo.StaffWagesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<StaffWagesVO> getStaffWagesByUserId(Long userId) {

        List<StaffWagesVO> staffWagesByUserId = staffWagesMapper.getStaffWagesByUserId(userId);
        return staffWagesByUserId;
    }

    @Override
    public void addAllStaffWages(List<StaffWagesVO> staffWagesVOS) {

        int result = staffWagesMapper.addAllStaffWages(staffWagesVOS);
        if (result != 1) {
            throw new ExtenException("addAllStaffWages", ExceptionEnum.UNEXPECTED_ERROR.getCode(),
                    ExceptionEnum.UNEXPECTED_ERROR.getMessage());
        }
    }

    @Override
    public void addStaffWages(StaffWagesVO staffWagesVO) {

        int result = staffWagesMapper.addStaffWages(staffWagesVO);
        if (result != 1) {
            throw new ExtenException("addAllStaffWages", ExceptionEnum.UNEXPECTED_ERROR.getCode(),
                    ExceptionEnum.UNEXPECTED_ERROR.getMessage());
        }
    }
}
