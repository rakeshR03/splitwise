package com.practice.splitwise.services;

import com.practice.splitwise.models.*;
import com.practice.splitwise.repositories.GroupExpenseRepository;
import com.practice.splitwise.repositories.GroupRepository;
import com.practice.splitwise.strategy.settleup.SettleUpExpenseStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupExpenseRepository groupExpenseRepository;

    @Autowired
    private SettleUpExpenseStrategy strategy;

    @Autowired
    private GroupRepository groupRepository;

    public List<Transaction> settleUp(Long groupId){

        // 1. get all the expenses of the group

        Group group = groupRepository.findById(groupId).get();

        List<GroupExpense> groupExpenses = groupExpenseRepository.findAllByGroup(group);

        List<Expense> expenses = new ArrayList<>();

        for(GroupExpense groupExpense : groupExpenses){
            expenses.add(groupExpense.getExpense());
        }

        // 2. call the algo that takes a list of expenses and return a list of
        //    transactions to settle up those expenses.

        return strategy.settle(expenses);
    }

    public Group registerGroup(String name, List<User1> admins, List<User1> members){

        Group group = new Group();
        group.setName(name);
        group.setAdmins(admins);
        group.setMembers(members);

        return groupRepository.save(group);
    }
}
