package com.client.rasplus.message.api.component;

import com.client.rasplus.message.api.dto.UserRecoveryCodeDto;
import com.client.rasplus.message.api.integration.MailIntegration;
import com.client.rasplus.message.api.services.RecoveryCodeService;
import com.client.rasplus.message.api.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class AMQPListener {

    private final RecoveryCodeService recoveryCodeService;

    @RabbitListener(queues = "recovery.code.email")
    public void recoveryCodeListener(UserRecoveryCodeDto dto) {
        recoveryCodeService.sendEmail(dto);
    }

}
