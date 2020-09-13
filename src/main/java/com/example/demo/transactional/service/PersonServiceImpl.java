package com.example.demo.transactional.service;

import com.example.demo.transactional.dao.PersonDao;
import com.example.demo.transactional.entity.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author mi
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Resource
    PersonDao personDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addPerson(Person person) {
        return personDao.insertPerson(person) > 0;
    }

    @Override
    //@Transactional
    public boolean updatePersonByPhoneNo(Person person) {
        boolean result = personDao.updatePersonByPhoneNo(person) > 0;
        //测试同一个类中@Transactional是否起作用
        addPerson(person);
        return result;
    }
}