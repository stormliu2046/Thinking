package com.example.demo.transactional.service;

import com.example.demo.transactional.entity.Person;

/**
 * @author robert
 */
public interface PersonService {

    boolean addPerson(Person person);

    boolean updatePersonByPhoneNo(Person person);
}
