package com.practice.splitwise.services;

import com.practice.splitwise.dtos.RegisterUserRequestDTO;
import com.practice.splitwise.dtos.UserDTO;
import com.practice.splitwise.models.Expense;
import com.practice.splitwise.models.Transaction;
import com.practice.splitwise.models.User1;
import com.practice.splitwise.repositories.ExpenseRepository;
import com.practice.splitwise.repositories.UserRepository;
import com.practice.splitwise.services.hashedpasswordservice.PasswordHashingStrategy;
import com.practice.splitwise.strategy.settleup.SettleUpExpenseStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private PasswordHashingStrategy passwordHashingStrategy;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private SettleUpExpenseStrategy expenseStrategy;

    public User1 registerUser(String name, String phoneNUmber, String password){

        // create hashed password
        String hashedPassword = passwordHashingStrategy.hash(password);

        // create user object
        User1 user = new User1();
        user.setName(name);
        user.setPhoneNumber(phoneNUmber);
        user.setHashedPassword(hashedPassword);

        // save the user object
        User1 savedUser = userRepository.save(user);

        // return saved user object
        return savedUser;
    }

    public List<Transaction> settleUp(Long userId){

        // 1. get all the expenses associated to this user
        List<Expense> expenses = expenseRepository.findAllByPaidByContainingOrOwedByContaining(userId, userId);

        // 2. perform settleUp strategy to get all transaction and return transaction.
        List<Transaction> transactions = expenseStrategy.settle(expenses);

        // 3. filter the transactions that are done by user.
        List<Transaction> filteredTransactions = new ArrayList<>();

        User1 user = userRepository.getUser1ById(userId).get();

        for(Transaction transaction : transactions){
            if(transaction.getTo().getPhoneNumber().equals(user.getPhoneNumber()) ||
            transaction.getFrom().getPhoneNumber().equals(user.getPhoneNumber())
            ){
                filteredTransactions.add(transaction);
            }
        }

        return filteredTransactions;
    }

    public User1 updateUser(Long userId, String name, String phoneNumber, String password){

        User1 user = userRepository.getUser1ById(userId).get();

        String hashedPassword = passwordHashingStrategy.hash(password);

        user.setPhoneNumber(phoneNumber);
        user.setName(name);
        user.setHashedPassword(hashedPassword);
        return userRepository.save(user);

    }
}

// don't tightly couple service with request
// same service can be used by multiple request.


// Difference between saved user and user is that saved user will have id but user will not.