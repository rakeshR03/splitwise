package com.practice.splitwise.repositories;

import com.practice.splitwise.models.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User1, Long> {
    User1 save(User1 user);

    Optional<User1> getUser1ById(Long id);
    // we used optional here because there might not exist a user in database with id;
}
