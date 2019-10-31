package com.jd.lvhp.jsf.service;

public class FirstJsfServiceImpl implements FirstJsfService {
    @Override
    public String sayHi(String name) {
        System.out.println("hello " +name);
        return name;
    }
}
