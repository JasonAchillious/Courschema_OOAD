package entities;

public class Course {
    private int idCourse;
    private String Code;
    private String CourseName;
    private int department;
    private int suggest_semester;
    private String prerequisite;
    private float credit;


    public int getidCourse() {
        return idCourse;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSuggest_semester() {
        return suggest_semester;
    }

    public void setSuggest_semester(int suggest_semester) {
        this.suggest_semester = suggest_semester;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(String prerequisite) {
        this.prerequisite = prerequisite;
    }

    public float getCredit() {
        return credit;
    }

    public void setCredit(float credit) {
        this.credit = credit;
    }

    public Course(int idCourse, String Code, String CourseName, int department, int suggest_semester, String prerequisite, float credit) {
        this.idCourse = idCourse;
        this.Code = Code;
        this.CourseName = CourseName;
        this.department = department;
        this.suggest_semester = suggest_semester;
        this.prerequisite = prerequisite;
        this.credit = credit;
    }
}
