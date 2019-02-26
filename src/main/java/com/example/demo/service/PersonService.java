package com.example.demo.service;

import com.example.demo.dao.IPersonDao;
import com.example.demo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PersonService {
    @Autowired
    private IPersonDao personDao;

    /**
     * 事务管理测试
     * 两条数据同时成功，或者同时不成功
     * 保证数据库数据的完整性和一致性
     */
    @Transactional
    public void insertTwo(){
        Person personA = new Person();
        personA.setName("秋雅");
        personA.setAge(19);
        personDao.save(personA);
        Person personB = new Person();
        personB.setName("梦特娇");
        personB.setAge(25);
        personDao.save(personB);
    }
}

