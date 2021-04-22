package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AnotherExampleScreenController {
	
	@FXML 
	protected void anotherExampleScreenButtonAction(ActionEvent event) {
		try {
			FXRouter.goTo("exampleScreen");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
