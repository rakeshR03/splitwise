package com.practice.splitwise.services;

import com.practice.splitwise.dtos.RegisterUserRequestDTO;
import com.practice.splitwise.models.User1;
import com.practice.splitwise.repositories.UserRepository;
import com.practice.splitwise.services.hashedpasswordservice.PasswordHashingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private PasswordHashingStrategy passwordHashingStrategy;

    @Autowired
    private UserRepository userRepository;

    public User1 registerUser(String name, String phoneNUmber, String password){

        // create hashed password
        String hashedPassword = passwordHashingStrategy.hash(password);

        // create user object
        User1 user = new User1();
        user.setName(name);
        user.setPhoneNumber(phoneNUmber);
        user.setHashedPassword(hashedPassword);

        // save the user object
        User1 savedUser = userRepository.save(user);

        // return saved user object
        return savedUser;
    }
}

// don't tightly couple service with request
// same service can be used by multiple request.


// Difference between saved user and user is that saved user will have id but user will not.