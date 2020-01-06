package com.employee.admin.service.impl;

import com.alibaba.fastjson.JSON;
import com.employee.admin.entity.WorkAttendance;
import com.employee.admin.enums.ExceptionEnum;
import com.employee.admin.exception.ExtenException;
import com.employee.admin.mapper.IStaffDetailMapper;
import com.employee.admin.mapper.IWorkAttendanceMapper;
import com.employee.admin.service.IWorkAttendanceService;
import com.employee.admin.vo.QueryUserVO;
import com.employee.admin.vo.StaffDetailAllUserVO;
import com.employee.admin.vo.WorkAttendanceVO;
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
    public void addAllStaffWages(List<WorkAttendance> workAttendanceList) {

        int result = workAttendanceMapper.addAllWorkAttendance(workAttendanceList);
        if(result != 1){
            throw new ExtenException("addAllStaffWages", ExceptionEnum.UNEXPECTED_ERROR.getCode(),
                    ExceptionEnum.UNEXPECTED_ERROR.getMessage());
        }
    }
}
