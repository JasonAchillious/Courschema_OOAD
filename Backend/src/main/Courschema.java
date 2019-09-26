package entities;

public class Courschema {
    private int Courschema;
    private int Year;
    private int Major;
    private int department;
    private float required_credits;
    private float optional_credits;


    public int getCourschema() {
        return Courschema;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(int Major) {
        this.Major = Major;
    }

    public int getDepartment() {
        return department;
    }

    public float getRequired_credits() {
        return required_credits;
    }

    public void setRequired_credits(float required_credits) {
        this.required_credits = required_credits;
    }

    public float getOptional_credits() {
        return optional_credits;
    }

    public void setOptional_credits(String optional_credits) {
        this.optional_credits = optional_credits;
    }

    public Courschema(int Courschema, int Year, int Major, int department, float required_credits, float optional_credits) {
        this.Courschema = Courschema;
        this.Year = Year;
        this.Major = Major;
        this.department = department;
        this.required_credits = required_credits;
        this.optional_credits = optional_credits;
    }
}
