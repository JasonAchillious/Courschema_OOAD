package com.exercise.springproject.web;

import com.exercise.springproject.domain.Department;
import com.exercise.springproject.domain.Major;
import com.exercise.springproject.service.DepartmentService;
import com.exercise.springproject.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private MajorService majorService;

    @GetMapping("/recordDepartment")
    public List<Department> findAllDepartment(){
        return departmentService.findAll();
    }

    @PostMapping("/recordDepartment")
    public Department addOne(Department department){
        return departmentService.save(department);
    }

    @PutMapping("/recordDepartment")
    public Department update(@RequestParam int idDepartment,
                        @RequestParam String chineseName,
                        @RequestParam String code){
        Department department = new Department();
        department.setChineseName(chineseName);
        department.setCode(code);
        department.setIdDepartment(idDepartment);
        return departmentService.save(department);
    }

    @PostMapping("/findAllDepartmentAndMajor")
    @ResponseBody List<Map> findAllInfo(){

        List<Department> de = departmentService.findAll();
        List<Map> reply = new ArrayList<>();
        for(Department d: de){
            Map<String, Object> tmp = new HashMap<>();
            tmp.put("name", d.getChineseName());
            Map<String, Object> majors = new HashMap<>();
            List<Major> m = majorService.findMajorByDepartment(d.getIdDepartment());
            List<String> major = new ArrayList<>();
            for(Major ma: m){
                major.add(ma.getChineseName());
            }
            tmp.put("majors", major);
            reply.add(tmp);
        }
        return reply;

    }

    @PostMapping("findDepartmentById")
    public Department findDepartmentById(@RequestParam int id){
        System.out.println(id);
        return departmentService.findDepartmentById(id);
    }

    @PostMapping("findDepartmentByCode")
    public Department findDepartmentByCode(@RequestParam String code){
        return departmentService.findDepartmentByCode(code);
    }

    @PostMapping("findMajorByName")
    public Department findDepartmentByName(@RequestParam String chineseName){
        return departmentService.findDepartmentByName(chineseName);
    }
}
