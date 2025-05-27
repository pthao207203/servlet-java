package crm.model;

import java.time.LocalDateTime;
import java.util.List;

public class CI_CO {
    
    private int id;                   
    private int studentId;            
    private int roomId;                 
    private List<LocalDateTime> checkinTime;  
    private List<LocalDateTime> checkoutTime; 
    private int status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public List<LocalDateTime> getCheckinTime() {
		return checkinTime;
	}
	public void setCheckinTime(List<LocalDateTime> checkinTime) {
		this.checkinTime = checkinTime;
	}
	public List<LocalDateTime> getCheckoutTime() {
		return checkoutTime;
	}
	public void setCheckoutTime(List<LocalDateTime> checkoutTime) {
		this.checkoutTime = checkoutTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
    
}
