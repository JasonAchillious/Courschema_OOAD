package com.exercise.springproject.web;

import com.exercise.springproject.domain.Carowner;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.exercise.springproject.domain.student;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.*;

@Controller
public class send_data {
    @RequestMapping("/test111")
    @ResponseBody
    public List<student> getStudents() {
        List<student> stus = new ArrayList<>();
        stus.add(new student(10, "send", 1, 3, "2"));
        return stus;
    }


    @RequestMapping(value = "/queryAllCarowners")
    public void query(HttpServletResponse resp) {
        try {
            /*list集合中存放的是好多student对象*/
            List<Carowner> students = new ArrayList<>();
            students.add(new Carowner("test","dfff", 3));
            /*将list集合装换成json对象*/
            JSONArray json = new JSONArray();
            for(Carowner a : students){
                JSONObject jo = new JSONObject();
                jo.put("name", a.getName());
                jo.put("cars", a.getCars());
                jo.put("obj", a.getObj());
                json.put(jo);
            }
            JSONArray data = json;
            //接下来发送数据
            /*设置编码，防止出现乱码问题*/
            resp.setCharacterEncoding("utf-8");
            /*得到输出流*/
            PrintWriter respWritter = resp.getWriter();
            /*将JSON格式的对象toString()后发送*/
            respWritter.append(data.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}