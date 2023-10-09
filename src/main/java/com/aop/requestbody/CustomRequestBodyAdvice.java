package com.aop.requestbody;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.JsonViewRequestBodyAdvice;

import java.io.IOException;
import java.lang.reflect.Type;

@Component
@RestControllerAdvice
public class CustomRequestBodyAdvice extends JsonViewRequestBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        System.out.println("In supports() method of " + getClass().getSimpleName());
        return methodParameter.getExecutable().getName().equals("requestBodyTestMethod");
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        System.out.println("In beforeBodyRead() method of " + getClass().getSimpleName());
        return inputMessage;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        System.out.println("In afterBodyRead() method of " + getClass().getSimpleName());
        return body;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        System.out.println("In handleEmptyBody() method of " + getClass().getSimpleName());
        return null;
    }
}
