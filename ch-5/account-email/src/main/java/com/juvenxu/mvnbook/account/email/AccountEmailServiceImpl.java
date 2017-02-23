package com.juvenxu.mvnbook.account.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;


public class AccountEmailServiceImpl implements AccountEmailService {

    private JavaMailSender javaMailSender;
    private String systemEmail;

    /**
     * 在程序中没有看到javaMailSender的初始化，却能在被使用，这是由sping的依赖注入框架进行ioc（查看测试代码）。
     *
     * @param to
     * @param subject
     * @param htmlText
     * @throws AccountEmailException
     */
    public void sendMail(String to, String subject, String htmlText) throws AccountEmailException {
        try {
            System.out.println("systemEmail=" + systemEmail);
            MimeMessage msg = javaMailSender.createMimeMessage();
            MimeMessageHelper msgHelper = new MimeMessageHelper(msg);
            msgHelper.setFrom(systemEmail);
            msgHelper.setTo(to);
            msgHelper.setSubject(subject);
            msgHelper.setText(htmlText, true);
            javaMailSender.send(msg);
        } catch (MessagingException e) {
            throw new AccountEmailException("Faild to send mail.", e);
        }
    }

    public JavaMailSender getJavaMailSender() {
        return javaMailSender;
    }

    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public String getSystemEmail() {
        return systemEmail;
    }

    public void setSystemEmail(String systemEmail) {
        this.systemEmail = systemEmail;
    }
}
