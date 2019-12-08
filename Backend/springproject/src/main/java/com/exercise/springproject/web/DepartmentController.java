package com.exercise.springproject.web;

import com.exercise.springproject.domain.Department;
import com.exercise.springproject.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

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
