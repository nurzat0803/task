package com.example.task.repository;

import com.example.task.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT u from User u Where u.username = :username")
    public User getUserByUsername(@Param("username") String username);

    Object findAll(Pageable pageable);
}
