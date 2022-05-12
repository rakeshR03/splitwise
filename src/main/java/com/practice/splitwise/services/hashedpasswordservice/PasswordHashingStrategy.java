package com.practice.splitwise.services.hashedpasswordservice;

import org.springframework.stereotype.Service;

public interface PasswordHashingStrategy {
    public String hash(String originalPassword);
}
