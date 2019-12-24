package com.exercise.springproject.web;

import com.exercise.springproject.api.CourschemasRepository;
import com.exercise.springproject.domain.collections;
import com.exercise.springproject.domain.courschemas;
import com.exercise.springproject.service.CollectionsService;
import com.exercise.springproject.service.CourschemasService;
import com.exercise.springproject.service.DepartmentService;
import com.exercise.springproject.service.MajorService;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RestController
@RequestMapping("/exex")
public class CollectionController {

    @Autowired
    private CollectionsService collectionsService;

    @PostMapping("getCollect")
    @ResponseBody
    public List<Map> getCollections(@RequestBody Integer id){
        List<Map> reply = new ArrayList<Map>();
        List<Integer> temp = collectionsService.findCollectionsByid(id);
        for(int i : temp){
            Map<String, Object> now = new HashMap<>();
            courschemas n = courschemasService.findcourschemasById(i);
            now.put("name", n.getChineseName());
            now.put("intro", n.getIntro());
        }

        return reply;
    }


    @PostMapping("saveCollect")
    @ResponseBody
    public String saveCollections(@RequestBody Map json){
        int id = (int) json.get("id");
        ArrayList<Integer> list = (ArrayList<Integer>) json.get("list");
        System.out.println("gsdfethgd");
        System.out.println(id);
        System.out.println(list);
        collectionsService.deleteCollectionsById(id);
        System.out.println("HERE");
        for(Integer tmp: list){
            collections t = new collections();
            t.setId(id);
            t.setCourschema(tmp);
            System.out.println(t.getCourschema());
            System.out.println(t.getId());
            collectionsService.save(t);
        }
        return "success";
    }



    @GetMapping("/recordCollections")
    public List<collections> findAllCollections(){
        //tested
        return collectionsService.findAll();
    }
    @PostMapping("/recordCollections")
    public collections addOne(collections collections){
        return collectionsService.save(collections);
    }

    @PutMapping("/recordCollections")
    public collections update(@RequestParam int id,
                              @RequestParam int courschema){
        collections collections = new collections();
        collections.setId(id);
        collections.setCourschema(courschema);

        return collectionsService.save(collections);
    }

    @PostMapping("findCollections")
    public List<Integer> findCollectionsByid(@RequestParam int id){
        return collectionsService.findCollectionsByid(id);
    }

    @Autowired
    private CourschemasService courschemasService;

    public courschemas findCourschema(@RequestParam int courschema){
        return courschemasService.findCourschema(courschema);
    }

    @PostMapping("findCol_schema")
    public List<courschemas> findCol_schema(@RequestParam int id){
        List<Integer> schemas = findCollectionsByid(id);
        LinkedList<courschemas> schema_names = new LinkedList<courschemas>();
        for(int i:schemas){
            schema_names.add(findCourschema(i));
        }
        return schema_names;
    }

}
