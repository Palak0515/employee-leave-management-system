package leaveManagement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class ManagerDAO {
    public static void addManager(Manager m){
        try{
            String sql = "Insert into manager(email,name) values(?,?)";
            try(Connection conn = databaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
                
                ps.setString(1,m.getEmail());
                ps.setString(2, m.getName());
                
                int rows = ps.executeUpdate();
                if(rows == 1){ System.out.println("Successful"); }
                else{ System.out.println("UnSuccessful"); }
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public static void viewPendingLeaves(){
        try{
            String sql = "select * from leave_request where leave_status = 'pending' ";
            try(Connection conn = databaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
                
                try(ResultSet rs = ps.executeQuery();){
                    boolean found = false;
                    while(rs.next()){
                        found = true;
                        int a = rs.getInt("leave_id");
                        int b = rs.getInt("emp_id");
                        String g = rs.getString("leave_status");
                        
                        System.out.println("Leave Id = " + a);
                        System.out.println("Employee Id = " + b);
                        System.out.println("Leave Status = " + g);
                    }
                    if(!found){
                        System.out.println("No pending leaves found.");
                    }
                }
            }
        }
        
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public static void findLeaveId(int leaveId){
        try{
            String sql = "Select * from leave_request where leave_id = ?";
                    try(Connection conn = databaseConnection.getConnection();
                        PreparedStatement ps = conn.prepareStatement(sql);){
                        
                        ps.setInt(1, leaveId);
                        try(ResultSet rs = ps.executeQuery();){
                            if(rs.next()){
                                System.out.println("Leave Id = " + rs.getInt("leave_id"));
                                System.out.println("Employee Id = " + rs.getInt("emp_id"));
                                System.out.println("Leave Type = " + rs.getString("leave_type"));
                                System.out.println("Start Date = " + rs.getDate("start_date"));
                                System.out.println("End Date = " + rs.getDate("end_date"));
                                System.out.println("Reason = " + rs.getString("reason"));
                                System.out.println("Leave Status = " + rs.getString("leave_status"));
                                System.out.println("Manager's Remark = " + rs.getString("remark"));
                            }
                            else{
                                System.out.println("Leave ID " + leaveId + " not found.");
                            }
                        }
                    }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public static void updateLeaveStatus(int leaveId, String status){
        try{
            String sql = "update leave_request set leave_status = ? where leave_id = ?";
            
            try(Connection conn = databaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
                
                ps.setString(1,status);
                ps.setInt(2, leaveId);
                
                int rows = ps.executeUpdate();
                if(rows == 1){ System.out.println("Successfully Updated"); }
                else{ System.out.println("Leave ID " + leaveId + " not found."); }
                
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public static void updateRemark( int leaveId,String remark){
        try{
            String sql = "update leave_request set remark = ? where leave_id = ?";
            
            try(Connection conn = databaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
                
                ps.setString(1, remark);
                ps.setInt(2, leaveId);
                
                int rows = ps.executeUpdate();
                if(rows == 1){ System.out.println("Successful"); }
                else{ System.out.println("Leave ID " + leaveId + " not found."); }
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
