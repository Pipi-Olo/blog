package com.pipiolo.login.dto;

import com.pipiolo.login.domain.Role;
import lombok.Data;

@Data
public class UserRequest {
    private final String name;
    private final String email;
    private final String password;
    private final Role role;
}
