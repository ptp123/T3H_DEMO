/**
 * Project name: LoginSecurity
 * Package name: com.example.demo.reposity
 * File name: UserReposity.java
 * Author: ptphuong.
 * Created date: Jan 15, 2019
 * Created time: 9:32:49 AM
 */

package com.example.demo.repository;

/*
 * @author ptphuong.
 * Created date: Jan 15, 2019
 * Created time: 9:32:49 AM
 * Description: TODO - 
 */

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}