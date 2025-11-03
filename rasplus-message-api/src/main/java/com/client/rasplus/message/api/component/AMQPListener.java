package com.client.rasplus.message.api.component;

import com.client.rasplus.message.api.dto.UserRecoveryCodeDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class AMQPListener {

    @RabbitListener(queues = "recovery.code.email")
    public void recoveryCodeListener(UserRecoveryCodeDto dto) {
        System.out.println(dto);
    }

}
