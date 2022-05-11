package com.practice.splitwise.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Map;

@Getter
@Setter
@Entity
public class Expense extends BaseModel{
    private int amount;

    private String description;

    @ManyToOne
    private User1 createdBy;

    @ElementCollection
    private Map<User1, Integer> paidBy;

    @ElementCollection
    private Map<User1, Integer> owedBy;
}
