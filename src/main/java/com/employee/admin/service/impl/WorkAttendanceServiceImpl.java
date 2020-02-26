package com.employee.admin.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.employee.admin.entity.WorkAttendance;
import com.employee.admin.enums.ExceptionEnum;
import com.employee.admin.exception.ExtenException;
import com.employee.admin.mapper.IStaffDetailMapper;
import com.employee.admin.mapper.IWorkAttendanceMapper;
import com.employee.admin.service.IWorkAttendanceService;
import com.employee.admin.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目名称：employee-admin-server
 * 类名称：WorkAttendanceServiceImpl
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2020/1/3
 * 修改人：yingx
 * 修改时间： 2020/1/3
 * 修改备注：
 */
@Service
public class WorkAttendanceServiceImpl implements IWorkAttendanceService {

    @Autowired
    private IWorkAttendanceMapper workAttendanceMapper;

    @Override
    public List<WorkAttendanceVO> getAllWorkAttendance() {

        List<WorkAttendanceVO> allWorkAttendance = workAttendanceMapper.getAllWorkAttendance();
        return allWorkAttendance;
    }

    @Override
    public WorkAttendanceVO getWorkAttendance(QueryUserVO queryUserVO) {

        WorkAttendanceVO workAttendance = workAttendanceMapper.getWorkAttendance(queryUserVO);
        return workAttendance;
    }

    @Override
    public MonthWorkAttendanceVO getMonthWorkAttendance(MonthWorkAttendanceParam monthWorkAttendanceParam) {

        MonthWorkAttendanceVO monthWorkAttendance = workAttendanceMapper.getMonthWorkAttendance(monthWorkAttendanceParam);
        return monthWorkAttendance;
    }

    @Override
    public IPage<WorkAttendanceVO> getUserWorkAttendance(WorkAttendanceVO workAttendanceVO, int page, int pageSize) {

        Page<WorkAttendanceVO> workAttendanceVOPage = new Page<>(page, pageSize);
        workAttendanceVOPage.setRecords(workAttendanceMapper.getUserWorkAttendance(workAttendanceVOPage, workAttendanceVO.getEmpId()));
        return workAttendanceVOPage;
    }

    @Override
    public IPage<WorkAttendanceVO> getUseSubEmpAttendance(List<StaffDeptVO> staffDeptVOS, int page, int pageSize) {

        Page<WorkAttendanceVO> workAttendanceVOPage = new Page<>(page, pageSize);
        workAttendanceVOPage.setRecords(workAttendanceMapper.getUserSubEmpWorkAttendance(workAttendanceVOPage, staffDeptVOS));
        return workAttendanceVOPage;
    }

    @Override
    public void updateWorkAttendance(WorkAttendance workAttendance) {

        int result = workAttendanceMapper.updateWorkAttendance(workAttendance);
        if (result != 1) {
            throw new ExtenException("updateWorkAttendance", ExceptionEnum.UNEXPECTED_ERROR.getCode(),
                    ExceptionEnum.UNEXPECTED_ERROR.getMessage());
        }
    }

    @Override
    public void addWorkAttendance(WorkAttendance workAttendance) {

        int result = workAttendanceMapper.addWorkAttendance(workAttendance);
        if (result != 1) {
            throw new ExtenException("addWorkAttendance", ExceptionEnum.UNEXPECTED_ERROR.getCode(),
                    ExceptionEnum.UNEXPECTED_ERROR.getMessage());
        }
    }

    @Override
    public void addAllWorkAttendance(List<WorkAttendance> workAttendanceList) {

        int result = workAttendanceMapper.addAllWorkAttendance(workAttendanceList);
        if (result != 1) {
            throw new ExtenException("addAllStaffWages", ExceptionEnum.UNEXPECTED_ERROR.getCode(),
                    ExceptionEnum.UNEXPECTED_ERROR.getMessage());
        }
    }
}
