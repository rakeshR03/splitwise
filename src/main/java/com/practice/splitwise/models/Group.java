package com.practice.splitwise.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "groups")
public class Group extends BaseModel{

    private String name;

    @ManyToMany
    private List<User1> admins;

    @ManyToMany
    private List<User1> members;


}
