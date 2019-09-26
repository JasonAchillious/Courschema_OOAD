package entities;

public class Admin{
    private int idAdmin;
    private String Name;
    private int Department;

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getDepartment() {
        return Department;
    }

    public void setDepartment(int Department) {
        this.Department = Department;
    }

    public Admin(int idAdmin, String Name, int Department){
        this.idAdmin = idAdmin;
        this.Name = Name;
        this.Department = Department;
    }
}