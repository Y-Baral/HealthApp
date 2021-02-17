package healthapp;
import java.time.LocalTime;

public class Reminder {
	private String reminder;
	private String day;
	private LocalTime eventTime;
	
	Reminder(String reminder, String day, LocalTime eventTime){
		this.reminder = reminder;
		this.day = day;
		this.eventTime = eventTime;
	}
	
	public String getReminder() {
		return reminder;
	}
	public void setReminder(String reminder) {
		this.reminder = reminder;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public LocalTime getEventTime() {
		return eventTime;
	}
	public void setEventTime(LocalTime eventTime) {
		this.eventTime = eventTime;
	}
}
