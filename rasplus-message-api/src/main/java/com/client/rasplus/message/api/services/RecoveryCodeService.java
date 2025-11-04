package com.client.rasplus.message.api.services;

import com.client.rasplus.message.api.dto.UserRecoveryCodeDto;

public interface RecoveryCodeService {

    void sendEmail(UserRecoveryCodeDto dto);
}
