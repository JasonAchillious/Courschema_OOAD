package com.exercise.springproject.web;

import com.exercise.springproject.domain.*;
import com.exercise.springproject.service.*;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

@Controller
@RestController
public class CourschemasController {
    @Autowired
    private CourschemasService courschemasService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private ClassificationService classificationService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private MajorService majorService;



    @GetMapping("/recordCourschemas")
    public List<courschemas> findAllCourschemas(){
        return courschemasService.findAll();
    }

    @PostMapping(value = "allschema")
    @ResponseBody
    public List<Map>  allschema(){
         List<courschemas>  search = courschemasService.findAll();
         List<Map> reply = new LinkedList<>();
         for(courschemas now: search) {
             Map<String, Object> tmp = new HashMap<String, Object>();
             tmp.put("Foreign", now.getWaiGuo());
             tmp.put("one_plus3", now.getOne_plus3());
             tmp.put("major_elec_alt", now.getMajor_elec_alt());
//             tmp.put("altered_course1", now.getAltered_course1());
//             tmp.put("altered_course2", now.getAltered_course2());
             tmp.put("coursechema", now.getCourschema());
             int m = now.getMajor();
             Major major = majorService.findMajorById(m);
             tmp.put("Major", major.getChineseName());
             tmp.put("year", now.getNian());
             Department department = departmentService.findDepartmentById(now.getDepartment());
             tmp.put("Department", department.getChineseName());
             tmp.put("major_elec", now.getMajor_elec());
             tmp.put("HU_elec", now.getHU_elec());
             tmp.put("SS_elec", now.getSS_elec());
             tmp.put("AR_elec", now.getAR_elec());
             tmp.put("political", now.getPolitical());
             tmp.put("ChineseName", now.getChineseName());
             reply.add(tmp);
         }
        return reply;
    }

    @PostMapping(value = "schemabyMajor")
    @ResponseBody
    public List<courschemas> schemabyMajor(@RequestBody Integer majorId){
        return courschemasService.findcourschemasBymajor(majorId);
    }

    @PostMapping(value = "schemabyMajorAndYear")
    @ResponseBody
    public List<courschemas> schemabyMajorAndYear(@RequestBody Integer majorId,
                                                  @RequestBody Integer year){
        List<courschemas> first = courschemasService.findcourschemasBymajor(majorId);
        List<courschemas> ans = null;
        for(courschemas now:first){
            if(now.getNian()==year){
                ans.add(now);
            }
        }
        return ans;
    }

    @GetMapping("/allCourschemas")
    public List<Object> findCourschemasName(){
        List<Object> result = new ArrayList<Object>();
        List<courschemas> all = courschemasService.findAll();
        for(int i = 0;i < all.size();i ++) {
            Map<String,Object> ele = new HashMap<>();
            courschemas c = all.get(i);
            ele.put("chineseName",c.getChineseName());
            int dep_id = c.getDepartment();
            System.out.println(dep_id);
            Department d = departmentService.findDepartmentById(dep_id);
            ele.put("department",d.getChineseName());
            ele.put("courschema",c.getCourschema());

            result.add(ele);
        }

        return result;
    }


//    @PostMapping("/recordCourschemas")
//    public courschemas addOne(courschemas courschemas){
//        System.out.print(courschemas);
//        return courschemasService.save(courschemas);
//    }

    @PutMapping("/recordCourschemas")
    public courschemas update(//@RequestParam int courschema,
                              @RequestParam int Foreign,
                              @RequestParam int one_plus3,
                              @RequestParam int major_elec_art,
//                              @RequestParam int altered_course1,
//                              @RequestParam int altered_course2,
                              @RequestParam int Major,
                              @RequestParam int Year,
                              @RequestParam int Department,
                              @RequestParam int major_elec,
                              @RequestParam int HU_elec,
                              @RequestParam int SS_elec,
                              @RequestParam int AR_elec,
                              @RequestParam int political,
                              @RequestParam String ChineseName){
        courschemas courschemas = new courschemas();
     //   courschemas.setCourschema(courschema);
//        courschemas.setAltered_course1(altered_course1);
//        courschemas.setAltered_course2(altered_course2);
        courschemas.setAR_elec(AR_elec);
        courschemas.setChineseName(ChineseName);
        courschemas.setDepartment(Department);
        courschemas.setWaiGuo(Foreign);
        courschemas.setHU_elec(HU_elec);
        courschemas.setMajor(Major);
        courschemas.setMajor_elec(major_elec);
        courschemas.setMajor_elec_alt(major_elec_art);
        courschemas.setOne_plus3(one_plus3);
        courschemas.setPolitical(political);
        courschemas.setSS_elec(SS_elec);
        courschemas.setNian(Year);
        return courschemasService.save(courschemas);
    }

//    @PostMapping("/saveCourschemas")
//    public courschemas addOne(courschemas courschemas){
//        return courschemasService.save(courschemas);
//    }

    @PostMapping(value="/saveCou")
    @ResponseBody
    public courschemas saveSchema(@RequestBody Map<String, Object> map){
        courschemas c = new courschemas();
        System.out.println(c);
        System.out.println(c.getCourschema());
        System.out.println(map.get("department"));
        System.out.println(map.get("AR_elec"));
        System.out.println(map.get("schema_name"));
        System.out.println(map.get("major_elec"));
        System.out.println(map.get("HU_elec"));
        System.out.println(map.get("foreign"));
        System.out.println(map.get("major"));
        System.out.println(map.get("one_plus3"));

        c.setAR_elec((int)map.get("AR_elec"));
        c.setChineseName((String) map.get("schema_name"));
        //String depart = (String) map.get("department");
        String depart = "计算机科学与工程系";
        c.setDepartment(departmentService.findDepartmentByName(depart).getIdDepartment());
        c.setWaiGuo((int) map.get("foreign"));
        c.setHU_elec((int)map.get("HU_elec"));
        //String major = (String) map.get("major");
        String major = "计算机科学与技术";
        c.setMajor(majorService.findMajorByCname(major).getIdMajor());
        c.setMajor_elec((int)map.get("major_elec"));
        c.setOne_plus3((int)map.get("one_plus3"));
        c.setSS_elec((int)map.get("SS_elec"));
        c.setNian((int)map.get("y"));
        c.setIntro((String)map.get("intro"));

        return courschemasService.save(c);
        //return reply;
    }



    @DeleteMapping("recordCourschemas/{courschema}")
    public void deleteCourschema(@PathVariable int courschema){
        courschemasService.deleteCourschema(courschema);
    }

    @PostMapping("findCourschemaId")
    public courschemas findCourschema(@RequestParam int courschema){
        return courschemasService.findCourschema(courschema);
    }

    @PostMapping("findCourschemaName")
    public courschemas findCourschemaName(@RequestParam String chinese_name){
        return courschemasService.findCourschemaName(chinese_name);
    }

    @PostMapping("downloadCourschemas")
    public void downloadCourschema(@RequestParam String chinese_name, String path) throws IOException {
        courschemas courschema = courschemasService.findCourschemaName(chinese_name);
        int idCourschema = courschema.getCourschema();
        File filewrite=new File(path);
        filewrite.createNewFile();
        OutputStream os=new FileOutputStream(filewrite);
        writeExcel(os, courschema, idCourschema);

    }

    public void writeExcel(OutputStream os, courschemas courschema, int idCourschema)
    {
        try
        {
            WritableWorkbook wwb = Workbook.createWorkbook(os);

            WritableSheet ws = wwb.createSheet("Test Sheet 1",0);
            int year = 1;
            String semester = "autumn";
            String time = "";
            Course course;


            Label label = new Label(0,0,courschema.getChineseName());
            ws.addCell(label);
            label = new Label(0,1, "院系");
            ws.addCell(label);
            label = new Label(1,1, String.valueOf(courschema.getDepartment()));
            ws.addCell(label);
            label = new Label(0,2, "专业");
            ws.addCell(label);
            label = new Label(1,2, String.valueOf(courschema.getMajor()));
            ws.addCell(label);
            label = new Label(0,1, String.valueOf(courschema.getDepartment()));
            ws.addCell(label);

            label = new Label(0,3, "通识理工基础课");
            ws.addCell(label);
            label = new Label(0,4, "Chinese Name");
            ws.addCell(label);
            label = new Label(1,4, "English Name");
            ws.addCell(label);
            label = new Label(2,4, "Code");
            ws.addCell(label);
            label = new Label(3,4, "Credit");
            ws.addCell(label);
            label = new Label(4,4, "Suggested Time");
            ws.addCell(label);
            List<Integer> idCourses = this.classificationService.findTypeTonCourse(idCourschema);
            //System.out.println(idCourses);
            List<Course> courses = new LinkedList<Course>();
            courses.clear();
            for(int id: idCourses){
                courses.add(courseService.findCourseById(id));
            }
            int len1 = courses.size();
            //System.out.println(courses);
            //System.out.println("len1: "+len1);
            for(int i=0; i<len1; i++){
                course = courses.get(i);
                label = new Label(0,5+i, course.getChineseName());
                ws.addCell(label);
                //System.out.println(course.getChineseName());

                label = new Label(1,5+i, course.getEnglishName());
                ws.addCell(label);
                label = new Label(2,5+i, course.getCode());
                ws.addCell(label);
                label = new Label(3,5+i, String.valueOf(course.getCredit()));
                ws.addCell(label);
                year = course.getYear();
                if(course.getAutumn()==1){
                    time = "year " + year + " autumn";
                    if(course.getSpring()==1){
                        time += " &spring";
                    }
                    if(course.getSummer()==1){
                        time += " &summer";
                    }
                }
                else if(course.getSpring()==1){
                    time = "year " + year + " spring";
                    if(course.getAutumn()==1){
                        time += " &autumn";
                    }
                    if(course.getSummer()==1){
                        time += " &summer";
                    }
                }
                else if(course.getSummer()==1){
                    time = "year " + year + " summer";
                    if(course.getSpring()==1){
                        time += " &spring";
                    }
                    if(course.getAutumn()==1){
                        time += " &autumn";
                    }
                }
                else{
                    time = "year " + year;
                }
                label = new Label(4,5+i, time);
                ws.addCell(label);


            }
            label = new Label(0,6+len1, "专业先修课");
            //System.out.println("1st: "+String.valueOf(4+len1));
            ws.addCell(label);
            label = new Label(0,7+len1, "Chinese Name");
            ws.addCell(label);
            label = new Label(1,7+len1, "English Name");
            ws.addCell(label);
            label = new Label(2,7+len1, "Code");
            ws.addCell(label);
            label = new Label(3,7+len1, "Credit");
            ws.addCell(label);
            label = new Label(4,7+len1, "Suggested Time");
            ws.addCell(label);
            idCourses = this.classificationService.findTypeRuxiCourse(idCourschema);
            courses.clear();
            for(int id: idCourses){
                courses.add(courseService.findCourseById(id));
            }
            int len2 = courses.size();
            //System.out.println("len2: "+len2);
            for(int i=0; i<len2; i++){
                course = courses.get(i);
                label = new Label(0,8+len1+i, course.getChineseName());
                ws.addCell(label);
                //System.out.println(course.getChineseName());

                label = new Label(1,8+len1+i, course.getEnglishName());
                ws.addCell(label);
                label = new Label(2,8+len1+i, course.getCode());
                ws.addCell(label);
                label = new Label(3,8+len1+i, String.valueOf(course.getCredit()));
                ws.addCell(label);
                year = course.getYear();
                if(course.getAutumn()==1){
                    time = "year " + year + " autumn";
                    if(course.getSpring()==1){
                        time += " &spring";
                    }
                    if(course.getSummer()==1){
                        time += " &summer";
                    }
                }
                else if(course.getSpring()==1){
                    time = "year " + year + " spring";
                    if(course.getAutumn()==1){
                        time += " &autumn";
                    }
                    if(course.getSummer()==1){
                        time += " &summer";
                    }
                }
                else if(course.getSummer()==1){
                    time = "year " + year + " summer";
                    if(course.getSpring()==1){
                        time += " &spring";
                    }
                    if(course.getAutumn()==1){
                        time += " &autumn";
                    }
                }
                else{
                    time = "year " + year;
                }
                label = new Label(4,8+len1+i, time);
                ws.addCell(label);


            }
            label = new Label(0,9+len1+len2, "专业核心课");
            //System.out.println("2st: "+String.valueOf(5+len1+len2));
            ws.addCell(label);
            label = new Label(0,10+len1+len2, "Chinese Name");
            ws.addCell(label);
            label = new Label(1,10+len1+len2, "English Name");
            ws.addCell(label);
            label = new Label(2,10+len1+len2, "Code");
            ws.addCell(label);
            label = new Label(3,10+len1+len2, "Credit");
            ws.addCell(label);
            label = new Label(4,10+len1+len2, "Suggested Time");
            ws.addCell(label);
            idCourses = this.classificationService.findTypeComCourse(idCourschema);
            courses.clear();
            for(int id: idCourses){
                courses.add(courseService.findCourseById(id));
            }
            int len3 = courses.size();
            //System.out.println("len3: "+len3);
            for(int i=0; i<len3; i++){
                course = courses.get(i);
                label = new Label(0,11+len1+len2+i, course.getChineseName());
                ws.addCell(label);
                //System.out.println(course.getChineseName());

                label = new Label(1,11+len1+len2+i, course.getEnglishName());
                ws.addCell(label);
                label = new Label(2,11+len1+len2+i, course.getCode());
                ws.addCell(label);
                label = new Label(3,11+len1+len2+i, String.valueOf(course.getCredit()));
                ws.addCell(label);
                year = course.getYear();
                if(course.getAutumn()==1){
                    time = "year " + year + " autumn";
                    if(course.getSpring()==1){
                        time += " &spring";
                    }
                    if(course.getSummer()==1){
                        time += " &summer";
                    }
                }
                else if(course.getSpring()==1){
                    time = "year " + year + " spring";
                    if(course.getAutumn()==1){
                        time += " &autumn";
                    }
                    if(course.getSummer()==1){
                        time += " &summer";
                    }
                }
                else if(course.getSummer()==1){
                    time = "year " + year + " summer";
                    if(course.getSpring()==1){
                        time += " &spring";
                    }
                    if(course.getAutumn()==1){
                        time += " &autumn";
                    }
                }
                else{
                    time = "year " + year;
                }
                label = new Label(4,11+len1+len2+i, time);
                ws.addCell(label);


            }
            //System.out.println("3st: "+String.valueOf(5+len1+len2+len3));

            wwb.write();
            wwb.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


}
