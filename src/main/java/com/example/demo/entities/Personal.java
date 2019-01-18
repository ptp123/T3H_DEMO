package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "personal")
public class Personal {

    @Id
    @Column(name = "perrsonal_id", length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personal_id;
    @Column(name = "firstname", length = 20, nullable = false)
    private String firstname;
    @Column(name = "lastname", length = 20, nullable = false)
    private String lastname;
    @Column(name = "email", length = 50, nullable = false)
    private String email;
    @Column(name = "mobile", length = 11, nullable = false)
    private String mobile;
    @Column(name = "hobies", length = 50, nullable = false)
    private String hobies;
    @Column(name = "desciption", length = 200, nullable = false)
    private String description;

    public Personal() {

    }

    public Personal(int personal_id, String firstname, String lastname, String email, String mobile,
	    String description) {
	super();
	this.personal_id = personal_id;
	this.firstname = firstname;
	this.lastname = lastname;
	this.email = email;
	this.mobile = mobile;
	this.hobies = hobies;
	this.description = description;
    }

    /*
     * Author: ptphuong. Created date: Jan 15, 2019 Created time: 2:18:02 PM
     * 
     * @return the personal_id
     */
    public int getPersonal_id() {
	return personal_id;
    }

    /*
     * Author: ptphuong. Created date: Jan 15, 2019 Created time: 2:24:35 PM
     * 
     * @return the hobies
     */
    public String getHobies() {
	return hobies;
    }

    /*
     * Author: ptphuong. Created date: Jan 15, 2019 Created time: 2:24:35 PM
     * 
     * @param hobies the hobies to set
     */
    public void setHobies(String hobies) {
	this.hobies = hobies;
    }

    /*
     * Author: ptphuong. Created date: Jan 15, 2019 Created time: 2:18:02 PM
     * 
     * @param personal_id the personal_id to set
     */
    public void setPersonal_id(int personal_id) {
	this.personal_id = personal_id;
    }

    /*
     * Author: ptphuong. Created date: Jan 15, 2019 Created time: 2:18:02 PM
     * 
     * @return the firstname
     */
    public String getFirstname() {
	return firstname;
    }

    /*
     * Author: ptphuong. Created date: Jan 15, 2019 Created time: 2:18:02 PM
     * 
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
	this.firstname = firstname;
    }

    /*
     * Author: ptphuong. Created date: Jan 15, 2019 Created time: 2:18:02 PM
     * 
     * @return the lastname
     */
    public String getLastname() {
	return lastname;
    }

    /*
     * Author: ptphuong. Created date: Jan 15, 2019 Created time: 2:18:02 PM
     * 
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
	this.lastname = lastname;
    }

    /*
     * Author: ptphuong. Created date: Jan 15, 2019 Created time: 2:18:02 PM
     * 
     * @return the email
     */
    public String getEmail() {
	return email;
    }

    /*
     * Author: ptphuong. Created date: Jan 15, 2019 Created time: 2:18:02 PM
     * 
     * @param email the email to set
     */
    public void setEmail(String email) {
	this.email = email;
    }

    /*
     * Author: ptphuong. Created date: Jan 15, 2019 Created time: 2:18:02 PM
     * 
     * @return the mobile
     */
    public String getMobile() {
	return mobile;
    }

    /*
     * Author: ptphuong. Created date: Jan 15, 2019 Created time: 2:18:02 PM
     * 
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
	this.mobile = mobile;
    }

    /*
     * Author: ptphuong. Created date: Jan 15, 2019 Created time: 2:18:02 PM
     * 
     * @return the description
     */
    public String getDescription() {
	return description;
    }

    /*
     * Author: ptphuong. Created date: Jan 15, 2019 Created time: 2:18:02 PM
     * 
     * @param description the description to set
     */
    public void setDescription(String description) {
	this.description = description;
    }

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return super.toString();
    }
}
