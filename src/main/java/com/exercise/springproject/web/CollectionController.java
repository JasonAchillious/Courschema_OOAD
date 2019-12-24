package com.exercise.springproject.web;

import com.exercise.springproject.domain.collections;
import com.exercise.springproject.domain.courschemas;
import com.exercise.springproject.service.CollectionsService;
import com.exercise.springproject.service.CourschemasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@Controller
@RestController
@RequestMapping("/exex")
public class CollectionController {

    @Autowired
    private CollectionsService collectionsService;
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

    @DeleteMapping("recordCollections/{id}")
    public void deleteOneCollection(@PathVariable int id, int courschema){
        collectionsService.deleteCollectionsById(id, courschema);
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
