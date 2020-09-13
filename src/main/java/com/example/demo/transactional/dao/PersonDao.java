package com.example.demo.transactional.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.transactional.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author robert
 */
@Repository
@Mapper
public interface PersonDao extends BaseMapper<Person> {

    int updatePersonByPhoneNo(Person person);

    int insertPerson(Person person);
}
