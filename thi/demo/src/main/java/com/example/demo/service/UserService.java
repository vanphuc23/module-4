package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public void create(User user) {
        userRepository.save(user);
    }
}
