package com.client.rasplus.message.api.services.impl;

import com.client.rasplus.message.api.dto.EmailDto;
import com.client.rasplus.message.api.dto.UserRecoveryCodeDto;
import com.client.rasplus.message.api.integration.MailIntegration;
import com.client.rasplus.message.api.services.RecoveryCodeService;
import com.client.rasplus.message.api.utils.MessageUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RecoveryCodeServiceImpl implements RecoveryCodeService {

    private final MailIntegration mailIntegration;

    private final MessageUtils messageUtils;

    private final Configuration configuration;

    @Override
    public void sendEmail(UserRecoveryCodeDto dto) {

        Map<String, Object> model = new HashMap<>();

        model.put("title", messageUtils.get("recovery.code.title"));
        model.put("helloMessage", messageUtils.get("recovery.code.hello_message"));
        model.put("message1", messageUtils.get("recovery.code.message_1"));
        model.put("message2", messageUtils.get("recovery.code.message_2"));
        model.put("rightsReserved", messageUtils.get("recovery.code.rights_reserved"));
        model.put("recoveryCode", dto.code());

        String emailContent;
        try {
            Template template = configuration.getTemplate("recovery-code.ftl");
            emailContent = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e.getMessage());
        }

        mailIntegration.sendHtmlTemplate(new EmailDto(dto.email(), messageUtils.get("recovery.code.subject"), emailContent));
    }
}
