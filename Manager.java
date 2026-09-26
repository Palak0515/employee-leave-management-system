package leaveManagement;
public class Manager {
    private int manager_Id;
    private String Email;
    private String name;
    
    public Manager(String Email, String name){
        this.Email = Email;
        this.name = name;
    }
    
    public int getManagerid(){ return manager_Id; }
    public String getEmail(){ return Email; }
    public String getName(){ return name; }
    
    public void setManagerid(int manager_Id){ this.manager_Id = manager_Id; }
    public void setEmail(String Email){ this.Email = Email; }
    public void setName(String name){ this.name = name; }
}
