package com.employee.admin.service.impl;

import com.employee.admin.enums.ExceptionEnum;
import com.employee.admin.exception.ExtenException;
import com.employee.admin.service.SendMailService;
import com.employee.admin.vo.ResultVO;
import com.employee.admin.vo.SendMailVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.internet.MimeMessage;
import java.util.Date;

/**
 * 项目名称：wen-item
 * 类名称：SendMailServiceImpl
 * 类描述：TODO
 * 创建人：yingx
 * 创建时间： 2020/3/25
 * 修改人：yingx
 * 修改时间： 2020/3/25
 * 修改备注：
 */
@Service
public class SendMailServiceImpl implements SendMailService {

    private final static Logger logger = LoggerFactory.getLogger(SendMailServiceImpl.class);

    @Value("${spring.mail.username}")
    private String springMailUsername;

    @Autowired
    private JavaMailSender mailSender;

    /**
     * 发送邮件
     *
     * @param sendMailVO 邮件内容
     * @return com.server.common.wen.vo.ResultVO
     * @author yingx
     * @date 2020/3/25
     */
    @Override
    public ResultVO sendMail(SendMailVO sendMailVO) {

        logger.info("SendMailServiceImpl sendAttachmentsMail start ... SendMailVO:{}", sendMailVO);
        this.validatorMailParam(sendMailVO);
        sendMailVO.setFrom(springMailUsername);
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            //true表示支持复杂类型
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
            messageHelper.setFrom(springMailUsername);//邮件发信人
            messageHelper.setTo(sendMailVO.getTo().split(","));//邮件收信人
            messageHelper.setSubject(sendMailVO.getSubject());//邮件主题
            messageHelper.setText(sendMailVO.getText());//邮件内容
            if (!StringUtils.isEmpty(sendMailVO.getCc())) {//抄送
                messageHelper.setCc(sendMailVO.getCc().split(","));
            }
            if (!StringUtils.isEmpty(sendMailVO.getBcc())) {//密送
                messageHelper.setCc(sendMailVO.getBcc().split(","));
            }
            if (sendMailVO.getMultipartFiles() != null) {//添加邮件附件
                for (MultipartFile multipartFile : sendMailVO.getMultipartFiles()) {
                    messageHelper.addAttachment(multipartFile.getOriginalFilename(), multipartFile);
                }
            }
            if (StringUtils.isEmpty(sendMailVO.getSendDate())) {
                sendMailVO.setSendDate(new Date());
                messageHelper.setSentDate(sendMailVO.getSendDate());
            }
            // 正式发送邮件
            mailSender.send(mimeMessage);
        } catch (Exception e) {
            logger.error("SendMailServiceImpl sendAttachmentsMail error ... e:{}", e);
            throw new ExtenException("sendAttachmentsMail", ExceptionEnum.UNEXPECTED_ERROR.getCode(),
                    ExceptionEnum.UNEXPECTED_ERROR.getMessage());
        }
        logger.info("SendMailServiceImpl sendAttachmentsMail error ... From:{}, To:{}", sendMailVO.getFrom(), sendMailVO.getTo());
        return new ResultVO();
    }

    /**
     * 参数校验
     *
     * @param sendMailVO
     * @return void
     * @author yingx
     * @date 2020/3/26
     */
    public void validatorMailParam(SendMailVO sendMailVO) {

        if (sendMailVO.getTo() == null) {
            logger.error("SendMailServiceImpl validatorMailParam error ... message:{}", "邮件收件人为空");
            throw new ExtenException("validatorMailParam", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
        if (sendMailVO.getSubject() == null) {
            logger.error("SendMailServiceImpl validatorMailParam error ... message:{}", "邮件主题为空");
            throw new ExtenException("validatorMailParam", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
        if (sendMailVO.getText() == null) {
            logger.error("SendMailServiceImpl validatorMailParam error ... message:{}", "邮件内容为空");
            throw new ExtenException("validatorMailParam", ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getCode(),
                    ExceptionEnum.PARAM_VALIDATED_UN_PASS_NULL.getMessage());
        }
    }
}
