package com.practice.splitwise.controllers;

import com.practice.splitwise.dtos.*;
import com.practice.splitwise.models.Transaction;
import com.practice.splitwise.models.User1;
import com.practice.splitwise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public ResponseDTO<UserResponseDTO> registerUser(RegisterUserRequestDTO request){
        // return saved user object
        User1 user = userService.registerUser(request.getName(),
                request.getPhoneNumber(),
                request.getPassword());

        //create UserDTO object
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setPhoneNumber(user.getPhoneNumber());

        //create ResponseDTO object
        ResponseDTO<UserResponseDTO> responseDTO = new ResponseDTO<>();
        responseDTO.setData(new UserResponseDTO());
        responseDTO.getData().setUser(userDTO);
        responseDTO.setStatus(ResponseStatus.SUCCESS);

        return responseDTO;
    }

    public SettleUpResponseDTO settleUp(SettleUpUserRequestDTO request){
        List<Transaction> transactions = userService.settleUp(request.getUserId());

        SettleUpResponseDTO responseDTO = new SettleUpResponseDTO();
        responseDTO.setTransactions(transactions);
        return responseDTO;
    }

    public ResponseDTO<UserResponseDTO> updateUser(UpdateUserRequestDTO request){
        User1 user = userService.updateUser(
                request.getUserId(), request.getName(), request.getPhoneNumber(), request.getPassword());

        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setPhoneNumber(user.getPhoneNumber());

        ResponseDTO<UserResponseDTO> responseDTO = new ResponseDTO<>();
        responseDTO.setStatus(ResponseStatus.SUCCESS);
        responseDTO.getData().setUser(userDTO);

        return responseDTO;
    }
}
