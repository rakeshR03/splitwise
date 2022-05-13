package com.practice.splitwise.repositories;

import com.practice.splitwise.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    Group save(Group group);

    Optional<Group> findById(Long id);
}
