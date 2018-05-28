package com.vilius.petstore.service;

import com.vilius.petstore.entity.User;
import com.vilius.petstore.repository.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User addUser(User user){
        userRepository.saveAndFlush(user);
        return getLastUserAdded();
    }

    public User getLastUserAdded(){
        return userRepository.findFirstByOrderByIdDesc();
    }

    public User getUserById(Long id){return userRepository.findById(id).get();}
}
