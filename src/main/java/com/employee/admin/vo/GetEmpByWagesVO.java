package com.employee.admin.vo;

/**
 * 项目名称：employee-admin-server
 * 类名称：GetEmpByWagesVO
 * 类描述：TDD
 * 创建人：yingx
 * 创建时间： 2020/5/12
 * 修改人：yingx
 * 修改时间： 2020/5/12
 * 修改备注：
 */
public class GetEmpByWagesVO {

    private String empId;

    private String empName;

    private String roleId;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
