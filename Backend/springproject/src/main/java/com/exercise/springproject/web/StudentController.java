package com.exercise.springproject.web;


import com.exercise.springproject.domain.*;
import com.exercise.springproject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;

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

    @Autowired
    private Login_userService login_userService;

    @Autowired
    private CollectionsService collectionsService;

    @Autowired
    private CourschemasService courschemasService;

    Calendar cal =Calendar.getInstance();

    @GetMapping("/")
    public String index(@SessionAttribute(WebSecurityConfig.SESSION_KEY) String account, Model model) {
        model.addAttribute("name", account);
        return "index";
    }


    @GetMapping("/home")
    public String homepage(){return "home";}



    @GetMapping("/userhome")
    public String userhomepage(HttpSession httpSession){
        boolean login = allUser(httpSession);
        //todo 直接访问应该返回404 page
        if(login){
            return "userhome";
        }
        else{
            return "login";
        }
    }

    @GetMapping("/courschemaEdit")
    public String courshemaEdit(HttpSession httpSession){
        boolean login = allUser(httpSession);
        if(login){
            return "MajorEdit";
        }
        else{
            return "login";
        }
    }

    @GetMapping("/adminhome")
    public String adminhomepage(HttpSession httpSession)
    {
        boolean login = allUser(httpSession);
        if(!login){
            return "login";
        }
        return "adminhome";
    }

    @GetMapping("/sechome")
    public String sechomepage(HttpSession httpSession){
        boolean login = allUser(httpSession);
        if(!login){
            return "login";
        }
        return "sechome";}

    @GetMapping("/AllSchema")
    public String allschema(HttpSession httpSession){
        boolean login = allUser(httpSession);
        if(login){
            return "AllSchema";
        }
        else{
            return "login";
        }
        //return "AllSchema";
    }

    @GetMapping("/testNewCourse")
    public String testNewCourse(HttpSession httpSession){
        boolean login = allUser(httpSession);
        if(!login){
            return "login";
        }
        return "NewCourse";}

    @GetMapping("/Edit")
    public String edit(HttpSession httpSession){
        boolean login = allUser(httpSession);
        if(!login){
            return "login";
        }
        return "Edit";}

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
        List<Integer> temp = collectionsService.findCollectionsByid((Integer) json_map.get("id"));
        List<Map> l = new ArrayList<>();
        for(int i : temp){
            Map<String, Object> now = new HashMap<>();
            courschemas n = courschemasService.findcourschemasById(i);
            now.put("name", n.getChineseName());
            now.put("intro", n.getIntro());
            now.put("cid", n.getCourschema());
            l.add(now);
        }
        reply.put("list", l);
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
        session.removeAttribute("11712819");
        session.removeAttribute("11711335");
        session.removeAttribute("11711613");
        session.removeAttribute("11711111");
        session.removeAttribute("11711721");
        session.removeAttribute("33373337");
        session.removeAttribute("33733335");
        session.removeAttribute("33733336");
        session.removeAttribute("33733338");
        session.removeAttribute("33733339");
        session.removeAttribute("61711111");
        session.removeAttribute("61711335");
        session.removeAttribute("61722222");
        session.removeAttribute("61733333");
        session.removeAttribute("61744444");
        session.removeAttribute("61755555");
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String loginStudent(@Valid studentForm stu, RedirectAttributes attributes, HttpSession httpSession){
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
                    Integer user = stu.getUsername();
                    httpSession.setAttribute(String.valueOf(stu.getUsername()), user);
                    return "redirect:/userhome";
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
                    Integer user = stu.getUsername();
                    httpSession.setAttribute(String.valueOf(stu.getUsername()), user);
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
                    Integer user = stu.getUsername();
                    httpSession.setAttribute(String.valueOf(stu.getUsername()), user);
                    return "redirect:/adminhome";
                }else{
                    attributes.addFlashAttribute("pswmsg","password is not correct");
                    return "redirect:/login";
                }
            }
        }
       // student search = studentService.findStudentByid_student(stu.getUsername());


    }

    private void student_login(student search) {
        int time = 0;
        Login_user login_user = new Login_user();
        time += (cal.get(Calendar.YEAR)-2000)*100000000;
        time += cal.get(Calendar.MONTH)*1000000;
        time += cal.get(Calendar.DATE)*10000;
        time += cal.get(Calendar.HOUR_OF_DAY)*100;
        time += cal.get(Calendar.MINUTE);
        login_user.setId(search.getId());
        login_user.setTime(time);
        login_userService.save(login_user);
    }

    private void secretary_login(secretary secr) {
        int time = 0;
        Login_user login_user = new Login_user();
        time += (cal.get(Calendar.YEAR)-2000)*100000000;
        time += cal.get(Calendar.MONTH)*1000000;
        time += cal.get(Calendar.DATE)*10000;
        time += cal.get(Calendar.HOUR_OF_DAY)*100;
        time += cal.get(Calendar.MINUTE);
        login_user.setId(secr.getId());
        login_user.setTime(time);
        login_userService.save(login_user);
    }

    private void admin_login(Admin adm) {
        int time = 0;
        Login_user login_user = new Login_user();
        time += (cal.get(Calendar.YEAR)-2000)*100000000;
        time += cal.get(Calendar.MONTH)*1000000;
        time += cal.get(Calendar.DATE)*10000;
        time += cal.get(Calendar.HOUR_OF_DAY)*100;
        time += cal.get(Calendar.MINUTE);
        login_user.setId(adm.getIdAdmin());
        login_user.setTime(time);
        login_userService.save(login_user);
    }

//    @PostMapping(value = "/course_student")
//    public String coursePageStudent(RedirectAttributes attributes){
//        return "redirect:/course_student";}

    @GetMapping(value = "/QandA_student")
    public String QandAstudent(RedirectAttributes attributes, HttpSession httpSession){
        boolean login = allUser(httpSession);
        if(!login){
            return "login";
        }
        attributes.addFlashAttribute("errorMsg","the ID is not correct");

        return "QandA_student";
    }

    @GetMapping(value = "/QandA_admin")
    public String QandAadmin(RedirectAttributes attributes, HttpSession httpSession){
        boolean login = allUser(httpSession);
        if(!login){
            return "login";
        }
        return  "QandA_admin";}

    @GetMapping("/courschemaWatch")
    public String watch(HttpSession httpSession){
        boolean login = allUser(httpSession);
        if(!login){
            return "login";
        }
        return "Schema_Watch";
    }

    @GetMapping("/course_student")
    public String course(HttpSession httpSession){
        boolean login = allUser(httpSession);
        if(!login){
            return "login";
        }
        return "course_student";
    }

    @GetMapping("/course_admin")
    public String course_am(HttpSession httpSession){
        boolean login = allUser(httpSession);
        if(!login){
            return "login";
        }
        return "course_admin";
    }

    public boolean allUser(HttpSession httpSession){
        if(httpSession.getAttribute("11712819")!=null){
            return true;
        }
        if(httpSession.getAttribute("11711335")!=null){
            return true;
        }
        if(httpSession.getAttribute("11711613")!=null){
            return true;
        }
        if(httpSession.getAttribute("11711111")!=null){
            return true;
        }
        if(httpSession.getAttribute("11711721")!=null){
            return true;
        }
        if(httpSession.getAttribute("61711111")!=null){
            return true;
        }
        if(httpSession.getAttribute("61711335")!=null){
            return true;
        }
        if(httpSession.getAttribute("61722222")!=null){
            return true;
        }
        if(httpSession.getAttribute("61733333")!=null){
            return true;
        }
        if(httpSession.getAttribute("61744444")!=null){
            return true;
        }
        if(httpSession.getAttribute("61755555")!=null){
            return true;
        }
        if(httpSession.getAttribute("33373337")!=null){
            return true;
        }
        if(httpSession.getAttribute("33733335")!=null){
            return true;
        }
        if(httpSession.getAttribute("33733336")!=null){
            return true;
        }
        if(httpSession.getAttribute("33733338")!=null){
            return true;
        }
        if(httpSession.getAttribute("33733339")!=null){
            return true;
        }

        return false;
    }

//    @PostMapping("/Watch")
//    public String watch(RedirectAttributes attributes){
//        return "redirect:/courschmaWatch";}

//    @PostMapping(value = "/course_admin")
//    public String coursePageAdmin(RedirectAttributes attributes){
//        return "redirect:/course_admin";
//    }



}
