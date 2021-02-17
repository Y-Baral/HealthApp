package healthapp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Client extends User{
	private static LocalDate current;
	private ArrayList<Event> eventDay;
	private ArrayList<Reminder> remindDay;
	
	
	private int age;
	private String address;

	private ArrayList<String> condition;
	private ArrayList<String> emergencyList;
	
	private ArrayList<Event> events;
	private ArrayList<Event> monday;
	private ArrayList<Event> tuesday;
	private ArrayList<Event> wednesday;
	private ArrayList<Event> thursday;
	private ArrayList<Event> friday;
	private ArrayList<Event> saturday;
	private ArrayList<Event> sunday;
	
	private ArrayList<Reminder> reminders;
	private ArrayList<Reminder> monday1;
	private ArrayList<Reminder> tuesday1;
	private ArrayList<Reminder> wednesday1;
	private ArrayList<Reminder> thursday1;
	private ArrayList<Reminder> friday1;
	private ArrayList<Reminder> saturday1;
	private ArrayList<Reminder> sunday1;
	
	Client(String username, String password, String fName, String lName, int pNum, int age, ArrayList<String> condition, ArrayList<Event> events, String address, ArrayList<Reminder> reminders){
		super( username,  password,  fName,  lName,  pNum);
		this.condition = condition;
		this.events = events;
		this.address = address;
		this.reminders = reminders;
		eventListDaySorter();
		remindListDaySorter();
	}
	
	
	
	void notifiy() {
		for(int i = 0; i < this.eventDay.size(); i++) {
			if(this.remindDay.get(i).getEventTime().equals(LocalTime.now())) {
				System.out.println("You have an appointment now.");
				System.out.println("Appointment: " + this.eventDay.get(i).getEventName());
				System.out.println("Date: " + this.eventDay.get(i).getEventDate().toString());
				System.out.println("Time: " + this.eventDay.get(i).getEventTime().toString());
				System.out.println("Video call: " + this.eventDay.get(i).isVideoCall());
				System.out.println("Location: " + this.eventDay.get(i).getLocation());
			}else if(this.eventDay.get(i).getEventTime().minusMinutes(30) == LocalTime.now()) {
				System.out.println("You have an appointment in 30 minutes.");
				System.out.println("Appointment: " + this.eventDay.get(i).getEventName());
				System.out.println("Date: " + this.eventDay.get(i).getEventDate().toString());
				System.out.println("Time: " + this.eventDay.get(i).getEventTime().toString());
				System.out.println("Video call: " + this.eventDay.get(i).isVideoCall());
				System.out.println("Location: " + this.eventDay.get(i).getLocation());
			}
		}
		
		for(int i = 0; i < this.remindDay.size(); i++) {
			if(this.remindDay.get(i).getEventTime().equals(LocalTime.now())) {
				System.out.println("Reminder: " + this.remindDay.get(i).getReminder());
				System.out.println("Time: " + this.remindDay.get(i).getEventTime().toString());
			}else if(this.eventDay.get(i).getEventTime().minusMinutes(15) == LocalTime.now()) {
				System.out.println("Quarter before Reminder: " + this.remindDay.get(i).getReminder());
				System.out.println("Time: " + this.remindDay.get(i).getEventTime().toString());
			}
		}
		
	}
	
	void emergency() {
		call911();
		System.out.println("911 has been contacted.");
		callList(this.emergencyList);
		System.out.println("Emergency contacts notified.");
	}
	
	void addReminder(Reminder reminder) {
		this.reminders.add(reminder);
		remindDaySort(reminder);
	}
	
	void addReminder(String reminder, String day, LocalTime eventTime) {
		Reminder r = new Reminder(reminder, day, eventTime);
		remindDaySort(r);
	}
	
	
	void addEvent(Event event) {
		this.events.add(event);
		eventDaySort(event);
	}
	
	void addEvent(String eventName, boolean videoCall, LocalDate eventDate, LocalTime eventTime, String location) {
		Event e = new Event(eventName,  videoCall,  eventDate, eventTime, location);
		this.events.add(e);
		eventDaySort(e);
	}
	
	void eventListDaySorter() {
		for(int i = 0; i < events.size(); i++) {
			Event ind = this.events.get(i);
			if(ind.getEventDate().getDayOfWeek().getValue() == 1) {
				monday.add(ind);
			}else if(ind.getEventDate().getDayOfWeek().getValue() == 2) {
				tuesday.add(ind);
			}else if(ind.getEventDate().getDayOfWeek().getValue() == 3) {
				wednesday.add(ind);
			}else if(ind.getEventDate().getDayOfWeek().getValue() == 4) {
				thursday.add(ind);
			}else if(ind.getEventDate().getDayOfWeek().getValue() == 5) {
				friday.add(ind);
			}else if(ind.getEventDate().getDayOfWeek().getValue() == 6) {
				saturday.add(ind);
			}else if(ind.getEventDate().getDayOfWeek().getValue() == 7) {
				sunday.add(ind);
			}
		}
	}
	
	private void eventDaySort(Event ind) {
		if(ind.getEventDate().getDayOfWeek().getValue() == 1) {
			monday.add(ind);
		}else if(ind.getEventDate().getDayOfWeek().getValue() == 2) {
			tuesday.add(ind);
		}else if(ind.getEventDate().getDayOfWeek().getValue() == 3) {
			wednesday.add(ind);
		}else if(ind.getEventDate().getDayOfWeek().getValue() == 4) {
			thursday.add(ind);
		}else if(ind.getEventDate().getDayOfWeek().getValue() == 5) {
			friday.add(ind);
		}else if(ind.getEventDate().getDayOfWeek().getValue() == 6) {
			saturday.add(ind);
		}else if(ind.getEventDate().getDayOfWeek().getValue() == 7) {
			sunday.add(ind);
		}
	}
	
	void remindListDaySorter() {
		for(int i = 0; i < reminders.size(); i++) {
			Reminder ind = this.reminders.get(i);
			if(ind.getDay().toUpperCase().equals("MONDAY")) {
				monday1.add(ind);
			}else if(ind.getDay().toUpperCase().equals("TUESDAY")) {
				tuesday1.add(ind);
			}else if(ind.getDay().toUpperCase().equals("WEDNESDAY")) {
				wednesday1.add(ind);
			}else if(ind.getDay().toUpperCase().equals("THURSDAY")) {
				thursday1.add(ind);
			}else if(ind.getDay().toUpperCase().equals("FRIDAY")) {
				friday1.add(ind);
			}else if(ind.getDay().toUpperCase().equals("SATURDAY")) {
				saturday1.add(ind);
			}else if(ind.getDay().toUpperCase().equals("SUNDAY")) {
				sunday1.add(ind);
			}
		}
	}
	
	private void remindDaySort(Reminder ind) {
		if(ind.getDay().toUpperCase().equals("MONDAY")) {
			monday1.add(ind);
		}else if(ind.getDay().toUpperCase().equals("TUESDAY")) {
			tuesday1.add(ind);
		}else if(ind.getDay().toUpperCase().equals("WEDNESDAY")) {
			wednesday1.add(ind);
		}else if(ind.getDay().toUpperCase().equals("THURSDAY")) {
			thursday1.add(ind);
		}else if(ind.getDay().toUpperCase().equals("FRIDAY")) {
			friday1.add(ind);
		}else if(ind.getDay().toUpperCase().equals("SATURDAY")) {
			saturday1.add(ind);
		}else if(ind.getDay().toUpperCase().equals("SUNDAY")) {
			sunday1.add(ind);
		}
	}
	
	void updateDay() {
		current = LocalDate.now();
		if(current.getDayOfWeek().getValue() == 1) {
			this.eventDay = this.monday;
			this.remindDay = this.monday1;
		}else if(current.getDayOfWeek().getValue() == 2) {
			this.eventDay = this.tuesday;
			this.remindDay = this.tuesday1;
		}else if(current.getDayOfWeek().getValue() == 3) {
			this.eventDay = this.wednesday;
			this.remindDay = this.wednesday1;
		}else if(current.getDayOfWeek().getValue() == 4) {
			this.eventDay = this.thursday;
			this.remindDay = this.thursday1;
		}else if(current.getDayOfWeek().getValue() == 5) {
			this.eventDay = this.friday;
			this.remindDay = this.friday1;
		}else if(current.getDayOfWeek().getValue() == 6) {
			this.eventDay = this.saturday;
			this.remindDay = this.saturday1;
		}else if(current.getDayOfWeek().getValue() == 7) {
			this.eventDay = this.sunday;
			this.remindDay = this.sunday1;
		}
	}
	
	void callList(ArrayList<String> emergencyList) {
		//placeholder
	}
	
	void call911() {
		//placeholder
	}
	
	public void addCondition(String condition) {
		this.condition.add(condition);
	}
	
	public void addContact(String contact) {
		this.emergencyList.add(contact);
	}
	
	public ArrayList<String> getCondition() {
		return condition;
	}

	public void setCondition(ArrayList<String> condition) {
		this.condition = condition;
	}

	public ArrayList<String> getEmergencyList() {
		return emergencyList;
	}

	public void setEmergencyList(ArrayList<String> emergencyList) {
		this.emergencyList = emergencyList;
	}
	
}
