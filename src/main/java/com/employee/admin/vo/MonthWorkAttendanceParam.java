package com.employee.admin.vo;

/**
 * 项目名称：employee-admin-server
 * 类名称：MonthWorkAttendance
 * 类描述：TDD
 * 创建人：yingx
 * 创建时间： 2020/2/21
 * 修改人：yingx
 * 修改时间： 2020/2/21
 * 修改备注：
 */
public class MonthWorkAttendanceParam {

    /**用户id*/
    private Long userId;

    /**用户名*/
    private String username;

    /**数据是这个月1 上个月2 还是三月内3 全部0*/
    private Integer month;

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

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "MonthWorkAttendance{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", month=" + month +
                '}';
    }
}
