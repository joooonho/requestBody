package com.aop.requestbody;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping(value = "/api/my-controller")
public class MyController {

//    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseBody responseBodyTestMethod() {
        log.info("in controller");
        return new ResponseBody("name", 100, 190, 100);
    }
}
