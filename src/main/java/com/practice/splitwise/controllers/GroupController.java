package com.practice.splitwise.controllers;

import com.practice.splitwise.dtos.SettleUpGroupRequestDTO;
import com.practice.splitwise.dtos.SettleUpResponseDTO;
import com.practice.splitwise.models.Transaction;
import com.practice.splitwise.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GroupController {

    @Autowired
    private GroupService groupService;

    public SettleUpResponseDTO settleUp(SettleUpGroupRequestDTO requestDTO){
        List<Transaction> transactions = groupService.settleUp(requestDTO.getGroupId());

        SettleUpResponseDTO settleUpGroupResponseDTO = new SettleUpResponseDTO();
        settleUpGroupResponseDTO.setTransactions(transactions);
        return settleUpGroupResponseDTO;
    };

    /* will return list of transaction between users, if made will settle all users in the group.
        sample output
        1 -> 2 : 300
        2 -> 3 : 400
        3 -> 4 : 200

     */
}
