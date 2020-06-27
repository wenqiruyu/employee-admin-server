package com.employee.admin.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.Date;

/**
 * 项目名称：wen-item
 * 类名称：SendMailVO
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2020/3/25
 * 修改人：yingx
 * 修改时间： 2020/3/25
 * 修改备注：
 */
public class SendMailVO {

    /**
     * 邮件发送人
     */
    private String from;

    /**
     * 邮件收件人  多人使用,分割
     */
    private String to;

    /**
     * 邮件标题 主题
     */
    private String subject;

    /**
     * 邮件内容
     */
    private String text;

    /**
     * 邮件抄送 多人使用,分割
     */
    private String cc;

    /**
     * 邮件密送 多人使用,分割
     */
    private String bcc;

    /**
     * 附件
     *
     * @JsonIgnore 在实体类向前台返回数据时用来忽略不想传递给前台的属性或接口
     */
    @JsonIgnore
    private MultipartFile[] multipartFiles;

    /**
     * 邮件发送时间
     */
    private Date sendDate;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public MultipartFile[] getMultipartFiles() {
        return multipartFiles;
    }

    public void setMultipartFiles(MultipartFile[] multipartFiles) {
        this.multipartFiles = multipartFiles;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    @Override
    public String toString() {
        return "SendMailVO{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                ", cc='" + cc + '\'' +
                ", bcc='" + bcc + '\'' +
                ", multipartFiles=" + Arrays.toString(multipartFiles) +
                ", sendDate=" + sendDate +
                '}';
    }
}
