package com.employee.admin.mapper;

import com.employee.admin.entity.Dept;
import com.employee.admin.vo.DeptVO;

import java.util.List;

/**
 * 项目名称：employee-admin-server
 * 类名称：IDeptMapper
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2019/12/24
 * 修改人：yingx
 * 修改时间： 2019/12/24
 * 修改备注：
 */
public interface IDeptMapper {

    List<DeptVO> getAllDept();

    int addDept(Dept dept);
}
