package com.client.rasplus.message.api.component;

import com.client.rasplus.message.api.dto.UserRecoveryCodeDto;
import com.client.rasplus.message.api.integration.MailIntegration;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AMQPListener {

    @Autowired
    private MailIntegration mailIntegration;

    @RabbitListener(queues = "recovery.code.email")
    public void recoveryCodeListener(UserRecoveryCodeDto dto) {
        mailIntegration.send(dto.email(), dto.code(), "Código de Recuperação de conta");
    }

}
