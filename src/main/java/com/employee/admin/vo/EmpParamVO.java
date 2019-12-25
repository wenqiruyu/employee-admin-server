package com.employee.admin.vo;

/**
 * 项目名称：employee-admin-server
 * 类名称：EmpParamVO
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2019/12/25
 * 修改人：yingx
 * 修改时间： 2019/12/25
 * 修改备注：
 */
public class EmpParamVO {

    /**
     * 员工号
     */
    private String empId;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "EmpParamVO{" +
                "empId='" + empId + '\'' +
                '}';
    }
}
