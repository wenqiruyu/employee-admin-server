package com.employee.admin.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 项目名称：employee-admin-server
 * 类名称：AllStaffDetailVO
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2020/1/13
 * 修改人：yingx
 * 修改时间： 2020/1/13
 * 修改备注：
 */
public class AllStaffDetailVO {

    /**
     * 用户id
     */
    private String userId;

    /**
     * 昵称
     */
    private String username;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 住宅电话
     */
    private String telephone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 出生日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String county;

    /**
     * 联系地区 户籍
     */
    private String address;

    /**
     * 现居住地址
     */
    private String currentAddress;

    /**
     * 党派 无党派民主人士 中共党员 民革党员 民盟党员 农工党员 群众
     */
    private String politics;

    /**
     * 所属民族
     */
    private String national;

    /**
     * 婚姻状态 未婚 已婚 丧偶 其他
     */
    private String marriage;

    /**
     * 学历 小学 初中 高中 本科 研究生 博士
     */
    private String education;

    /**
     * 头像
     */
    private String userface;

    /**
     * 备注
     */
    private String remark;

    /**
     * 员工id
     */
    private String empId;

    /**
     * 员工名
     */
    private String empName;

    /**
     * 入职时间
     */
    private String participateTime;

    /**
     * 离职时间
     */
    private String leaveTime;

    /**
     * 离职原因
     */
    private String leaveReason;

    /**
     * 员工职称
     */
    private String empPosition;

    /**
     * 员工上级id
     */
    private String superEmpId;

    /**
     * 员工上级名
     */
    private String superEmpName;

    /**
     * 部门id
     */
    private String deptId;

    /**
     * 部门名称
     */
    private String deptName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getPolitics() {
        return politics;
    }

    public void setPolitics(String politics) {
        this.politics = politics;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getUserface() {
        return userface;
    }

    public void setUserface(String userface) {
        this.userface = userface;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getParticipateTime() {
        return participateTime;
    }

    public void setParticipateTime(String participateTime) {
        this.participateTime = participateTime;
    }

    public String getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public String getEmpPosition() {
        return empPosition;
    }

    public void setEmpPosition(String empPosition) {
        this.empPosition = empPosition;
    }

    public String getSuperEmpId() {
        return superEmpId;
    }

    public void setSuperEmpId(String superEmpId) {
        this.superEmpId = superEmpId;
    }

    public String getSuperEmpName() {
        return superEmpName;
    }

    public void setSuperEmpName(String superEmpName) {
        this.superEmpName = superEmpName;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "AllStaffDetailVO{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", idCard='" + idCard + '\'' +
                ", birthday=" + birthday +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", address='" + address + '\'' +
                ", currentAddress='" + currentAddress + '\'' +
                ", politics='" + politics + '\'' +
                ", national='" + national + '\'' +
                ", marriage='" + marriage + '\'' +
                ", education='" + education + '\'' +
                ", userface='" + userface + '\'' +
                ", remark='" + remark + '\'' +
                ", empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", participateTime='" + participateTime + '\'' +
                ", leaveTime='" + leaveTime + '\'' +
                ", leaveReason='" + leaveReason + '\'' +
                ", empPosition='" + empPosition + '\'' +
                ", superEmpId='" + superEmpId + '\'' +
                ", superEmpName='" + superEmpName + '\'' +
                ", deptId='" + deptId + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
