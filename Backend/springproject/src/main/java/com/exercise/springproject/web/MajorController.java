package com.exercise.springproject.web;

import com.exercise.springproject.domain.Major;
import com.exercise.springproject.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RestController
@RequestMapping("/major")
public class MajorController {

    @Autowired
    private MajorService majorService;

    @GetMapping("/recordMajor")
    public List<Major> findAllMajor(){
        return majorService.findAll();
    }

    @PostMapping("/recordMajor")
    public Major addOne(Major major){
        return majorService.save(major);
    }

    @PutMapping("/recordMajor")
    public Major update(@RequestParam int id,
                              @RequestParam int idDepartment,
                        @RequestParam String chineseName,
                        @RequestParam String englishName){
        Major major = new Major();
        major.setIdMajor(id);
        major.setChineseName(chineseName);
        major.setDepartment(idDepartment);
        major.setEnglishName(englishName);

        return majorService.save(major);
    }

    @PostMapping("findMajorById")
    public Major findMajorById(@RequestParam int id){
        return majorService.findMajorById(id);
    }

    @PostMapping("findMajorByDepartment")
    public List<Major> findMajorByDepartment(@RequestParam int id){
        return majorService.findMajorByDepartment(id);
    }

    @PostMapping("findMajorByCname")
    public Major findMajorByCname(@RequestParam String chineseName){
        return majorService.findMajorByCname(chineseName);
    }

    @PostMapping("findMajorByEname")
    public Major findMajorByEname(@RequestParam String englishName){
        return majorService.findMajorByEname(englishName);
    }

}
