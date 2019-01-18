package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Personal;
import com.example.demo.repository.PersonalRepository;

/**
 * 
 * @author ptphuong. Created date: Jan 15, 2019 Created time: 1:26:27 PM
 *         Description: TODO -
 */

@Service
@Transactional
public class PersonalService {

    @Autowired
    PersonalRepository personalRepository;
    @Autowired
    EntityManager entityManager;

    public List<Personal> getAll() {
	return personalRepository.findAll();
    }

    public Personal getOne(int id) {
	return entityManager.find(Personal.class, id);
    }

    public void insert(Personal personal) {
	entityManager.persist(personal);
    }

    public void update(Personal personal) {
	entityManager.merge(personal);
    }

    public void delete(int id) {
	personalRepository.deleteById(id);
    }
}
