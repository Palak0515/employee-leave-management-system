package leaveManagement;
import java.time.LocalDate;
public class LeaveRequest {
    private int leaveId;
    private int empId;
    private String leaveType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;
    private String leaveStatus;
    private String remark;
    
    public LeaveRequest(int empId, String leaveType, LocalDate startDate, LocalDate endDate, String reason){
//        this.leaveId = leaveId;
        this.empId = empId;
        this.leaveType = leaveType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
//        this.leaveStatus = leaveStatus;
//        this.remark = remark;
    }
    
    public int getLeaveId(){ return leaveId; }
    public int getEmpId(){ return empId; }
    public String getLeaveType(){ return leaveType; }
    public LocalDate getStartDate(){ return startDate; }
    public LocalDate getEndDate(){ return endDate; }
    public String getReason(){ return reason; }
    public String getLeaveStatus(){ return leaveStatus; }
    public String getRemark(){ return remark; }
    
    public void setLeaveId(int leaveId){ this.leaveId = leaveId; }
    public void setEmpId(int empId){ this.empId = empId; }
    public void setLeaveType(String leaveType){ this.leaveType = leaveType; }
    public void setStartDate(LocalDate startDate){ this.startDate = startDate; }
    public void setEndDate(LocalDate endDate){ this.endDate = endDate; }
    public void setReason(String reason){ this.reason = reason; }
    public void setLeaveStatus(String leaveStatus){ this.leaveStatus = leaveStatus; }
    public void setRemark(String remark){ this.remark = remark; }
}
