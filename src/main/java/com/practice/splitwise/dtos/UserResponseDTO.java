package com.practice.splitwise.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {
    private UserDTO user;
}

// As User object has some information that we don't want to send to user like hashed password.
// Therefore, we'll send UserDTO in response.
