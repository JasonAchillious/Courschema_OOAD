package entities;

public class Department{
    private int idDepartment;
    private String Name;

    public int getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Department(int idDepartment, String Name){
        this.idDepartment = idDepartment;
        this.Name = Name;
    }

}