package com.employee.admin.vo;

/**
 * 项目名称：employee-admin-server
 * 类名称：MenuSubVO
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2019/12/25
 * 修改人：yingx
 * 修改时间： 2019/12/25
 * 修改备注：
 */
public class MenuSubVO {

    /**
     * icon菜单图标
     */
    private String subIcon;

    /**
     * 菜单名称 vue文件名
     */
    private String subIndex;

    /**
     * 菜单名
     */
    private String subTitle;

    public String getSubIcon() {
        return subIcon;
    }

    public void setSubIcon(String subIcon) {
        this.subIcon = subIcon;
    }

    public String getSubIndex() {
        return subIndex;
    }

    public void setSubIndex(String subIndex) {
        this.subIndex = subIndex;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    @Override
    public String toString() {
        return "MenuSubVO{" +
                "subIcon='" + subIcon + '\'' +
                ", subIndex='" + subIndex + '\'' +
                ", subTitle='" + subTitle + '\'' +
                '}';
    }
}
