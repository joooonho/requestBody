package com.aop.requestbody;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/request-body")
public class Controller {

    @PutMapping("/used")
    public ResponseEntity<RequestDto> useRequestBodyTest(@RequestBody RequestDto requestDto) {
        return ResponseEntity.ok(requestDto);
    }
}
