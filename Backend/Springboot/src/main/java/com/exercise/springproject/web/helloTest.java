package com.exercise.springproject.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloTest {
    @RequestMapping("/hello")
    public String hello(){
        return "Hello world";
    }
}