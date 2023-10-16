package com.aop.requestbody;

import lombok.Getter;

@Getter
public class ResponseBody {
    private String name;
    private int age;
    private int height;
    private int weight;

    public ResponseBody(String name, int age, int height, int weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }
}
