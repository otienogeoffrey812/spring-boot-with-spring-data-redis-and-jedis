package com.artman.Spring.Boot.With.Spring.Data.Redis.And.Jedis.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private int age;
}
