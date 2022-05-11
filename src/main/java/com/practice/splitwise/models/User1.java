package com.practice.splitwise.models;

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
}
