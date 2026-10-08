package leaveManagement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
public class Main {
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws SQLException{
        System.out.println("EMPLOYEE LEAVE MANAGEMENT SYSTEM");
        while(true){
            showMainMenu();
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    managerMenu();
                    break;   
                case 2:
                    employeeMenu();
                    break;   
                case 3:
                    return;
                default:
                    System.out.println("invalid");
            }
        }
    }
    
    static void showMainMenu(){
        System.out.println();
        System.out.println("1. Manager");
        System.out.println("2. Employee");
        System.out.println("3. Exit");
        System.out.println();
        System.out.print("Choice = ");
    }
    
    static void managerMenu(){
        while(true){
            System.out.println();
            System.out.println("MANAGER DETAILS");
           System.out.println("1. Add Manager");
           System.out.println("2. View Pending Leaves");
           System.out.println("3. Find Leave by Id");
           System.out.println("4. Update Leave Status");
           System.out.println("5. Update Leave Remark");
           System.out.println("6. Back");
           System.out.println("7. Exit");
           System.out.println();
           System.out.print("Choice = ");
           
           
            int choi = sc.nextInt(); sc.nextLine();
            switch(choi){
                case 1:
                    
                    System.out.print("Email = ");
                    String c = sc.nextLine();
 
                    System.out.print("Name = ");
                    String b = sc.nextLine();

                    Manager m = new Manager(c,b);
                    ManagerDAO.addManager(m);
                    break;
                    
                case 2:
                    ManagerDAO.viewPendingLeaves();
                    break;
                    
                case 3:
                    System.out.print("Enter Leave Id = ");
                    int leaveId_1 = sc.nextInt();
                    ManagerDAO.findLeaveId(leaveId_1);
                    break;
                    
                case 4:
                    System.out.print("Enter Leave Id = ");
                    int leaveId_2 = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter status = ");
                    String status = sc.nextLine();
                    ManagerDAO.updateLeaveStatus(leaveId_2,status);
                    break;
                    
                case 5:
                    System.out.print("Enter leave Id = ");
                    int leaveId_3 = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Remark = ");
                    String remark = sc.nextLine();
                    ManagerDAO.updateRemark(leaveId_3,remark);
                    break;
                    
                case 6:
                    return;
                    
                case 7:
                    System.exit(0);
                default:
                    System.out.print("Invalid Choice"); 
            }
        }
    }
    static void employeeMenu() throws SQLException{
        while(true){ 
            System.out.println();
            System.out.println("EMPLOYEE DETAILS");
            System.out.println("1. Add Employee");
            System.out.println("2. Find Employee by ID");
            System.out.println("3. Add Leave");
            System.out.println("4. Check Leave History");
            System.out.println("5. Back");
            System.out.println("6. Exit");
            System.out.println();
            System.out.print("Choice = ");
            
             int choic = sc.nextInt(); sc.nextLine();
        switch(choic){
            case 1:
                System.out.println("enter employee details");
                
                    System.out.print("Name = ");
                    String b = sc.nextLine();
                     System.out.print("Email = ");
                    String c =  sc.nextLine();
                     System.out.print("Department = ");
                    String d =  sc.nextLine();
                     System.out.print("Manager Id = ");
                    int f =  sc.nextInt(); sc.nextLine();
                    
                    Employee e = new Employee(b,c,d,f);
                            
                EmployeeDAO.addEmployee(e);
                break;
                
            case 2:
                System.out.print("enter employee_ID = ");
                int empId = sc.nextInt(); sc.nextLine();
                Employee em = EmployeeDAO.findEmployeeById(empId);
                if(em != null){
                    System.out.println("Employee ID: " + em.getEmployeeid());
                    System.out.println("Name: " + em.getName());
                    System.out.println("Email: " + em.getEmail());
                    System.out.println("Department: " + em.getDepartment());
                    System.out.println("Manager ID: " + em.getManagerid());
                } 
                else{
                    System.out.println("Employee not found");
                }
                break;
                
            case 3:
                System.out.println("enter leave details");

                     System.out.print("Employee Id = ");
                    int y = sc.nextInt(); sc.nextLine(); 
                     System.out.print("Leave Type = ");
                    String z = sc.nextLine(); 
                     System.out.print("Start Date = ");
                    String input1 = sc.next();  LocalDate u = LocalDate.parse(input1);
                     System.out.print("End Date = ");
                    String input2 = sc.next();  LocalDate v = LocalDate.parse(input2); 
                    sc.nextLine();
                     System.out.print("Reason = ");
                    String g = sc.nextLine();
                    
                    LeaveRequest lr = new LeaveRequest(y,z,u,v,g);

                LeaveDAO.addLeave(lr);
                break;
                
            case 4:
                System.out.println("enter employee_ID = ");
                int employee_ID =  sc.nextInt();
                LeaveDAO.leaveHistory(employee_ID);
                break;
                
            case 5:
                return;
                
            case 6:
                System.exit(0);
            default:
                System.out.println("Invalid Choice");
            }
        }
    }
}