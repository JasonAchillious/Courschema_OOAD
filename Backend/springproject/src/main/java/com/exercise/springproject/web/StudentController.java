package com.exercise.springproject.web;


import com.exercise.springproject.domain.*;
import com.exercise.springproject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
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

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private MajorService majorService;

    @Autowired
    private SecretaryService secretaryService;

    @Autowired
    private AdminService adminService;

    @GetMapping("/")
    public String index(@SessionAttribute(WebSecurityConfig.SESSION_KEY) String account, Model model) {
        model.addAttribute("name", account);
        return "index";
    }


    @GetMapping("/home")
    public String homepage(){return "home";}

    @GetMapping("/userhome")
    public String userhomepage(){
        //todo 直接访问应该返回404 page
        return "userhome";
    }

    @GetMapping("/courschemaEdit")
    public String courshemaEdit(){return "MajorEdit";}

    @GetMapping("/adminhome")
    public String adminhomepage()
    {
        return "adminhome";
    }

    @GetMapping("/sechome")
    public String sechomepage(){return "sechome";}

    @GetMapping("/AllSchema")
    public String allschema(){return "AllSchema";}

    @GetMapping("/Edit")
    public String edit(){return "Edit";}

    @PostMapping(value = "/home_student")
    @ResponseBody
    public Map handle(@RequestBody Map<String, Object> json_map){
       // ObjectMapper mapper = new ObjectMapper();

        System.out.println(json_map.get("id"));
        Map <String,Object> reply = new HashMap<String,Object>();
        //Class t = json_map.get("id").getClass();
       // System.out.println(t.getName());
        student s = studentService.findStudentByid_student((int)json_map.get("id"));
        System.out.println(s.getMajor());

        Major m = majorService.findMajorById(s.getMajor());
        System.out.println(m.getChineseName());

        Department d = departmentService.findDepartmentById(s.getDepartment());
        System.out.println(d.getChineseName());
        reply.put("id", json_map.get("id"));
        reply.put("department", d.getChineseName());
        reply.put("major", m.getChineseName());
        reply.put("name", s.getName());
        reply.put("beginyear", s.getBeginYear());
        reply.put("englishlevel", s.getEnglishLevel());
        return reply;
    }

    // from /home/login change to this
    @GetMapping("/login")
    public String loginpage(){
        return "login";
    }

//    @PostMapping("/login")
//    public String loginPost(@Valid studentForm stu,RedirectAttributes attributes, HttpSession session) {
//        Map<String, Object> map = new HashMap<>();
//        if ((stu.getUsername() == 0 )&&(stu.getPassword() == null)){
//            attributes.addFlashAttribute("pswmsg","password cannot be none");
//            attributes.addFlashAttribute("namemsg","StudentId cannot be none");
//            return "redirect:/login";
//           // map.put("success", false);
//            //map.put("message", "用户名和密码不能为空");
//           // return map;
//        }
//        if (stu.getUsername() == 0){
//            attributes.addFlashAttribute("errorMsg","StudentId cannot be none");
//            attributes.addFlashAttribute("namemsg","StudentId cannot be none");
//            return "redirect:/login";
////            map.put("type", null);
////            map.put("success", false);
////            map.put("message", "用户名不能为空");
//            //return map;
//        }
//        if (stu.getPassword().equals("")){
//            attributes.addFlashAttribute("errorMsg","password cannot be none");
//            attributes.addFlashAttribute("pswmsg","password cannot be none");
//            return "redirect:/login";
////            map.put("type", null);
////            map.put("success", false);
////            map.put("message", "密码不能为空");
//            //return map;
//        }
//
//        int idtemp = stu.getUsername();
//        if(idtemp>10000000 && idtemp <20000000){
//            //stu
//            student search = studentService.findStudentByid_student(stu.getUsername());
//            if (search==null){
//                attributes.addFlashAttribute("errorMsg","the ID is not correct");
//                attributes.addFlashAttribute("namemsg","the ID is not correct");
//                return "redirect:/login";
////                map.put("type", "student");
////                map.put("success", false);
////                map.put("message","用户名不正确");
//                //return map;
//            }else {
//                if (search.getPassword().equals(stu.getPassword())){
//                    attributes.addAttribute("param", stu.getUsername());
//                    return "redirect:/AllSchema";
//                   // session.setAttribute(WebSecurityConfig.SESSION_KEY, stu.getUsername());
////                    map.put("type", "student");
////                    map.put("success", true);
////                    map.put("message", "登录成功");
//                    //return map;
//
//                }else{
//                    attributes.addFlashAttribute("pswmsg","password is not correct");
//                    return "redirect:/login";
////                    map.put("type", "student");
////                    map.put("success", false);
////                    map.put("message","密码不正确");
//                    //return map;
//                }
//            }
//        }else if(idtemp>30000000 && idtemp <40000000){
//            //secreatary
//            secretary secr = secretaryService.findSecretaryById(stu.getUsername());
//            if (secr==null){
//                attributes.addFlashAttribute("errorMsg","the ID is not correct");
//                attributes.addFlashAttribute("namemsg","the ID is not correct");
//                return "redirect:/login";
////                map.put("type", "secretary");
////                map.put("success", false);
////                map.put("message","用户名不正确");
//                //return map;
//            }else {
//                if (secr.getPassword().equals(stu.getPassword())){
//                    attributes.addAttribute("param", stu.getUsername());
//                    return "redirect:/sechome";
////                    map.put("type", "secretary");
////                    map.put("success", true);
////                    map.put("message","登录成功");
//                  //  session.setAttribute(WebSecurityConfig.SESSION_KEY, stu.getUsername());
//                   // return map;
//                }else{
//                    attributes.addFlashAttribute("pswmsg","password is not correct");
//                    return "redirect:/login";
////                    map.put("type", "secretary");
////                    map.put("success", false);
////                    map.put("message","密码不正确");
//                    //return map;
//                }
//            }
//        }else{
//            //admin
//            Admin adm = adminService.findAdminByIdAdmin(stu.getUsername());
//            if (adm==null){
//                attributes.addFlashAttribute("errorMsg","the ID is not correct");
//                attributes.addFlashAttribute("namemsg","the ID is not correct");
//                return "redirect:/login";
////                map.put("type", "admin");
////                map.put("success", false);
////                map.put("message","用户名不正确");
//                //return map;
//            }else {
//                if (adm.getPassword().equals(stu.getPassword())){
//                    attributes.addAttribute("param", stu.getUsername());
//                    return "redirect:/adminhome";
////                    map.put("type", "admin");
////                    map.put("success", true);
////                    map.put("message","登录成功");
//                  //  session.setAttribute(WebSecurityConfig.SESSION_KEY, stu.getUsername());
//                    //return map;
//                }else{
//                    attributes.addFlashAttribute("pswmsg","password is not correct");
////                    return "redirect:/login";
////                    map.put("type", "admin");
////                    map.put("success", false);
////                    map.put("message","密码不正确");
//                    //
//
//
//                }
//            }
//        }
//        return "redirect:/login";
//
//    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String loginStudent(@Valid studentForm stu, RedirectAttributes attributes){
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


        //判断开头数字，从不同表里找用户
        int idtemp = stu.getUsername();
        if(idtemp>10000000 && idtemp <20000000){
            //stu
            student search = studentService.findStudentByid_student(stu.getUsername());
            if (search==null){
                attributes.addFlashAttribute("errorMsg","the ID is not correct");
                attributes.addFlashAttribute("namemsg","the ID is not correct");
                return "redirect:/login";
            }else {
                if (search.getPassword().equals(stu.getPassword())){
                    attributes.addAttribute("param", stu.getUsername());
                    return "redirect:/AllSchema";
                }else{
                    attributes.addFlashAttribute("pswmsg","password is not correct");
                    return "redirect:/login";
                }
            }
        }else if(idtemp>30000000 && idtemp <40000000){
            //secreatary
            secretary secr = secretaryService.findSecretaryById(stu.getUsername());
            if (secr==null){
                attributes.addFlashAttribute("errorMsg","the ID is not correct");
                attributes.addFlashAttribute("namemsg","the ID is not correct");
                return "redirect:/login";
            }else {
                if (secr.getPassword().equals(stu.getPassword())){
                    attributes.addAttribute("param", stu.getUsername());
                    return "redirect:/sechome";
                }else{
                    attributes.addFlashAttribute("pswmsg","password is not correct");
                    return "redirect:/login";
                }
            }
        }else{
            //admin
            Admin adm = adminService.findAdminByIdAdmin(stu.getUsername());
            if (adm==null){
                attributes.addFlashAttribute("errorMsg","the ID is not correct");
                attributes.addFlashAttribute("namemsg","the ID is not correct");
                return "redirect:/login";
            }else {
                if (adm.getPassword().equals(stu.getPassword())){
                    attributes.addAttribute("param", stu.getUsername());
                    return "redirect:/adminhome";
                }else{
                    attributes.addFlashAttribute("pswmsg","password is not correct");
                    return "redirect:/login";
                }
            }
        }
       // student search = studentService.findStudentByid_student(stu.getUsername());


    }


}
