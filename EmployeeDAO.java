package leaveManagement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class EmployeeDAO {
    public static void addEmployee(Employee e) throws SQLException{
        try{
            String sql = "Insert into employee(name, email, department, manager_id) values(?,?,?,?)";
                try( Connection conn = databaseConnection.getConnection();
                    PreparedStatement ps = conn.prepareStatement(sql); ){
                    
 
               ps.setString(1, e.getName());
               ps.setString(2, e.getEmail());
               ps.setString(3, e.getDepartment());
               ps.setInt(4, e.getManagerid());
            
               int rows = ps.executeUpdate();
               if(rows == 1){ System.out.println("Successful"); }
               else{ System.out.println("Unsuccessful"); }
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public static Employee findEmployeeById(int empId){
    try{
        String sql = "Select * from employee where emp_id = ?";

        try(Connection conn = databaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, empId);

            try(ResultSet rs = ps.executeQuery()) {

                if(rs.next()) {

                    int employee_ID = rs.getInt("emp_id");
                    String name = rs.getString("name");
                    String EMail = rs.getString("email");
                    String department = rs.getString("department");
                    int manager_Id = rs.getInt("manager_id");

                    Employee emp = new Employee(
                        employee_ID, name, EMail, department, manager_Id
                    );

                    return emp;
                }
                else {
                    return null;
                }
            }
        }
    }
    catch(SQLException ex){
        ex.printStackTrace();
    }
        return null;
    }
}