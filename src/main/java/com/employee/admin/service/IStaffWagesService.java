package com.employee.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.employee.admin.vo.StaffWagesVO;

import java.util.List;

/**
 * 项目名称：employee-admin-server
 * 类名称：IStaffWagesService
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2019/12/26
 * 修改人：yingx
 * 修改时间： 2019/12/26
 * 修改备注：
 */
public interface IStaffWagesService {

    IPage<StaffWagesVO> getAllStaffWages(StaffWagesVO staffWagesVO, int page, int pageSize);

    List<StaffWagesVO> getStaffWagesByUserId(Long userId);

    void addAllStaffWages(List<StaffWagesVO> staffWagesVOS);

    void addStaffWages(StaffWagesVO staffWagesVO);
}
