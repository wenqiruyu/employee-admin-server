package com.employee.admin.vo;

import java.time.LocalDateTime;

/**
 * 项目名称：employee-admin-server
 * 类名称：StaffDetailAllUserVO
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2020/1/3
 * 修改人：yingx
 * 修改时间： 2020/1/3
 * 修改备注：
 */
public class StaffDetailAllUserVO {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "StaffDetailAllUserVO{" +
                "userId='" + userId + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
