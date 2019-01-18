/**
 * Project name: LoginSecurity
 * Package name: com.example.demo.service
 * File name: UserInterface.java
 * Author: ptphuong.
 * Created date: Jan 15, 2019
 * Created time: 10:16:41 AM
 */

package com.example.demo.service;

import org.springframework.stereotype.Service;

/*
 * @author ptphuong.
 * Created date: Jan 15, 2019
 * Created time: 10:16:41 AM
 * Description: TODO - 
 */
import com.example.demo.entities.User;

@Service
public interface UserService {

    public User findUserByEmail(String email);
    public void saveUser(User user);
}
