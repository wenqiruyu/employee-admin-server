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
public class PositionVO {

    /**
     * 职位名称
     */
    private String positionName;

    /**
     * 职位简介
     */
    private String positionDesc;

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getPositionDesc() {
        return positionDesc;
    }

    public void setPositionDesc(String positionDesc) {
        this.positionDesc = positionDesc;
    }

    @Override
    public String toString() {
        return "PositionVO{" +
                "positionName='" + positionName + '\'' +
                ", positionDesc='" + positionDesc + '\'' +
                '}';
    }
}
