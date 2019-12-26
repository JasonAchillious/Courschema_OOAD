package com.exercise.springproject.web;

import com.exercise.springproject.domain.*;
import com.exercise.springproject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.tags.Param;

import java.util.*;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private XianxiuService xianxiuService;
    @Autowired
    private GraduateService graduateService;
    @Autowired
    private ClassificationService classificationService;
    @Autowired
    private SecretaryService secretaryService;

    @GetMapping("/recordCourse")
    public List<Course> findAllCourse(){
        return courseService.findAll();
    }

    @PostMapping("/allcourse")
    @ResponseBody
    public List<Map> allcourse(){
        List<Course> tmp =  courseService.findAll();
        List<Map> reply = new LinkedList<>();
        for(Course now: tmp){
            Map<String, Object> temp = new HashMap<String,Object>();
            temp.put("chineseName",now.getChineseName());
            temp.put("idCourse", now.getIdCourse());
            temp.put("BianHao", now.getBianHao());
            temp.put("intro",now.getIntro());
            temp.put("credit", now.getCredit());
            temp.put("spring", now.getSpring());
            temp.put("autumn", now.getAutumn());
            temp.put("summer", now.getSummer());
            temp.put("englishName", now.getEnglishName());
            temp.put("year", now.getNian());
            temp.put("department", now.getDepartment_name());
            System.out.println(now.getDepartment_name());
            temp.put("xianxiu", now.getXianxiu());
            /*
            List<Xianxiu_condition> xianxiu = xianxiuService.findXianxiu_conditionByIdCourse(now.getIdCourse());
            if(xianxiu.size()>0){
                temp.put("xianxiu", xianxiu.get(0).getConditionString());
            }
            else{
                temp.put("xianxiu", "无");
            }

             */
//            graduate_condition gra = graduateService.findgraduate_conditionByIdCourse(now.getIdCourse()).get(0);
//            temp.put("tihuan", gra.getConditionString());
            reply.add(temp);
        }
        return reply;
    }

    @PostMapping("/onecourse")
    @ResponseBody
    public Map onecourse(@RequestBody Map json){
        int id = (int) json.get("id");
        Map<String, Object> temp = new HashMap<>();
        Course now = courseService.findCourseById(id);
            temp.put("chineseName",now.getChineseName());
            temp.put("idCourse", now.getIdCourse());
            temp.put("BianHao", now.getBianHao());
            temp.put("intro",now.getIntro());
            temp.put("credit", now.getCredit());
            temp.put("spring", now.getSpring());
            temp.put("autumn", now.getAutumn());
            temp.put("summer", now.getSummer());
            temp.put("englishName", now.getEnglishName());
            temp.put("year", now.getNian());
            temp.put("department", now.getDepartment_name());
            temp.put("xianxiu", now.getXianxiu());
            //List<Xianxiu_condition> xianxiu = xianxiuService.findXianxiu_conditionByIdCourse(now.getIdCourse());
            /*
            if(xianxiu.size()>0){
                temp.put("xianxiu", xianxiu.get(0).getConditionString());
            }
            else{
                temp.put("xianxiu", "无");
            }

             */

//            graduate_condition gra = graduateService.findgraduate_conditionByIdCourse(now.getIdCourse()).get(0);
//            temp.put("tihuan", gra.getConditionString());
        return temp;
    }

    @PostMapping("/newcourse")
    @ResponseBody
    public Map saveCourse(@RequestBody Map<String, Object> json_map){
            Course newcourse = new Course();
            newcourse.setChineseName((String) json_map.get("chinese_name"));
            System.out.println(json_map.get("code"));
            newcourse.setBianHao((String) json_map.get("code"));
            newcourse.setIntro((String) json_map.get("intro"));
            System.out.println(newcourse.getIntro());
            newcourse.setCredit((int) json_map.get("credit"));
            newcourse.setXianxiu((String) json_map.get("xianxiu"));
            boolean s = (boolean) json_map.get("summer");
            if(s)
                newcourse.setSummer((byte) 1);
            else
                newcourse.setSummer((byte) 0);
            boolean sp = (boolean) json_map.get("spring");
            if(sp)
                newcourse.setSpring((byte) 1);
            else
                newcourse.setSpring((byte)0);
            boolean a  = (boolean) json_map.get("autumn");
            if(a)
                newcourse.setAutumn((byte) 1);
            else
                newcourse.setAutumn((byte) 0);
            newcourse.setEnglishName((String) json_map.get("english_name"));
            String nian = (String) json_map.get("year");
            if(nian.equals("大一")){
                newcourse.setNian(1);
            }else if(nian.equals("大二")){
                newcourse.setNian(2);
            }else if(nian.equals("大三")){
                newcourse.setNian(3);
            }else{
                newcourse.setNian(4);
            }
            newcourse.setWeektime(0);
            newcourse.setExperiment(0);
            String depart = (String) json_map.get("department");
            System.out.println("depart");
            System.out.println(depart);
            Department de = departmentService.findDepartmentByName(depart);
            newcourse.setDepartment(de.getIdDepartment());
            newcourse.setDepartment_name(depart);
            Map<String, Object> reply = new HashMap<>();
            try{
                courseService.save(newcourse);
                reply.put("state","success");
                reply.put("course_id", newcourse.getIdCourse());
                System.out.println("newcourse.getIdCourse()");
                System.out.println(newcourse.getIdCourse());
            }catch(Exception e){
                reply.put("state", "fail");
            }
            return reply;
    }

    @PostMapping("/editcourse")
    @ResponseBody
    public Map editcourse(@RequestBody Map<String, Object> json_map){
        Map<String, Object> reply = new HashMap<>();
        int id = (Integer) json_map.get("course_id");
        int userid = (int) json_map.get("user_id");
        if(userid>29999999 && userid<40000000){
            secretary s = secretaryService.findSecretaryById(userid);
            int sde = s.getDepartment();
            Course c = courseService.findCourseById(id);
            int cde = c.getDepartment();
            if(sde!=cde){
                reply.put("state", "not match");
                return reply;
            }
        }
        Course search = courseService.findCourseById(id);
        int cre = (int) json_map.get("credit");
        System.out.println("shvdgfjh");
        System.out.println(json_map.get("summer"));
        int s = (int) json_map.get("summer");
        int sp = (int) json_map.get("spring");
        int au = (int) json_map.get("autumn");
        Byte summer, spring, autumn;
        if(s==1)
            summer = 1;
        else
            summer = 0;
        if(sp==1)
            spring = 1;
        else
            spring = 0;
        if(au==1)
            autumn = 1;
        else
            autumn = 0;
        double credit = (double) cre/1;

        if(search == null) {
            reply.put("state", "fail");
            return reply;
        }
        int n = 0;
        String nian = (String) json_map.get("year");
        switch (nian) {
            case "大一":
                n = 1;
                break;
            case "大二":
                n = 2;
                break;
            case "大三":
                n = 3;
                break;
            default:
                n = 4;
                break;
        }
        String depart = (String) json_map.get("department");
        Department de = departmentService.findDepartmentByName(depart);
        System.out.println("id"+id);
        System.out.println("id"+(String) json_map.get("chinese_name"));
        System.out.println("id"+(String) json_map.get("code"));
        System.out.println("id"+json_map.get("intro").toString());
        System.out.println("id"+credit);
        System.out.println("id"+summer);
        System.out.println("id"+spring);
        System.out.println("id"+autumn);
        System.out.println("id"+(String) json_map.get("xianxiu"));
        System.out.println("id"+(String)json_map.get("english_name"));
        System.out.println("id"+n);
        System.out.println("id"+depart);
        System.out.println("id"+de.getIdDepartment());

        courseService.editCourse(id, (String) json_map.get("chinese_name"),(String) json_map.get("code"),
                (String) json_map.get("intro"),
                credit, summer, spring, autumn, (String) json_map.get("xianxiu"), (String) json_map.get("english_name"),n, depart, de.getIdDepartment(), 0, 0);
        reply.put("state", "success");
        return reply;
    }

    @PostMapping("/deletecourse")
    @ResponseBody
    public Map deletecourse(@RequestBody Map<String, Object> json_map){
        int courseid = (int) json_map.get("course_id");
        int userid = (int) json_map.get("user_id");
        Map<String, Object> reply = new HashMap<>();
        if(userid>29999999 && userid<40000000){
            secretary s = secretaryService.findSecretaryById(userid);
            int sde = s.getDepartment();
            Course c = courseService.findCourseById(courseid);
            int cde = c.getDepartment();
            if(sde!=cde){
                reply.put("state", "not match");
                return reply;
            }
        }
        xianxiuService.deleteXianxiuConditionByCourseid(courseid);
        graduateService.deletegraduate_conditionByCourseid(courseid);
        classificationService.deleteClassificationByCourseid(courseid);
        courseService.deleteCourseById(courseid);

        reply.put("state", "success");
        return reply;
    }

    @PostMapping("editXianxiu")
    @ResponseBody
    public Map<String, Object> editXianxiu(@RequestBody Map<String, Object> json){
        int course_id = (int) json.get("course_id");
        String pre_course = (String) json.get("pre_course");
        String replace = (String) json.get("replace_course");
        int schema_id = (int) json.get("schema_id");
        try{
            xianxiuService.deleteXianxiuCondition(course_id, schema_id);
            graduateService.deletegraduate_condition(course_id, schema_id);
        }catch(Exception e){
            System.out.println(e);
        }
        Xianxiu_condition newxianxiu = new Xianxiu_condition();
        newxianxiu.setConditionString(pre_course);
        newxianxiu.setIdCourse(course_id);
        newxianxiu.setCourschema(schema_id);
        graduate_condition newgra = new graduate_condition();
        newgra.setIdCourse(course_id);
        newgra.setConditionString(replace);
        newgra.setCourschema(schema_id);
        Map<String, Object> reply = new HashMap<>();
        try {
            xianxiuService.save(newxianxiu);
            graduateService.save(newgra);
            reply.put("state", "success");
        }catch(Exception e){
            reply.put("state", "fail");
        }
        return reply;
    }

//    @PostMapping(value="/saveCourschemas")
//    @ResponseBody
//    public Course saveCourse(@RequestParam Map<String, Object> json){
//        Course course = new Course();
//        course.setAutumn((Byte) json.get("autumn"));
//        course.setChineseName((String) json.get("ChineseName"));
//        course.setCode((String)json.get("code"));
//        course.setCredit((Double) json.get("credit"));
//        course.setEnglishName((String)json.get("EnglighName"));
//        course.setIdCourse((int)json.get("idCourse"));
//        course.setIntro((String)json.get("intro"));
//        course.setYear((int)json.get("year"));
//        course.setSpring((Byte)json.get("spring"));
//        course.setSummer((Byte)json.get("summer"));
//        course.setDepartment((int)json.get("department"));
//        return courseService.save(course);
//    }

    @PostMapping("/recordClassification")
    public Course addOne(Course course){
        return courseService.save(course);
    }

    @PutMapping("/recordClassification")
    public Course update(@RequestParam int idCourse,
                                 @RequestParam int courschema,
                                 @RequestParam String code,
                                 @RequestParam String chineseName,
                         @RequestParam String intro,
                         @RequestParam double credit,
                         @RequestParam byte spring,
                         @RequestParam byte autumn,
                         @RequestParam byte summer,
                         @RequestParam String englishName,
                         @RequestParam int year){
        Course course = new Course();
      //
        course.setAutumn(autumn);
        course.setChineseName(chineseName);
        course.setBianHao(code);
        course.setCredit(credit);
        course.setEnglishName(englishName);
        course.setIntro(intro);
        course.setSpring(spring);
        course.setSummer(summer);
        course.setNian(year);

        return courseService.save(course);
    }

    @PostMapping("findCourse")
    public Course findCourseById(@RequestParam int idCourse){
        return courseService.findCourseById(idCourse);
    }

    @PostMapping("findCourseCname")
    public String findCourseCnameById(@RequestParam int idCourse){
        return courseService.findCourseById(idCourse).getChineseName();
    }

    @PostMapping("findCourseDepartment")
    public List<Course> findCourseDepartment(@RequestParam int idDepartment){
        return courseService.findCourseByDepartment(idDepartment);
    }


    @PostMapping("/coursebydepart")
    @ResponseBody
    public List<Course> coursebyDepart(@RequestBody Integer id){
        return courseService.findCourseByDepartment(id);
    }


    @PostMapping(value = "/show_course")
    @ResponseBody
    public Map handle(@RequestBody Integer courseID){
        Map <String,Object> reply = new HashMap<String,Object>();
        //Class t = json_map.get("id").getClass();
        // System.out.println(t.getName());
        Course ans = courseService.findCourseById(courseID);

        reply.put("courseID", courseID);
        reply.put("courseName", ans.getChineseName());
        reply.put("courseScore", ans.getCredit());
        //reply.put("experimentScore", ans.);
       // reply.put("weekLearningTime", ans.);
        reply.put("AdviceTerm:", ans.getNian());
        //reply.put("courseLang", ans.);
        String term = "";
        if(ans.getAutumn()==1){
            term.concat(" autumn");
        }
        if(ans.getSpring()==1){
            term.concat(" spring");
        }
        if(ans.getSummer()==1){
            term.concat(" spring");
        }
        reply.put("SetTerm", term);
        //reply.put("preCourse", s.getEnglishLevel());
        //reply.put("institute", );
        //reply.put("introduction",ans.getIntro());
        return reply;
    }

}
