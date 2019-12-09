package com.exercise.springproject.web;

import com.exercise.springproject.api.MajorRepository;
import com.exercise.springproject.api.SecretaryRepository;
import com.exercise.springproject.domain.Major;
import com.exercise.springproject.domain.secretary;
import com.exercise.springproject.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Controller
@RestController
public class SecretaryController {
    @Autowired
    private SecretaryRepository secretaryRepository;
    @Autowired
    private MajorRepository majorRepository;

    @PostMapping(value = "/showSeMajor")
    @ResponseBody
    public List<Major> handle(@RequestBody Integer secretaryID) {
        secretary now = secretaryRepository.findSecretaryById(secretaryID);
        int department = now.getDepartment();
        List<Major> ans = majorRepository.findMajorByDepartment(department);
//        List<String> answer = null;
//        for(Major n:ans){
//            answer.add(n.getEnglishName());
//        }
        return ans;
    }


}
