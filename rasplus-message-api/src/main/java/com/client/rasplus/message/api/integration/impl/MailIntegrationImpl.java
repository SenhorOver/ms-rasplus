package com.client.rasplus.message.api.integration.impl;

import com.client.rasplus.message.api.integration.MailIntegration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MailIntegrationImpl implements MailIntegration {
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void send(String mailTo, String message, String subject) {

        log.info("Enviando email");
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(mailTo);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        javaMailSender.send(simpleMailMessage);
        log.info("Email enviado com sucesso");
    }
}
