package leaveManagement;
public class Employee {
    private int employee_ID;
    private String name;
    private String EMail;
    private String department;
    private int manager_Id;
    
    public Employee(int employee_ID, String name, String EMail, String department, int manager_Id){
        this.employee_ID = employee_ID;
        this.name = name;
        this.EMail = EMail;
        this.department = department;
        this.manager_Id = manager_Id;
    }
    
    public Employee(String name, String EMail, String department, int manager_Id){
    this.name = name;
    this.EMail = EMail;
    this.department = department;
    this.manager_Id = manager_Id;
}
    
    public int getEmployeeid(){ return employee_ID; }
    public String getName(){ return name; }
    public String getEmail(){ return EMail; }
    public String getDepartment(){ return department; }
    public int getManagerid(){ return manager_Id; }
    
    public void setEmployeeid(int employee_ID){ this.employee_ID = employee_ID; }
    public void setName(String name){ this.name = name; }
    public void setEmail(String EMail){ this.EMail = EMail; }
    public void setDepartment(String department){ this.department = department; }
    public void setManagerid(int manager_Id){ this.manager_Id = manager_Id; }
}
