package com.aop.requestbody;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/request-body/test1")
public class MyRestController {

    @PutMapping("/used/{height}")
    public ResponseBody requestBodyTestMethod(@RequestBody RequestDto requestDto
            , @PathVariable int height, int weight) {
        return new ResponseBody(requestDto.getName(), requestDto.getAge(), height, weight);
    }

    @GetMapping("/test2")
    public void getMapping() {
        log.info("getMapping");
    }
}
