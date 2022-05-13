package com.practice.splitwise.repositories;

import com.practice.splitwise.models.Group;
import com.practice.splitwise.models.GroupExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupExpenseRepository extends JpaRepository<GroupExpense, Long> {

    List<GroupExpense> findAllByGroup(Group group);
}
