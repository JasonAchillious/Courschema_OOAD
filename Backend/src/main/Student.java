<<<<<<< HEAD
package entities;

public class Student {
    private int idStudent;
    private String course_completed;
    private String Name;
    private int department;
    private int Major;
    private int BeginYear;


    public int getidStudent() {
        return idStudent;
    }

    public String getCourse_completed() {
        return course_completed;
    }

    public void setCourse_completed(String course_completed) {
        this.course_completed = course_completed;
    }

    public String getName() {
        return Name;
    }

    public void setName(String CourseName) {
        this.Name = CourseName;
    }

    public int getDepartment() {
        return department;
    }

    public int getMajor() {
        return Major;
    }

    public void setMajor(int Major) {
        this.Major = Major;
    }

    public int getBeginYear() {
        return BeginYear;
    }

    public void setBeginYear(int BeginYear) {
        this.BeginYear = BeginYear;
    }

    public Student(int idStudent, String Name, int department, int Major, String course_completed, int BeginYear) {
        this.idStudent = idStudent;
        this.course_completed = course_completed;
        this.Name = Name;
        this.department = department;
        this.Major = Major;
        this.BeginYear = BeginYear;
    }
}
=======
package entities;

public class Student {
    private int idStudent;
    private String course_completed;
    private String Name;
    private int department;
    private int Major;
    private int BeginYear;


    public int getidStudent() {
        return idStudent;
    }

    public String getCourse_completed() {
        return course_completed;
    }

    public void setCourse_completed(String course_completed) {
        this.course_completed = course_completed;
    }

    public String getName() {
        return Name;
    }

    public void setName(String CourseName) {
        this.Name = CourseName;
    }

    public int getDepartment() {
        return department;
    }

    public int getMajor() {
        return Major;
    }

    public void setMajor(int Major) {
        this.Major = Major;
    }

    public int getBeginYear() {
        return BeginYear;
    }

    public void setBeginYear(int BeginYear) {
        this.BeginYear = BeginYear;
    }

    public Student(int idStudent, String Name, int department, int Major, String course_completed, int BeginYear) {
        this.idStudent = idStudent;
        this.course_completed = course_completed;
        this.Name = Name;
        this.department = department;
        this.Major = Major;
        this.BeginYear = BeginYear;
    }
}
>>>>>>> 75f7218693f88b50daead236b4d6336ae84f46b7
