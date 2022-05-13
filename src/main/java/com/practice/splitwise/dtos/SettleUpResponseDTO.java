package com.practice.splitwise.dtos;

import com.practice.splitwise.models.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpResponseDTO {
    private List<Transaction> transactions;
}
