package com.exercise.springproject.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
@RestController
public class RedirectController {

//    @PostMapping("/redirectFunction")
//    @ResponseBody
//    public String redirect(@RequestBody Map<String, Object> json, RedirectAttributes attributes){
//        String url = (String) json.get("url");
//        int pa = (int) json.get("param");
//        re(url,pa,attributes);
//        return "success";
//    }
//
//    public RedirectView re(String url, int param, RedirectAttributes attributes){
//        RedirectView redirectTarget = new RedirectView();
//        redirectTarget.setContextRelative(true);
//        redirectTarget.setUrl(url);
//        attributes.addAttribute(param);
//        System.out.println(redirectTarget);
//        return redirectTarget;
//    }
//
//    @RequestMapping("/foo")
//    void handleFoo(HttpServletResponse response) throws IOException {
//        response.sendRedirect("some-url");
//    }

    @GetMapping("/courschemaWatch")
    public String watch(){return "Courschema_Watch";}

}
