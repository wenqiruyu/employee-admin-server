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
    private String icon;

    /**
     * 菜单名称 vue文件名
     */
    private String index;

    /**
     * 菜单名
     */
    private String title;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "MenuSubVO{" +
                "icon='" + icon + '\'' +
                ", index='" + index + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
