package com.client.rasplus.message.api.integration;

import com.client.rasplus.message.api.dto.EmailDto;

public interface MailIntegration {
    void send(EmailDto dto);

    void sendHtmlTemplate(EmailDto dto);
}
