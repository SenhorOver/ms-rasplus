package com.client.rasplus.api.customer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsDto {

    @Email(message = "Invalid")
    private String email;

    @NotBlank(message = "Cannot be blank or null")
    private String password;

    private String recoveryCode;

}
