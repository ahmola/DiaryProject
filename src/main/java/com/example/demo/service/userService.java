package com.example.demo.service;

import com.example.demo.model.user;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {
    @Autowired
    private UserRepository userRepository;

    public List<user> findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    @Transactional
    public int save(user User){
        try{
            List<user> users = userRepository.findByPassword(User.getPassword());
            if(users.isEmpty()){
                userRepository.save(User);
                return 1;
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("userService: 회원가입() : " + e.getMessage());
        }
        return -1;
    }
}
