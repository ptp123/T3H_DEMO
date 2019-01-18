package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Personal;

/**
 * 
 * @author ptphuong. Created date: Jan 15, 2019 Created time: 1:25:38 PM
 *         Description: TODO -
 */
@Repository
public interface PersonalRepository extends JpaRepository<Personal, Integer> {

}
