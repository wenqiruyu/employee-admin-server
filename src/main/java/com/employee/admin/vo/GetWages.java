package com.employee.admin.vo;

/**
 * 项目名称：employee-admin-server
 * 类名称：QueryUserVo
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2019/12/24
 * 修改人：yingx
 * 修改时间： 2019/12/24
 * 修改备注：
 */
public class GetWages {

    private String username;

    /**
     * 第几页
     */
    private Integer page;

    /**
     * 每页数据数量
     */
    private Integer pageSize;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "GetWages{" +
                "username='" + username + '\'' +
                ", page=" + page +
                ", pageSize=" + pageSize +
                '}';
    }
}
