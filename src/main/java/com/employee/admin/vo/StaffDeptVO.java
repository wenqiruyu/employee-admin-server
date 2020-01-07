package com.employee.admin.vo;

/**
 * 项目名称：employee-admin-server
 * 类名称：StaffDeptVO
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2020/1/7
 * 修改人：yingx
 * 修改时间： 2020/1/7
 * 修改备注：
 */
public class StaffDeptVO {

    /**
     * 员工号
     */
    private String empId;

    /**
     * 直接上级
     */
    private String superEmpId;

    /**
     * 部门id
     */
    private String deptId;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getSuperEmpId() {
        return superEmpId;
    }

    public void setSuperEmpId(String superEmpId) {
        this.superEmpId = superEmpId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "StaffDeptVO{" +
                "empId='" + empId + '\'' +
                ", superEmpId='" + superEmpId + '\'' +
                ", deptId='" + deptId + '\'' +
                '}';
    }
}
