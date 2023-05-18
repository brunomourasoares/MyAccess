package com.myaccess.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.myaccess.App;
import com.myaccess.Repositories.DB;
import com.myaccess.Repositories.UserDAO;
import com.myaccess.Util.AES256;
import com.myaccess.Util.Constraints;
import com.myaccess.Util.GuiUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class ForgotPasswordController implements Initializable {

	@FXML
	private Label lblErrors;
	@FXML
	private TextField txtLogin;
	@FXML
	private ComboBox<String> cbQuestion;
	@FXML
	private TextField txtAnswer;
	@FXML
	private PasswordField pfNewPassword;
	@FXML
	private PasswordField pfConfirmNewPassword;
	@FXML
	private Button btRecovery;
	@FXML
	private Button btClear;
	@FXML
	private Button btBack;

	UserDAO userDAO = new UserDAO();
	DB db = new DB();
	Constraints constraints = new Constraints();
	GuiUtil guiUtil = new GuiUtil();
	AES256 aes256 = new AES256();
	
	private ObservableList<String> obsList;

	// ========================================================================
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		constraints.setTextFieldLettersNumbers(txtLogin);
		constraints.setTextFieldMaxLength(txtLogin, 45);
		constraints.setPasswordFieldLettersNumbers(pfNewPassword);
		constraints.setPasswordFieldLettersNumbers(pfConfirmNewPassword);
		constraints.setPasswordFieldMaxLength(pfNewPassword, 20);
		constraints.setPasswordFieldMaxLength(pfConfirmNewPassword, 20);

		List<String> list = new ArrayList<>();
		list.add("Select the secret question.");
		list.add("what is your pet's name?");
		list.add("what is your SSN number?");
		list.add("what is your mother's name?");
		list.add("what is the license plate number of your car?");
		list.add("what is the name of your first school?");

		obsList = FXCollections.observableArrayList(list);
		cbQuestion.setItems(obsList);
		cbQuestion.getSelectionModel().clearSelection();
	}

	@FXML
	private void clearButtonMouseClick(MouseEvent event) {
		
		if (event.getSource() == btClear) {
			clearFields();
		}
	}

	@FXML
	private void recoveryButtonMouseClick(MouseEvent event) {
		
		if (event.getSource() == btRecovery) {
			recoveryPassCheck();
		}
	}

	@FXML
	private void backButtonMouseClick(MouseEvent event) {
		
		if (event.getSource() == btBack) {
			try {
				App.setRoot("Login");
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void recoveryPassCheck() {

		String username = txtLogin.getText();
		String question = cbQuestion.getSelectionModel().getSelectedItem();
		String answer = txtAnswer.getText();
		String newPassword = pfNewPassword.getText();
		String confirmNewPassword = pfConfirmNewPassword.getText();

		if(username.isEmpty()) {
			guiUtil.setLblError(lblErrors, Color.RED, "Username: is blank!");
		}
		else if (question == null || question == "Select the secret question.") {
			guiUtil.setLblError(lblErrors, Color.RED, "Question: select a secret question!");
		}
		else if (answer.isEmpty()) {
			guiUtil.setLblError(lblErrors, Color.RED, "Answer: is blank!");
		}
		else if (newPassword.isEmpty()) {
			guiUtil.setLblError(lblErrors, Color.RED, "New password: is blank!");
		}
		else if (confirmNewPassword.isEmpty()) {
			guiUtil.setLblError(lblErrors, Color.RED, "Confirm New Password: is blank!");
		}
		else if (!newPassword.equals(confirmNewPassword)) {
			guiUtil.setLblError(lblErrors, Color.RED, "New password and confirm are not the same!");
		}
		else if (userDAO.findBlockedUserStatusByName(username) == true) {
			guiUtil.setLblError(lblErrors, Color.RED, "User is blocked!");
		}
		else if (userDAO.findRecoveryUser(username, question, answer) == false) {
			guiUtil.setLblError(lblErrors, Color.RED, "Incorrect Username / Question or Answer!");
		}
		else {
			userDAO.setUserPassword(username, newPassword);
			clearFields();
			guiUtil.setLblError(lblErrors, Color.GREEN, "New password has been set!");
		}
	}
	
	private void clearFields() {
		
		txtLogin.setText("");
		txtAnswer.setText("");
		cbQuestion.getSelectionModel().clearSelection();
		pfNewPassword.setText("");
		pfConfirmNewPassword.setText("");
		guiUtil.setLblError(lblErrors, Color.RED, "");
	}
}