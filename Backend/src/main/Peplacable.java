package entities;

public class Replacable{
    private int idPreCourse;
    private String alternative;

    public int getIdPreCourse() {
        return idPreCourse;
    }

    public void setIdPreCourse(int IdPreCourse) {
        this.idPreCourse = idPreCourse;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    public Replacable(int idPreCourse, String alternative){
        this.idPreCourse = idPreCourse;
        this.alternative = alternative;
    }

}