package com.practice.splitwise.strategy.settleup;

import com.practice.splitwise.models.Expense;
import com.practice.splitwise.models.Transaction;
import com.practice.splitwise.models.User1;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GreedySettleUpExpenseStrategy implements SettleUpExpenseStrategy{

    @Override
    public List<Transaction> settle(List<Expense> expenses) {

        class Record{
            User1 user;
            int pendingAmount;

            Record(User1 user, int pendingAmount){
                this.user = user;
                this.pendingAmount = pendingAmount;
            }
        }

        Map<User1, Integer> extraMoney = new HashMap<>();

        // add all the amount paidby each user in all expenses and store the value to extraMoney
        for(Expense expense : expenses){
            for(User1 user: expense.getPaidBy().keySet()){
                extraMoney.put(user, extraMoney.get(user) + expense.getPaidBy().get(user));
            }
        }

        // add all the amount owedby each user in all expenses and store the value to extraMoney
        for(Expense expense : expenses){
            for(User1 user: expense.getPaidBy().keySet()){
                extraMoney.put(user, extraMoney.get(user) - expense.getPaidBy().get(user));
            }
        }

        Queue<Record> negativeQueue = new ArrayDeque<>();
        Queue<Record> positiveQueue = new ArrayDeque<>();

        for(User1 user: extraMoney.keySet()){
            if(extraMoney.get(user) < 0){
                negativeQueue.add(new Record(user, extraMoney.get(user)));
            }
            else if(extraMoney.get(user) > 0){
                positiveQueue.add(new Record(user, extraMoney.get(user)));
            }
        }
        List<Transaction> transactions = new ArrayList<>();
        while(!negativeQueue.isEmpty() && !positiveQueue.isEmpty()){
            Record firstNegative = negativeQueue.remove();
            Record firstPositive = positiveQueue.remove();
            int diff = firstNegative.pendingAmount + firstPositive.pendingAmount;
            if(Math.abs(firstNegative.pendingAmount) > firstPositive.pendingAmount){

                transactions.add(
                        new Transaction(firstNegative.user.userDTO(), firstPositive.user.userDTO(),
                                firstPositive.pendingAmount));

                negativeQueue.add(new Record(firstNegative.user, diff));
            }
            else{
                transactions.add(
                        new Transaction(firstNegative.user.userDTO(), firstPositive.user.userDTO(),
                                firstNegative.pendingAmount));

                positiveQueue.add(new Record(firstPositive.user, diff));
            }


        }

        return transactions;
    }
}
