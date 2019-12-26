package com.employee.admin.vo;

import java.math.BigDecimal;

/**
 * 项目名称：employee-admin-server
 * 类名称：StaffWagesVO
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2019/12/26
 * 修改人：yingx
 * 修改时间： 2019/12/26
 * 修改备注：
 */
public class StaffWagesVO {

    /**
     * userId用户id
     */
    private Long userId;

    /**
     * 薪资发放期间
     */
    private String period;

    /**
     * 基本工资
     */
    private BigDecimal baseWages;

    /**
     * 补贴 公司本月福利
     */
    private BigDecimal subsidy;

    /**
     * 税前扣款
     */
    private BigDecimal tax;

    /**
     * 实发工资
     */
    private BigDecimal realWages;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public BigDecimal getBaseWages() {
        return baseWages;
    }

    public void setBaseWages(BigDecimal baseWages) {
        this.baseWages = baseWages;
    }

    public BigDecimal getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(BigDecimal subsidy) {
        this.subsidy = subsidy;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getRealWages() {
        return realWages;
    }

    public void setRealWages(BigDecimal realWages) {
        this.realWages = realWages;
    }

    @Override
    public String toString() {
        return "StaffWagesVO{" +
                "userId=" + userId +
                ", period='" + period + '\'' +
                ", baseWages=" + baseWages +
                ", subsidy=" + subsidy +
                ", tax=" + tax +
                ", realWages=" + realWages +
                '}';
    }
}
