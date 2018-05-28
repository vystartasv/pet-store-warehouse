package com.vilius.petstore.repository;

import com.vilius.petstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByOrderByIdDesc();
}
