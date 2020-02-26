package com.employee.admin.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.employee.admin.vo.AllStaffDetailVO;
import com.employee.admin.vo.StaffWagesVO;

import java.util.List;

/**
 * 项目名称：employee-admin-server
 * 类名称：IStaffWages
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2019/12/26
 * 修改人：yingx
 * 修改时间： 2019/12/26
 * 修改备注：
 */
public interface IStaffWagesMapper {

    List<StaffWagesVO> getAllStaffWages();

    List<StaffWagesVO> getPageWages(Page<StaffWagesVO> staffWagesVOPage, StaffWagesVO staffWagesVO);

    List<StaffWagesVO> getStaffWagesByUserId(Long userId);

    int addAllStaffWages(List<StaffWagesVO> staffWagesVOS);

    int addStaffWages(StaffWagesVO staffWagesVO);
}
