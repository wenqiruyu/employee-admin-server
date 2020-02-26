package com.employee.admin.service;

import com.employee.admin.entity.StaffDept;
import com.employee.admin.vo.StaffDeptVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 项目名称：employee-admin-server
 * 类名称：IStaffDeptService
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2020/1/7
 * 修改人：yingx
 * 修改时间： 2020/1/7
 * 修改备注：
 */
public interface IStaffDeptService {

    void addStaffDept(StaffDept staffDept);

    List<StaffDeptVO> getSubEmp(String empId);
}
