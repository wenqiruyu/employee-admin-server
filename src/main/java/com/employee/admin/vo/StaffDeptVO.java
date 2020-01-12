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
     * 员工id
     */
    private String empId;

    /**
     * 员工职称
     */
    private String empPosition;

    /**
     * 员工上级id
     */
    private String superEmpId;

    /**
     * 部门id
     */
    private String deptId;
    /**
     * 部门名称
     */
    private String deptName;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpPosition() {
        return empPosition;
    }

    public void setEmpPosition(String empPosition) {
        this.empPosition = empPosition;
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

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "StaffDeptVO{" +
                "empId=" + empId +
                ", empPosition='" + empPosition + '\'' +
                ", superEmpId=" + superEmpId +
                ", deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
