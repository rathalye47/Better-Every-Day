package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CreateAccountController {
	
	// Username field.
	@FXML
	private TextField username;
	
	// Email field.
	@FXML
	private TextField email;
	
	// Password field.
	@FXML
	private PasswordField password;
	
	// Create Account button.
	@FXML
	private Button createAccount;
	
	// Button to return to login screen.
	@FXML
	private Button goBack;
	
	// Taken username label.
	@FXML
	private Label takenUsername;
	
	// When the Create Account button is clicked, the Home Screen comes up. If the user tries to create an account with a username that's already
	// taken, an error message will pop up.
	@FXML 
	protected void createAccount(ActionEvent event) throws IOException {
		
		boolean ok = Auth.createUser(username.getText(), password.getText(), email.getText());
		
		if (ok) {
			FXRouter.goTo("home");
		}
		
		else
		{
			takenUsername.setText("This username is already taken!");
		}
	}
	
	// When the Go Back button is clicked, the user returns to Login screen.
	@FXML
	protected void goBack(ActionEvent event) throws IOException {
		FXRouter.goTo("login");
	}
}