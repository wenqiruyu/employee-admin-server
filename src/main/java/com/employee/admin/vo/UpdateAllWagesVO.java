package com.employee.admin.vo;

import java.util.List;

/**
 * 项目名称：employee-admin-server
 * 类名称：UpdateAllWagesVO
 * 类描述：TDD
 * 创建人：yingx
 * 创建时间： 2020/5/13
 * 修改人：yingx
 * 修改时间： 2020/5/13
 * 修改备注：
 */
public class UpdateAllWagesVO {

    private List<StaffWagesVO> staffWagesVOS;

    public List<StaffWagesVO> getStaffWagesVOS() {
        return staffWagesVOS;
    }

    public void setStaffWagesVOS(List<StaffWagesVO> staffWagesVOS) {
        this.staffWagesVOS = staffWagesVOS;
    }
}
