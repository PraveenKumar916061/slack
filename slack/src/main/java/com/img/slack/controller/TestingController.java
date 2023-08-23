package com.img.slack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestingController {

    @ResponseBody
    @GetMapping("/hello")
    public String test(){
        return "Hello Slack";
    }
}
