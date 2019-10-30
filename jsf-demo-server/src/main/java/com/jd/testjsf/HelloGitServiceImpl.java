package com.jd.testjsf;

public class HelloGitServiceImpl implements HelloGitService{
    @Override
    public String sayHi(String name) {
        System.out.println("hello " +name);
        return name;
    }
}
