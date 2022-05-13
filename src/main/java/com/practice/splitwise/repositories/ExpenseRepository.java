package com.practice.splitwise.repositories;


import com.practice.splitwise.models.Expense;
import com.practice.splitwise.models.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findAllByPaidByContainingOrOwedByContaining(Long userId1, Long userId2);

    // select * from expense where
    // paidBy contains userId OR
    // owedBy contains userId
}
