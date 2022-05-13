package com.practice.splitwise.strategy.settleup;

import com.practice.splitwise.models.Expense;
import com.practice.splitwise.models.Transaction;

import java.util.List;

public interface SettleUpExpenseStrategy {
    List<Transaction> settle(List<Expense> expenses);
}
