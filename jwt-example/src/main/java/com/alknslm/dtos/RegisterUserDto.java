package com.alknslm.dtos;

import com.alknslm.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserDto {

    private String email;

    private String password;

    private String fullName;

    private Role role;

}
