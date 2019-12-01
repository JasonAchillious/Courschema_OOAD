package com.exercise.springproject.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class TestTransmitController {
    @GetMapping("/TransmitTest")
    public String sayHello(){
        return "TransmitTest";
    }

    // This is an example of transmit list
    @PostMapping(value = "/TransmitTestList")
    @ResponseBody
    public Map<String, Object> handle(@RequestBody Map<String,Object> json_map){
        // Jackson Json parser
        ObjectMapper mapper = new ObjectMapper();

        System.out.println("--------Test-------");
        System.out.println(json_map);
        String list = (String)json_map.get("list");
        System.out.println(list);
        //you need to parse String to List
        //you can also define a class and transform to it directly.
        try {
            List data = mapper.readValue(list, List.class);
            System.out.println(data);
            System.out.println(data.get(0));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        //this is an example of reply, if you need to send an object, use Jackson transform tools.
        Map<String,Object> map = new HashMap<>();
        map.put("success",true);
        map.put("message","更新成功了！");

        return map;
    }
}
