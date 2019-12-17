package com.exercise.springproject.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@Controller
@RestController
public class RedirectController {

    @PostMapping("/redirectFunction")
    @ResponseBody
    public String redirect(@RequestBody Map<String, Object> json, RedirectAttributes attributes){
        String url = (String) json.get("url");
        int pa = (int) json.get("param");
        re(url,pa,attributes);
        return "success";
    }

    public RedirectView re(String url, int param, RedirectAttributes attributes){
        RedirectView redirectTarget = new RedirectView();
        redirectTarget.setContextRelative(true);
        redirectTarget.setUrl(url);
        attributes.addAttribute(param);
        System.out.println(redirectTarget);
        return redirectTarget;
    }

}
