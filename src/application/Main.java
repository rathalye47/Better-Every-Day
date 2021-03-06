package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {
	
	// Widths and heights for the screens.
	private static final double LargeWidth = 1025;
	private static final double LargeHeight = 650;
	private static final double SmallWidth = 500;
	private static final double SmallHeight = 350;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setResizable(false);
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent e) {
				Platform.exit();
				System.exit(0);
			}
		});
		
		// loads routes
		FXRouter.bind(this, primaryStage, "Better Every Day");
		FXRouter.when("login", "LoginScreen.fxml", new LoginScreenController(), LargeWidth, LargeHeight);
		FXRouter.when("register", "CreateAccountScreen.fxml", new CreateAccountController(), LargeWidth, LargeHeight);
		FXRouter.when("home", "HomeScreen.fxml", new HomeScreenController(), LargeWidth, LargeHeight);
		FXRouter.when("profile", "ProfileScreen.fxml", new ProfileController(), LargeWidth, LargeHeight);
		FXRouter.when("settings", "SettingsScreen.fxml", new SettingsController(), LargeWidth, LargeHeight);
		FXRouter.when("createHabit", "CreateHabitScreen.fxml", new CreateHabitController(), SmallWidth, SmallHeight);
		
		Platform.setImplicitExit(false);
		
		try {
			FXRouter.startFrom("login");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}