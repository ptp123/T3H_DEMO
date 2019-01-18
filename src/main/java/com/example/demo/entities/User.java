/**
 * Project name: LoginSecurity
 * Package name: com.example.demo.entities
 * File name: User.java
 * Author: ptphuong.
 * Created date: Jan 15, 2019
 * Created time: 9:27:12 AM
 */

package com.example.demo.entities;

/*
 * @author ptphuong.
 * Created date: Jan 15, 2019
 * Created time: 9:27:12 AM
 * Description: TODO - 
 */
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "user")
public class User {
    
    
    public User() {
    }
    
    public User(
	    @Email(message = "*Please provide a valid Email") @NotEmpty(message = "*Please provide an email") String email,
	    @Length(min = 5, message = "*Your password must have at least 5 characters") @NotEmpty(message = "*Please provide your password") String password) {
	super();
	this.email = email;
	this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;

    @Column(name = "email")
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String email;

    @Column(name = "password")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    @Transient
    private String password;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getEmail() {

	return email;

    }

    public void setEmail(String email) {

	this.email = email;

    }
}