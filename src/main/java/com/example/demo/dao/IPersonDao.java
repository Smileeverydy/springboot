package com.example.demo.dao;

import com.example.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPersonDao extends JpaRepository<Person, Integer> {
    /**
     *  通过年龄来查询
     *  方法名固定findByAge
     * @param age
     * @return
     */
    @Query(value = "select * from person where id = ?1", nativeQuery = true)
    @Modifying
     List<Person> findByAge(Integer age);
    /*
     *  通过两表来查询
     *  方法名固定getTwo
     * @param
     * @return
             */
    @Query(value = "select p.*,t.* from person p inner join t_user t on p.name = t.t_userName", nativeQuery = true)
    @Modifying
    List<Object> getTwo();
}

