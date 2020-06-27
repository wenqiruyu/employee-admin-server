package com.employee.admin.service.impl;

import com.employee.admin.entity.StaffLeave;
import com.employee.admin.enums.ResultEnum;
import com.employee.admin.mapper.IStaffLeaveMapper;
import com.employee.admin.service.IStaffLeaveService;
import com.employee.admin.vo.QueryUserVO;
import com.employee.admin.vo.ResultVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 项目名称：employee-admin-server
 * 类名称：StaffLeaveServiceImpl
 * 类描述：TDD
 * 创建人：yingx
 * 创建时间： 2020/4/9
 * 修改人：yingx
 * 修改时间： 2020/4/9
 * 修改备注：
 */
@Service
public class StaffLeaveServiceImpl implements IStaffLeaveService {

    @Autowired
    private IStaffLeaveMapper staffLeaveMapper;

    @Override
    public ResultVO addStaffLeave(StaffLeave staffLeave) {

        staffLeave.setDeleteFlag(0);
        staffLeave.setCreateTime(new Date());
        int result = staffLeaveMapper.addStaffLeave(staffLeave);
        if (result != 1) {
            return new ResultVO(ResultEnum.SYS_ERROR.getCode(), ResultEnum.SYS_ERROR.getMsg());
        }
        return new ResultVO<>();
    }

    @Override
    public ResultVO getSubEmpLeave(QueryUserVO queryUserVO) {

        // 查询是为直系上属时
        List<StaffLeave> subEmpLeave = staffLeaveMapper.getSubEmpLeave(queryUserVO);

        // 查询上属
        List<StaffLeave> subPlusEmpLeave = staffLeaveMapper.getSubEmpLeaveByPlus(queryUserVO);

        subEmpLeave.addAll(subPlusEmpLeave);

        if (subEmpLeave == null) {
            return new ResultVO(ResultEnum.SYS_ERROR.getCode(), ResultEnum.SYS_ERROR.getMsg());
        }
        return new ResultVO<>(subEmpLeave);
    }

    @Override
    public ResultVO updateEmpLeave(Long id) {

        int result;
        StaffLeave empLeaveById = staffLeaveMapper.getEmpLeaveById(id);
        if (StringUtils.isBlank(empLeaveById.getSuperPlusEmpId()) && StringUtils.isBlank(empLeaveById.getSuperPlusEmpName())) {
            result = staffLeaveMapper.updateEmpLeaveSuccess(id);
        }else {
            result = staffLeaveMapper.updateEmpLeave(id);
        }
        if (result != 1) {
            return new ResultVO(ResultEnum.SYS_ERROR.getCode(), ResultEnum.SYS_ERROR.getMsg());
        }
        return new ResultVO();
    }

    @Override
    public ResultVO updateEmpLeaveError(Long id) {

        int result = staffLeaveMapper.updateEmpLeaveError(id);
        if (result != 1) {
            return new ResultVO(ResultEnum.SYS_ERROR.getCode(), ResultEnum.SYS_ERROR.getMsg());
        }
        return new ResultVO();
    }

    @Override
    public ResultVO getEmpAllLeave(QueryUserVO queryUserVO) {

        List<StaffLeave> empAllLeave = staffLeaveMapper.getEmpAllLeave(queryUserVO);
        return new ResultVO(empAllLeave);
    }
}
