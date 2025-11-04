package com.client.rasplus.message.api.integration.impl;

import com.client.rasplus.message.api.dto.EmailDto;
import com.client.rasplus.message.api.integration.MailIntegration;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MailIntegrationImpl implements MailIntegration {
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void send(EmailDto dto) {

        log.info("Enviando email");
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(dto.mailTo());
        simpleMailMessage.setSubject(dto.subject());
        simpleMailMessage.setText(dto.content());
        javaMailSender.send(simpleMailMessage);
        log.info("Email enviado com sucesso");
    }

    @Override
    public void sendHtmlTemplate(EmailDto dto) {
        log.info("Enviando email");
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(dto.mailTo());
            helper.setSubject(dto.subject());
            helper.setText(dto.content(), true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e.getMessage());
        }

        log.info("Email enviado com sucesso");
    }
}
