package application;

import java.util.ArrayList;
import java.util.Timer;

import org.bson.Document;

import com.mongodb.client.model.Filters;

public final class RemindersManager {

	private static ArrayList<Reminder> reminders;
	private static Timer t;
	
	public static void init() {
		t = new Timer();
		Db.db.findMany("reminders", Filters.eq("username", Auth.currentUser.getUsername())).forEach((Document reminder) -> reminders.add(new Reminder(reminder)));
		reminders.forEach((Reminder reminder) -> t.scheduleAtFixedRate(reminder, 0, 5000));
	}
	
	public static void addReminder(Reminder reminder) {
		Db.db.addItemToDB("reminders", reminder.getDocument().append("username", Auth.currentUser.getUsername()));
		reminders.add(reminder);
		t.scheduleAtFixedRate(reminder, 0, 5000);
	}
	
}