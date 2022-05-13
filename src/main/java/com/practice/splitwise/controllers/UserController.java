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

    public ResponseDTO<RegisterUserResponseDTO> registerUser(RegisterUserRequestDTO request){
        // return saved user object
        User1 user = userService.registerUser(request.getName(),
                request.getPhoneNumber(),
                request.getPassword());

        //create UserDTO object
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setPhoneNumber(user.getPhoneNumber());

        //create ResponseDTO object
        ResponseDTO<RegisterUserResponseDTO> responseDTO = new ResponseDTO<>();
        responseDTO.setData(new RegisterUserResponseDTO());
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
}
