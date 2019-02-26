package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by 不爱编程的程序猿
 * 2018/11/8
 */

@Entity
public class User {
    @Id
    @GeneratedValue
    //用户名
    private Integer id;
    //用户名
    private String userName;
    //密码
    private String password;
    //必须要有构造函数
    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}