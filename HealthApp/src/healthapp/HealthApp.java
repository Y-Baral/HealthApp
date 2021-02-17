package healthapp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.io.File;

public class HealthApp implements ActionListener {
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	private static JLabel success;
	private static JButton login;
	private static JPasswordField passText;
	private static JLabel pass_label;
	private static JTextField userText;
	private static JLabel user_label;
	private static JLabel result;
	// user type: client(c) or worker(w)
	private static char userType;

	public static void main(String[] args) {
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(panel);

		panel.setLayout(null);
		user_label = new JLabel("Username: ");
		user_label.setBounds(10, 20, 80, 25);
		panel.add(user_label);

		userText = new JTextField();
		userText.setBounds(100, 20, 165, 25);
		panel.add(userText);

		pass_label = new JLabel("Password: ");
		pass_label.setBounds(10, 50, 80, 25);
		panel.add(pass_label);

		passText = new JPasswordField();
		passText.setBounds(100, 50, 165, 25);
		panel.add(passText);

		login = new JButton("Login");
		login.setBounds(10, 80, 80, 25);
		login.addActionListener(new HealthApp());

		panel.add(login);

		success = new JLabel("");
		success.setBounds(10, 110, 300, 25);
		panel.add(success);

		result = new JLabel("");
		result.setBounds(10, 110, 250, 25);
		panel.add(result);

		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// demo login credentials, only for demo purposes!!!
		String demo_client = "demo_client";
		String client_password = "client_pass";
		String demo_worker = "demo_worker";
		String worker_password = "worker_pass";

		boolean username_check;
		if (demo_client.equals(userText.getText())) {
			if (client_password.equals(passText.getText())) {
				result.setText("Login Successful!");
				userType = 'c';
				// class that conatins the main gui for the app
				// TODO: call the class that conatins the main gui for the app
				// ex: app app_window(usertype);

			}
		} else if (demo_worker.equals(userText.getText())) {
			if (worker_password.equals(passText.getText())) {
				result.setText("Login Successful!");
				// sets usertype to worker
				userType = 'w';

				// TODO: call the class that conatins the main gui for the app
				// ex: app app_window(usertype);
			}
		} else {
			result.setText("login invalid!");
		}

	}
}
