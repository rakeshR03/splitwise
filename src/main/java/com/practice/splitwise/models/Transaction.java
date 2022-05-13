package com.practice.splitwise.models;

import com.practice.splitwise.dtos.UserDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {
    private UserDTO to;
    private UserDTO from;
    private Integer amount;

    public Transaction(UserDTO from, UserDTO to, Integer amount){
        this.to = to;
        this.from = from;
        this.amount = amount;
    }


}
