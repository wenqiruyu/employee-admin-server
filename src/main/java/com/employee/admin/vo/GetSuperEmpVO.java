package com.employee.admin.vo;

/**
 * 项目名称：employee-admin-server
 * 类名称：GetSuperEmpVO
 * 类描述：TDD
 * 创建人：yingx
 * 创建时间： 2020/4/6
 * 修改人：yingx
 * 修改时间： 2020/4/6
 * 修改备注：
 */
public class GetSuperEmpVO {

    private String empId;

    private String empName;

    private String procedureFlag;

    private String leaveDetail;

    public GetSuperEmpVO(String empId, String empName) {
        this.empId = empId;
        this.empName = empName;
    }

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

    public String getProcedureFlag() {
        return procedureFlag;
    }

    public void setProcedureFlag(String procedureFlag) {
        this.procedureFlag = procedureFlag;
    }

    public String getLeaveDetail() {
        return leaveDetail;
    }

    public void setLeaveDetail(String leaveDetail) {
        this.leaveDetail = leaveDetail;
    }
}
