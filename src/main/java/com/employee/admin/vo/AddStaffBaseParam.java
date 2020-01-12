package com.employee.admin.vo;

import com.employee.admin.entity.StaffBase;
import com.employee.admin.entity.StaffDept;

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
public class AddStaffBaseParam {

    private StaffBase staffBase;

    private RegisterUserVO staffDetail;

    private StaffDept staffDept;

    public StaffBase getStaffBase() {
        return staffBase;
    }

    public void setStaffBase(StaffBase staffBase) {
        this.staffBase = staffBase;
    }

    public RegisterUserVO getStaffDetail() {
        return staffDetail;
    }

    public void setStaffDetail(RegisterUserVO staffDetail) {
        this.staffDetail = staffDetail;
    }

    public StaffDept getStaffDept() {
        return staffDept;
    }

    public void setStaffDept(StaffDept staffDept) {
        this.staffDept = staffDept;
    }

    @Override
    public String toString() {
        return "AddStaffBaseParam{" +
                "staffBase=" + staffBase +
                ", staffDetail=" + staffDetail +
                ", staffDept=" + staffDept +
                '}';
    }
}
