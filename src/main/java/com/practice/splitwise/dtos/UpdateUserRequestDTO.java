package com.practice.splitwise.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRequestDTO {
    private Long userId;
    private String name;
    private String phoneNumber;
    private String password;
}
