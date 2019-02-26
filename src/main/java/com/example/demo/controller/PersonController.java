package com.example.demo.controller;


import com.example.demo.dao.IPersonDao;
import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/personController")
public class PersonController {
    @Autowired
    IPersonDao personDao;
    @Autowired
    private PersonService personService;

    @GetMapping(value = "/person")
    private List<Person> personList() {
        return personDao.findAll();
    }

    /**
     * 添加一个人员
     *
     * @param name
     * @param age
     * @return
     */
    @PostMapping(value = "/personAdd")
    public Person personAdd(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "age", required = false) Integer age) {
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        personDao.save(person);
        return person;
    }

    /**
     * 查询一个人员
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/personOne/{id}")
    public Person personFindOne(@PathVariable("id") Integer id) {
       // return personDao.findOne(id);
        return null;
    }

    /**
     * 删除一个人员
     *
     * @param id
     */
    @DeleteMapping(value = "/personDelate/{id}")
    public void personDelete(@PathVariable("id") Integer id) {
        Person person = new Person();
        person.setId(4);
        personDao.delete(person);
    }


    /**
     * 更新一个人员
     *
     * @param id
     * @param name
     * @param age
     * @return
     */
    @PutMapping(value = "/personUpdate/{id}/{name}/{age}")
    public Person personUpdate(@PathVariable("id") Integer id,
                               @PathVariable("name") String name,
                               @PathVariable("age") Integer age) {
        Person person = new Person();
        person.setId(id);
        person.setName(name);
        person.setAge(age);
        return personDao.save(person);
    }
    /**
     * 通过年龄来查询
     * @param age
     * @return
     */
    @GetMapping(value = "/personByAge/{age}")
    public List<Person> personListByAge(@PathVariable("age") Integer age) {
        return personDao.findByAge(age);
    }
    /**
     * 通过两表来查询
     * @param
     * @return
     */
    @GetMapping(value = "/getTwo")
    public List<Map<String, Object>>  getTwo() {
        List<Object> list = personDao.getTwo();
        List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            Object[] obj = (Object[]) list.get(i);
            map.put("id",obj[0]);
            map.put("name",obj[1]);
            map.put("age",obj[2]);
            map.put("t_id",obj[3]);
            map.put("t_userName",obj[4]);
            map.put("t_passWord",obj[5]);
            listMap.add(map);
        }
        return listMap;
    }

    @PostMapping("/person/two")
    public void personTwo(){
        personService.insertTwo();
    }
}