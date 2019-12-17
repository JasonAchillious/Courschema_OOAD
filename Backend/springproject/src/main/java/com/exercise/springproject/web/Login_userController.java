package com.exercise.springproject.web;

import com.exercise.springproject.domain.Login_user;
import com.exercise.springproject.service.Login_userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

@Controller
@RestController
@RequestMapping("/login_user")
public class Login_userController {

    @Autowired
    private Login_userService login_userService;
    @GetMapping("/recordLogin_user")
    public List<Login_user> findAll(){
        //tested
        return login_userService.findAll();
    }
    @PostMapping("/recordLogin_user")
    public Login_user user_login(Login_user login_user){
        return login_userService.save(login_user);
    }

    @PutMapping("/recordLogin_user")
    public Login_user update(@RequestParam int id,
                              @RequestParam int time){
        Login_user login_user = new Login_user();
        login_user.setId(id);
        login_user.setTime(time);

        return login_userService.save(login_user);
    }

    @DeleteMapping("recordLogin_user/{id}")
    public void user_logout(@PathVariable int id){
        login_userService.deleteLogin_userById(id);
    }


    @PostMapping("findLogin_user")
    public Login_user findLogin_userById(@RequestParam int id){
        return login_userService.findLogin_userById(id);
    }

    public boolean check_timeout(int id){
        Login_user user = login_userService.findLogin_userById(id);
        Calendar cal = Calendar.getInstance();
        int time = (Calendar.YEAR-2000)*100000000;
        time += Calendar.MONTH*1000000;
        time += Calendar.DATE*10000;
        time += Calendar.HOUR_OF_DAY*100;
        time += Calendar.MINUTE;
        if(time-user.getTime()<=10){
            return true;
        }
        else if(time-user.getTime()>50){
            return false;
        }
        else{
            if((Calendar.HOUR_OF_DAY-user.getTime()/100)==1){
                return true;
            }
            else{
                return false;
            }
        }
    }

}
