package com.exercise.springproject.web;


import com.exercise.springproject.domain.Carowner;
import com.exercise.springproject.domain.student;
import com.exercise.springproject.domain.studentForm;
import com.exercise.springproject.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
这个是控制login的controller，会检测name（id）和密码是否正确，但是给前端传message还存在一点问题，
因为如果使用errormessage的话会自动使用springbbot的error类，即进入/error.html，但其他功能已经检测完毕。
未完善：
给前端return message
跳转界面还均设置的login
 */

@Controller
public class StudentController{
    @Autowired
    private StudentService studentService;
    @GetMapping("/home")
    public String homepage(){return "home";}

    @GetMapping("/userhome")
    public String userhomepage(){return "userhome";}

    @GetMapping("/Edit")
    public String edit(){return "Edit";}

    @GetMapping(value = "/home_student")
    @ResponseBody
    public student handle(@RequestBody Map<String, Integer> json_map){
        ObjectMapper mapper = new ObjectMapper();
        return studentService.findStudentByid_student(json_map.get("id"));
    }

    // from /home/login change to this
    @GetMapping("/login")
    public String loginpage(){return "login";}

    @PostMapping("/login")
    public String loginStudent(@Valid studentForm stu, RedirectAttributes attributes){
        //判断开头数字，从不同表里找用户
        student search = studentService.findStudentByid_student(stu.getUsername());
        if ((stu.getUsername() == 0 )&&(stu.getPassword() == null)){
            attributes.addFlashAttribute("pswmsg","password cannot be none");
            attributes.addFlashAttribute("namemsg","StudentId cannot be none");
            return "redirect:/login";
        }
        if (stu.getUsername() == 0){
            attributes.addFlashAttribute("errorMsg","StudentId cannot be none");
            attributes.addFlashAttribute("namemsg","StudentId cannot be none");
            return "redirect:/login";
        }
        if (stu.getPassword().equals("")){
            attributes.addFlashAttribute("errorMsg","password cannot be none");
            attributes.addFlashAttribute("pswmsg","password cannot be none");
            return "redirect:/login";
        }
        if (search==null){
            attributes.addFlashAttribute("errorMsg","the ID is not correct");
            attributes.addFlashAttribute("namemsg","the ID is not correct");
            return "redirect:/login";
        }else {
            if (search.getPassword().equals(stu.getPassword())){
                attributes.addAttribute("param", stu.getUsername());
                return "redirect:/userhome";
            }else{
               // attributes.addFlashAttribute("errorMsg","password is not correct");
                attributes.addFlashAttribute("pswmsg","password is not correct");
                // console.log("here");

                return "redirect:/login";
            }
        }
    }


}
