package com.employee.admin.service.impl;

import com.employee.admin.mapper.IDeptMapper;
import com.employee.admin.service.IDeptService;
import com.employee.admin.vo.DeptVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目名称：employee-admin-server
 * 类名称：DeptServiceImpl
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2020/1/7
 * 修改人：yingx
 * 修改时间： 2020/1/7
 * 修改备注：
 */
@Service
public class DeptServiceImpl implements IDeptService {

    @Autowired
    private IDeptMapper deptMapper;

    @Override
    public List<DeptVO> getAllDept() {

        List<DeptVO> allDept = deptMapper.getAllDept();
        return allDept;
    }
}
