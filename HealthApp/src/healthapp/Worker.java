package healthapp;

import java.awt.List;
import java.time.LocalTime;
import java.util.ArrayList;

public class Worker extends User {
	String id;
	String hospital;
	ArrayList<Client> clients;
	String occupation;

	public Worker(String username, String password, String fName, String lName, int pNum, String id, String hospital,
			ArrayList<Client> clients, String occupation) {
		super(username, password, fName, lName, pNum);
		this.id = id;
		this.hospital = hospital;
		this.clients = clients;
		this.occupation = occupation;
	}

	public void sendReminder(Client c, Reminder reminder) {
		c.addReminder(reminder);

	}

	public void sendReminder(Client c, Reminder reminder, String day, LocalTime eventTime) {
		c.addReminder(reminder);
	}

	public void sendEvent(Client c, Event event) {
		c.addEvent(event);
	}

	public void sendNotif(Client c) {
		c.notifiy();

	}

	public void call(Client c) {
		System.out.println("Outgoing phone call to " + c.fName + c.lName);
	}

	public void addCondition(Client c, String condition) {
		c.addCondition(condition);
	}

	public void addContact(Client c, String contact) {
		c.addContact(contact);
	}

}
