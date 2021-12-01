package com.dectub.iam.gateways.acl;

import com.dectub.frameworks.domain.core.Exceptions;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.util.Date;
import java.util.Properties;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/23 2:40 下午
 */
public class SendEmailService {

    private final String host;
    private final String port;
    private final String username;
    private final String password;
    private final String defaultEncoding;
    private final String personal;
    private final Properties property;

    public SendEmailService(String host, String port, String username, String password, String defaultEncoding,
                            String personal) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.defaultEncoding = defaultEncoding;
        this.personal = personal;
        property = initProperties();
    }

    public void sendEmailTo(String to, String title, String content) {
        JavaMailSender javaMailSender = javaMailSender();
        var mimeMessage = javaMailSender.createMimeMessage();
        Exceptions.execute(() -> setMailInfo(Exceptions.evaluate(() ->
                new MimeMessageHelper(mimeMessage, true)), to, title, content));
        new WithLogMailSender(javaMailSender).send(mimeMessage);
    }

    private void setMailInfo(MimeMessageHelper messageHelper, String to, String title, String content)
            throws Exception {
        messageHelper.setFrom(username, personal);
        messageHelper.setTo(to);
        messageHelper.setSubject(title);
        messageHelper.setSentDate(new Date());
        messageHelper.setText(content, true);
    }

    private JavaMailSender javaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setDefaultEncoding(defaultEncoding);
        javaMailSender.setHost(host);
        javaMailSender.setPort(Integer.parseInt(port));
        javaMailSender.setUsername(username);
        javaMailSender.setPassword(password);
        javaMailSender.setJavaMailProperties(property);
        return javaMailSender;
    }

    private Properties initProperties() {
        var mailProperties = new Properties();
        mailProperties.put("mail.smtp.ssl.socketFactory.class", "com.fintech.modules.base.util.mail.MailSSLSocketFactory");
        mailProperties.put("mail.smtp.starttls.required", "true");
        mailProperties.put("mail.smtp.ssl.enable", "true");
        mailProperties.put("mail.smtp.auth", "true");
        mailProperties.put("mail.smtp.starttls.enable", "true");
        return mailProperties;
    }

}
