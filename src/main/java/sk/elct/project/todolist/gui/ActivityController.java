package sk.elct.project.todolist.gui;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Observable;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import sk.elct.project.todolist.Activity;
import sk.elct.project.todolist.ActivityDao;
import sk.elct.project.todolist.DaoFactory;


public class ActivityController {
	
	private ActivityDao activityDao = DaoFactory.INSTANCE.getActivityDao();
	
    @FXML
    private Button addButton;

    @FXML
    private TableView<Activity> activityTableView;

    @FXML
    private TextField titleTextField;

    @FXML
    private TextField prioritytextField;

    @FXML
    private TextField dueDateTextField;

    @FXML
    private TextArea bodyTextArea;

    @FXML
    private TextField progressTextField;
    
    
    private ActivityFxModel activityModel = new ActivityFxModel();
    private ObservableList<Activity> activityObservableList;
   // private Activity selectedActivity;

    @FXML
    void initialize() {
    	titleTextField.textProperty().bindBidirectional(activityModel.titleProperty());
    	bodyTextArea.textProperty().bindBidirectional(activityModel.bodyProperty());
    	//prioritytextField.textProperty().bindBidirectional(prioritytextField.priorityy());
    	addButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
		//userDao.add(newUserModel.getUser());
		Activity activity = activityModel.getActivity();
		activityDao.add(activity);
		activityObservableList.add(activity);
		activityObservableList.setAll(activityDao.getAll());
		//ideme vyprazdnit textfield
		activityModel.setTitle(null);
		activityModel.setBody("");	
		}
	});
  
    	List<Activity> activity = activityDao.getAll();
    	this.activityObservableList = FXCollections.observableArrayList(activity);	
    	
    	TableColumn<Activity, String> titleColumn = new TableColumn<>("Nazov aktivity");
    	titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
    	activityTableView.getColumns().add(titleColumn);
    	
    	TableColumn<Activity, String> bodyColumn = new TableColumn<>("Popis");
    	bodyColumn.setCellValueFactory(new PropertyValueFactory<>("body"));
    	activityTableView.getColumns().add(bodyColumn);
    	
    	TableColumn<Activity, LocalDateTime> dueDateColumn = new TableColumn<>("Datum");
    	dueDateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
    	activityTableView.getColumns().add(dueDateColumn);
    	
    	TableColumn<Activity, String> priorityColumn = new TableColumn<>("Priorita");
    	priorityColumn.setCellValueFactory(new PropertyValueFactory<>("priority"));
    	activityTableView.getColumns().add(priorityColumn);
    	
    	TableColumn<Activity, String> progressColumn = new TableColumn<>("Stav");
    	progressColumn.setCellValueFactory(new PropertyValueFactory<>("progress"));
    	activityTableView.getColumns().add(progressColumn);
    	
    	activityTableView.setItems(this.activityObservableList);
    	
//    	tableTextView.getSelectionModel().selectedItemProperty()
//    	.addListener(new ChangeListener<Activity>() {
//    		@Override
//			public void changed(ObservableValue<? extends Activity> observable, Activity oldValue, Activity newValue) {
//				if(newValue != null) {
//					selectedActivityLabel.setText(newValue.getName());	
//					selectedActivity = newValue;
//				} else {
//					selectedActivityLabel.setText("nikto");	
//					selectedActivity = null;
//				}
//			}		
//    	});
    	
    }
}


