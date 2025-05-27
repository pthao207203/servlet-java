package crm.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Subject {
    private int id;                        
    private int roomId;                    
    private String subjectName;           
    private int teacherId;               
    private LocalDateTime[] startTimes;   
    private int periodsPerDay;             
    private boolean weekPattern;          
    private LocalDate endDate;
    private List<Integer> studentIds;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public LocalDateTime[] getStartTimes() {
		return startTimes;
	}
	public void setStartTimes(LocalDateTime[] startTimes) {
		this.startTimes = startTimes;
	}
	public int getPeriodsPerDay() {
		return periodsPerDay;
	}
	public void setPeriodsPerDay(int periodsPerDay) {
		this.periodsPerDay = periodsPerDay;
	}
	public boolean isWeekPattern() {
		return weekPattern;
	}
	public void setWeekPattern(boolean weekPattern) {
		this.weekPattern = weekPattern;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public List<Integer> getStudentIds() {
		return studentIds;
	}
	public void setStudentIds(List<Integer> studentIds) {
		this.studentIds = studentIds;
	}      
}