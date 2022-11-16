package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
//import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class FormController implements Initializable{
	
	private String[] states = new String[13];
	@FXML private ChoiceBox<String>cboStates;
	@FXML private ComboBox<String> cboCourses;
	@FXML private RadioButton csRadioButton;
	@FXML private RadioButton bRadioButton;
	@FXML private TextArea displayArea;
	@FXML private TextField txtName;
	@FXML private TextField txtAddress;
	@FXML private TextField txtCity;
	@FXML private TextField txtPostalCode;
	@FXML private TextField txtPhoneNumber;
	@FXML private TextField txtEmail;
	@FXML private CheckBox cbStudentCouncil;
	@FXML private CheckBox cbVolunteerWork;
	@FXML private ListView<String> lvCourses;
	private ToggleGroup studentType;
	public FormController() {
		
		
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		//Configuring Choice box for states
		 states[0] = "ON";
		 states[1] = "QC";
		 states[2] = "NS";
		 states[3] = "BC";
		 states[4] = "AB";
		 states[5] = "MB";
		 states[6] = "SK";
		 states[7] = "NB";
		 states[8] = "PB";
		 states[9] = "NL";
		 states[10] = "NT";
		 states[11] = "YT";
		 states[12] = "NU";
		cboStates.getItems().addAll(states);
		
		studentType = new ToggleGroup();
		csRadioButton.setToggleGroup(studentType);
		bRadioButton.setToggleGroup(studentType);
		displayArea.setText("");
	
		//Set courses comboBox
		
		Student s1 = new ComputerScience();
		s1.setCourses();
		cboCourses.getItems().addAll(s1.getCourses());
		
		
		
	}
	
	@FXML 
	public void displayInfo() {
		if(txtName.getText().isEmpty()) {
			displayArea.setText("\nPlease Insert your Name before continuing");
		}
		
		else if(txtAddress.getText().isEmpty()) {
			displayArea.setText("\nPlease Insert your Address before continuing");
		}
		else if(txtCity.getText().isEmpty()) {
			displayArea.setText("\nPlease Insert your City before continuing");
		}
		else if(txtPostalCode.getText().isEmpty()) {
			displayArea.setText("\nPlease Insert your Postal Code before continuing");
		}
		else if(txtPhoneNumber.getText().isEmpty()) {
			displayArea.setText("\nPlease Insert your Phone Number before continuing");
		}
		else if(txtEmail.getText().isEmpty()) {
			displayArea.setText("\nPlease Insert your Email before continuing");
		}
		else if(cboStates.getSelectionModel().isEmpty()) {
			displayArea.setText("\nPlease choose a province");
		}
		else if(cboCourses.getSelectionModel().isEmpty()) {
			displayArea.setText("\nPlease choose at least a course to continue");
		}
		else if (studentType.getSelectedToggle().equals(csRadioButton)) {
			Student s1 = new ComputerScience(txtName.getText(), txtAddress.getText(), cboStates.getSelectionModel().getSelectedItem(), txtCity.getText(), txtPostalCode.getText(), txtPhoneNumber.getText(), txtEmail.getText());
			s1.setCourses();
			String message = s1.toString();
		 ObservableList<String> courses = lvCourses.getItems();
			
			for(int i = 0; i<courses.size(); i++) {
				message+= "\n"+courses.get(i);
			}
			
			if(cbStudentCouncil.isSelected()) {
				message += "\nExtra curricular activity: Student Council";
			}
			if(cbVolunteerWork.isSelected()) {
				message += "\nExtra curricular activity: Volunteer Work";
			}
			
			displayArea.setText(message);
			deleteFormContent();
			csRadioButton.setDisable(false);
			bRadioButton.setDisable(false);
			lvCourses.getItems().clear();
			
		}
		else if (studentType.getSelectedToggle().equals(bRadioButton)) {
			Student s1 = new Business(txtName.getText(), txtAddress.getText(), cboStates.getSelectionModel().getSelectedItem(), txtCity.getText(), txtPostalCode.getText(), txtPhoneNumber.getText(), txtEmail.getText());
			s1.setCourses();
			String message = s1.toString();
			 ObservableList<String> courses = lvCourses.getItems();
				
				for(int i = 0; i<courses.size(); i++) {
					message+= "\n"+courses.get(i);
				}
			
			if(cbStudentCouncil.isSelected()) {
				message += "\nExtra curricular activity: Student Council";
			}
			if(cbVolunteerWork.isSelected()) {
				message += "\nExtra curricular activity: Volunteer Work";
			}
			
			displayArea.setText(message);
			deleteFormContent();
			csRadioButton.setDisable(false);
			bRadioButton.setDisable(false);
			lvCourses.getItems().clear();
		}
		
	
		
	}
	
	
	
	@FXML
	public void radioButtonChanged(){
		
		
	
		if (studentType.getSelectedToggle().equals(csRadioButton)) {
			Student s1 = new ComputerScience();
			s1.setCourses();
			cboCourses.getItems().clear();
			cboCourses.getItems().addAll(s1.getCourses());
		}
		else if (studentType.getSelectedToggle().equals(bRadioButton)) {
			Student s1 = new Business();
			s1.setCourses();
			cboCourses.getItems().clear();
			cboCourses.getItems().addAll(s1.getCourses());
		}
		
		
	}
	
	
	@FXML public void comboBoxSelection() {
		if(cboCourses.getSelectionModel().getSelectedItem() != null) {
		lvCourses.getItems().add(cboCourses.getSelectionModel().getSelectedItem());
		csRadioButton.setDisable(true);
		bRadioButton.setDisable(true);
		}
	}
	
	public void deleteFormContent() {
		txtName.setText("");
		txtAddress.setText("");
		txtEmail.setText("");
		txtPhoneNumber.setText("");
		txtPostalCode.setText("");
		txtCity.setText("");
		cbVolunteerWork.setSelected(false);
		cbStudentCouncil.setSelected(false);
		cboStates.valueProperty().set(null);
		cboCourses.valueProperty().set(null);
	}
	
	
}
