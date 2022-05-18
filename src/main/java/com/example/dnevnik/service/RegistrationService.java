package com.example.dnevnik.service;

import com.example.dnevnik.entities.User;
import com.example.dnevnik.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;

@Service
@Transactional
public class RegistrationService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;

    public User getUser(String name){
        return userRepository.findByName(name);
    }

    public User createUser(User user){
        System.out.println("create user");
        if (userRepository.findByName(user.getName()) != null)
            return null;
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
