package com.aop.requestbody;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/request-body")
public class Controller {

    @GetMapping("/used")
    public ResponseEntity<RequestDto> useRequestBodyTest(@RequestBody RequestDto requestDto) {
        return ResponseEntity.ok(requestDto);
    }
}
