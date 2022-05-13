package com.practice.splitwise.dtos;

import com.practice.splitwise.models.User1;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GroupDTO {
    private String name;
    private List<User1> admins;
    private List<User1> members;
}
