package com.client.rasplus.message.api.dto;

public record EmailDto(
        String mailTo,
        String subject,
        String content
) {
}
