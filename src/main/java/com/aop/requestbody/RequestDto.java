package com.aop.requestbody;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RequestDto {
    private String name;
    private int age;
}
