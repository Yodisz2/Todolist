package sk.elct.project.todolist.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ActivityManagementApp extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		ActivityController controller = new ActivityController();
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("activityTable.fxml"));
		fxmlLoader.setController(controller);
		Parent rootPane = fxmlLoader.load();
		Scene scene = new Scene(rootPane);
		primaryStage.setTitle("Activity management");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}


}
