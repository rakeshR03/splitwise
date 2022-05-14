package com.practice.splitwise.commands;

import com.practice.splitwise.controllers.UserController;
import com.practice.splitwise.dtos.RegisterUserRequestDTO;
import com.practice.splitwise.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

public class RegisterUser implements Command{

    private String COMMAND_NAME = "Register";

    @Autowired
    private UserController userController;

    @Override
    public boolean matches(String command) {
        List<String> tokens = Arrays.asList(command.split(" "));
        if(tokens.size()>0 && tokens.get(0).equals(COMMAND_NAME)){
            return true;
        }
        return false;
    }

    @Override
    public boolean execute(String command) {
        List<String> tokens = Arrays.asList(command.split(" "));
        String name = tokens.get(1);
        String phoneNumber = tokens.get(2);
        String password = tokens.get(3);

        RegisterUserRequestDTO userRequestDTO = new RegisterUserRequestDTO();
        userRequestDTO.setName(name);
        userRequestDTO.setPhoneNumber(phoneNumber);
        userRequestDTO.setPassword(password);

        userController.registerUser(userRequestDTO);
        return true;
    }
}
