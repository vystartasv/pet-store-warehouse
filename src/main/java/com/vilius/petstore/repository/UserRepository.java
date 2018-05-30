package com.vilius.petstore.repository;

import com.vilius.petstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByOrderByIdDesc();

    List<User> findByNameOrderById(String name);

    User findUserByUsername(String username);
}
