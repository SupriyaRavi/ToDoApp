package ToDoApp.Bean;

public class Task {

	public String TaskName;
	public String Date;
	public String Time;
	@Override
	public String toString() {
		return "AddTask [" + (TaskName != null ? "TaskName=" + TaskName + ", " : "")
				+ (Date != null ? "Date=" + Date + ", " : "") + (Time != null ? "Time=" + Time : "") + "]";
	}
	public String getTaskName() {
		return TaskName;
	}
	public void setTaskName(String taskName) {
		TaskName = taskName;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	
	
	
	public Task(String taskName, String date, String time) {
		
		TaskName = taskName;
		Date = date;
		Time = time;
	}
	
	
	public Task() {
		
	}
}
