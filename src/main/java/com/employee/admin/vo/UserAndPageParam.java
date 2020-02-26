package com.employee.admin.vo;

/**
 * 项目名称：employee-admin-server
 * 类名称：UserAndPageParam
 * 类描述：TDD
 * 创建人：yingx
 * 创建时间： 2020/2/19
 * 修改人：yingx
 * 修改时间： 2020/2/19
 * 修改备注：
 */
public class UserAndPageParam {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户昵称
     */
    private String username;

    /** 员工号*/
    private String empId;

    /** 员工姓名*/
    private String empName;

    /**
     * 第几页
     */
    private Integer page;

    /**
     * 每页数据数量
     */
    private Integer pageSize;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        return "UserAndPageParam{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", page=" + page +
                ", pageSize=" + pageSize +
                '}';
    }
}
