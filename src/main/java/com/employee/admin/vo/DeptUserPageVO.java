package com.employee.admin.vo;

/**
 * 项目名称：employee-admin-server
 * 类名称：DeptUserPageVO
 * 类描述：TDD
 * 创建人：yingx
 * 创建时间： 2020/5/13
 * 修改人：yingx
 * 修改时间： 2020/5/13
 * 修改备注：
 */
public class DeptUserPageVO {

    /**
     * 第几页
     */
    private Integer page;

    /**
     * 每页数据数量
     */
    private Integer pageSize;

    private String deptName;

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

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
