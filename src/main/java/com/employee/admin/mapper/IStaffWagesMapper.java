package com.employee.admin.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.employee.admin.entity.StaffWages;
import com.employee.admin.vo.GetEmpByWagesVO;
import com.employee.admin.vo.StaffWagesVO;
import org.apache.ibatis.annotations.Param;

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

    IPage<StaffWagesVO> getStaffWagesPageByUserId(Page<?> staffWagesVOPage, String empId);

    List<StaffWagesVO> getStaffWagesByUserId(Long userId);

    int addAllStaffWages(List<StaffWages> staffWages);

    int updateAllWages(List<StaffWagesVO> staffWagesVO);

    int addStaffWages(StaffWagesVO staffWagesVO);

    List<StaffWagesVO> getWagesByEmpName(String empName);

    List<GetEmpByWagesVO> getEmpByWages();

    List<StaffWagesVO> getAllWagesByPeriod(String period);

    void updateStatus(String empId);
}
