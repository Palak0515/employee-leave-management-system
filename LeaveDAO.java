package leaveManagement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class LeaveDAO {
    public static void addLeave(LeaveRequest lr){
        try{
            String sql = "insert into leave_request(emp_id, leave_type, start_date, end_date, reason) values(?,?,?,?,?)";
            try(Connection conn = databaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)){
                
                ps.setInt(1,lr.getEmpId());
                ps.setString(2, lr.getLeaveType());
                ps.setObject(3,lr.getStartDate());
                ps.setObject(4, lr.getEndDate());
                ps.setString(5, lr.getReason());
                
                int rows = ps.executeUpdate();
                if(rows == 1){ System.out.println("successful"); }
                else{ System.out.println("not added"); }
                
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public static void leaveHistory(int employee_ID){
        try{
            String sql = "Select * from leave_request where emp_id = ?";
            try(Connection conn = databaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
                
                ps.setInt(1,employee_ID);
                try(ResultSet rs = ps.executeQuery();){
                    if(rs.next()){
                        do{
                                System.out.println("Leave Id = " + rs.getInt("leave_id"));
                                System.out.println("Employee Id = " + rs.getInt("emp_id"));
                                System.out.println("Leave Type = " + rs.getString("leave_type"));
                                System.out.println("Start Date = " + rs.getDate("start_date"));
                                System.out.println("End Date = " + rs.getDate("end_date"));
                                System.out.println("Reason = " + rs.getString("reason"));
                                System.out.println("Leave Status = " + rs.getString("leave_status"));
                                System.out.println("Manager's Remark = " + rs.getString("remark"));
                       }while(rs.next());
                    }
                    else{
                        System.out.println("No Leave history found for this employee");
                    }
                } 
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}