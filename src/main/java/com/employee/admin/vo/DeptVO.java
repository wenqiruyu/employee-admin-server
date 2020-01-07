package com.employee.admin.vo;

/**
 * 项目名称：employee-admin-server
 * 类名称：DeptVo
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2020/1/7
 * 修改人：yingx
 * 修改时间： 2020/1/7
 * 修改备注：
 */
public class DeptVO {

    /**
     * 部门id
     */
    private String deptId;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 部门简介
     */
    private String deptDescription;

    /**
     * 部门负责人的empId
     */
    private String principalEmpId;

    /**
     * 部门负责人
     */
    private String principalName;

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

    public String getDeptDescription() {
        return deptDescription;
    }

    public void setDeptDescription(String deptDescription) {
        this.deptDescription = deptDescription;
    }

    public String getPrincipalEmpId() {
        return principalEmpId;
    }

    public void setPrincipalEmpId(String principalEmpId) {
        this.principalEmpId = principalEmpId;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    @Override
    public String toString() {
        return "DeptVO{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", deptDescription='" + deptDescription + '\'' +
                ", principalEmpId='" + principalEmpId + '\'' +
                ", principalName='" + principalName + '\'' +
                '}';
    }
}
