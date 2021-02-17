package healthapp;

import java.time.LocalDate;
import java.time.LocalTime;

public class Event {
	private String eventName;
	private String location;
	private boolean videoCall;
	private LocalDate eventDate;
	private LocalTime eventTime;
	public Event(String eventName, boolean videoCall, LocalDate eventDate, LocalTime eventTime, String location) {
		this.eventName = eventName;
		this.videoCall = videoCall;
		this.location = location;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDate getEventDate() {
		return eventDate;
	}
	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}
	public LocalTime getEventTime() {
		return eventTime;
	}
	public void setEventTime(LocalTime eventTime) {
		this.eventTime = eventTime;
	}
	public boolean isVideoCall() {
		return videoCall;
	}
	public void setVideoCall(boolean videoCall) {
		this.videoCall = videoCall;
	}
}
