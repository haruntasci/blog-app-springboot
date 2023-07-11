package com.haruntasci.springbootangularcrud.service;

import com.haruntasci.springbootangularcrud.model.User;
import com.haruntasci.springbootangularcrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User createUser(User user) {
        return userRepository.save(user);
    }


    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }


    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


    public User updateUser(User user, Long id) {
        User user1 = userRepository.findById(id).get();

        user1.setUsername(user.getUsername());
        user1.setEmail(user.getEmail());
        user1.setIsActive(user.getIsActive());


        return userRepository.save(user1);
    }
}
