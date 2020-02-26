package com.employee.admin.mapper;

import com.employee.admin.entity.StaffDept;
import com.employee.admin.vo.StaffDeptVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 项目名称：employee-admin-server
 * 类名称：IStaffDeptMapper
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2019/12/24
 * 修改人：yingx
 * 修改时间： 2019/12/24
 * 修改备注：
 */
public interface IStaffDeptMapper {

    int addStaffDept(StaffDept staffDept);

    List<StaffDeptVO> getSubEmp(@Param("empId") String empId);
}
