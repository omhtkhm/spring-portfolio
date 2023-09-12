package com.example.study04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/apm")
public class ApmTestController {

    @GetMapping("/sleep/{time}")
    @ResponseBody
    public String apmTestSleep(@PathVariable long time) throws InterruptedException {
        Thread.sleep(time * 1000L);
        return "sleep " + time + " seconds";
    }

}
