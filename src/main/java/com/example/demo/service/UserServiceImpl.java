/**
 * Project name: LoginSecurity
 * Package name: com.example.demo.service
 * File name: UserServiceImpl.java
 * Author: ptphuong.
 * Created date: Jan 15, 2019
 * Created time: 10:18:18 AM
 */

package com.example.demo.service;

/*
 * @author ptphuong.
 * Created date: Jan 15, 2019
 * Created time: 10:18:18 AM
 * Description: TODO - 
 */

import java.util.Arrays;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;
import com.example.demo.entities.User;

import com.example.demo.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByEmail(String email) {
	return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
	user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	user.setEmail(user.getEmail());
	userRepository.save(user);
    }
}
