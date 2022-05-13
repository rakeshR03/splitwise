package com.practice.splitwise.models;

import com.practice.splitwise.dtos.UserDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User1 extends BaseModel{
    private String name;
    private String phoneNumber;
    private String hashedPassword;

    // method to convert user object to userdto

    public UserDTO userDTO(){
        UserDTO userDTO = new UserDTO();
        userDTO.setPhoneNumber(phoneNumber);
        userDTO.setName(name);
        return userDTO;
    }
}
