package com.myaccess.Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import com.myaccess.App;
import com.myaccess.Models.FlowEE;
import com.myaccess.Repositories.UserDAO;
import com.myaccess.Util.Constraints;
import com.myaccess.Util.GuiUtil;
import com.myaccess.Util.IOUtil;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class EntryController implements Initializable {

    @FXML
    private Label lblTime;
    @FXML
    private Button btHome;
    @FXML
    private Button btReports;
    @FXML
    private Button btOptions;
    @FXML
    private Button btSupport;
    @FXML
    private Button btAbout;
    @FXML
    private Button btLogout;
    @FXML
    private Button btRegister;
    @FXML
    private Button btUpdate;
    @FXML
    private Button btDelete;
    @FXML
    private Button btEnt;
    @FXML
    private Button btExit;
    @FXML
    private Label lblErrors;
    @FXML
    private Button btSearch;
    @FXML
    private TextField txtSSN;
    @FXML
    private TextField txtVehicleModel;
    @FXML
    private TextField txtVehiclePlate;
    @FXML
    private TextField txtDestination;
    @FXML
    private TextField txtPerson;
    @FXML
    private ImageView ivPhoto;
    @FXML
    private Button btEntry;
    @FXML
    private Button btClear;
    
    Constraints constraints = new Constraints();
    GuiUtil guiUtil = new GuiUtil();
    UserDAO userDAO = new UserDAO();
    IOUtil ioUtil = new IOUtil();
    
 // ========================================================================
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        constraints.setTextFieldOnlyNumbers(txtSSN);
        constraints.setTextFieldMaxLength(txtSSN, 11);
        constraints.setTextFieldLettersNumbersEtc(txtVehicleModel);
        constraints.setTextFieldMaxLength(txtVehicleModel, 45);
        constraints.setTextFieldLettersNumbers(txtVehiclePlate);
        constraints.setTextFieldMaxLength(txtVehiclePlate, 8);
        constraints.setTextFieldLettersNumbersEtc(txtDestination);
        constraints.setTextFieldMaxLength(txtDestination, 45);
        constraints.setTextFieldOnlyLetters(txtPerson);
        constraints.setTextFieldMaxLength(txtPerson, 45);
        
        btHome.setDisable(true);
        btEnt.setDisable(true);
        txtVehicleModel.setDisable(true);
        txtVehiclePlate.setDisable(true);
        txtDestination.setDisable(true);
        txtPerson.setDisable(true);
        btEntry.setDisable(true);
        btClear.setDisable(true);

        guiUtil.initClock(lblTime);
    }
    
    @FXML
    private void reportsButtonMouseClick(MouseEvent event) {
    	
        if (event.getSource() == btReports) {
            try {
                App.setRoot("Reports");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void optionsButtonMouseClick(MouseEvent event) {
    	
        if (event.getSource() == btOptions) {
            try {
                App.setRoot("Options");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void supportButtonMouseClick(MouseEvent event) {
    	
        if (event.getSource() == btSupport) {
            try {
                App.setRoot("Support");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void aboutButtonMouseClick(MouseEvent event) {
    	
        if (event.getSource() == btAbout) {
            try {
                App.setRoot("About");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    @FXML
    private void logoutButtonMouseClick(MouseEvent event) {
    	
        if (event.getSource() == btLogout) {
            try {
                App.setRoot("Login");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void registerButtonMouseClick(MouseEvent event) {
    	
        if (event.getSource() == btRegister) {
            try {
                App.setRoot("Register");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void updateButtonMouseClick(MouseEvent event) {
    	
        if (event.getSource() == btUpdate) {
            try {
                App.setRoot("Update");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void deleteButtonMouseClick(MouseEvent event) {
    	
        if (event.getSource() == btDelete) {
            try {
                App.setRoot("Delete");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    @FXML
    private void exitButtonMouseClick(MouseEvent event) {
    	
        if (event.getSource() == btExit) {
            try {
                App.setRoot("Exit");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void clearButtonMouseClick(MouseEvent event) {
    	
        if (event.getSource() == btClear) {
        	ioUtil.hideImage(txtSSN.getText(), ivPhoto);
        	clearFields();
    	}
    }
    
    @FXML
    private void entryButtonMouseClick(MouseEvent event) {
    	
        if (event.getSource() == btEntry) {
        	setEntryGuest();
        }
    }
    
    @FXML
    private void ssnEnterKeyPressing(KeyEvent event) {
    	
        if (event.getCode() == KeyCode.ENTER) {
        	getGuest();
        }
    }
    
    @FXML
    private void searchButtonMouseClick(MouseEvent event) {
    	
    	if (event.getSource() == btSearch) {
    		getGuest();
    	}
    }
    
    private void clearFields() {
    	
    	txtSSN.setText("");
    	txtVehicleModel.setText("");
    	txtVehiclePlate.setText("");
    	txtDestination.setText("");
        txtPerson.setText("");
	    txtSSN.setEditable(true);
    	btSearch.setDisable(false);
    	txtVehicleModel.setDisable(true);
    	txtVehiclePlate.setDisable(true);
    	txtDestination.setDisable(true);
        txtPerson.setDisable(true);
    	btEntry.setDisable(true);
    	btClear.setDisable(true);
    	ioUtil.hideImage(txtSSN.getText(), ivPhoto);
    	guiUtil.setLblError(lblErrors, Color.RED, "");
    }
    
    private void getGuest() {
      	
	    if (txtSSN.getText().isEmpty()) {
	    	guiUtil.setLblError(lblErrors, Color.RED, "SSN: is blank!");
	    }
    	else if(txtSSN.getText().length() != 9 && txtSSN.getText().length() != 11) {
    		guiUtil.setLblError(lblErrors, Color.RED, "SSN: 9 or 11 digits");
    	}
	    else if (userDAO.findGuestBySSN(txtSSN.getText()) == false) {
	    	guiUtil.setLblError(lblErrors, Color.RED, "SSN: is not found!");
	    }
	    else {
	        txtSSN.setEditable(false);
		    btSearch.setDisable(true);
	        txtVehicleModel.setDisable(false);
	        txtVehiclePlate.setDisable(false);
	        txtDestination.setDisable(false);
            txtPerson.setDisable(false);
	        btEntry.setDisable(false);
            btClear.setDisable(false);
	        guiUtil.setLblError(lblErrors, Color.RED, "");
	        ioUtil.displayImage(txtSSN.getText(), ivPhoto);
	    }
    }
    
    private void setEntryGuest() {

 	    if (txtDestination.getText().isEmpty()) {
 	    	guiUtil.setLblError(lblErrors, Color.RED, "Destination: is blank!");
	    }
        else if (txtPerson.getText().isEmpty()) {
            guiUtil.setLblError(lblErrors, Color.RED, "Person: is blank!");
        }
 	    else {
	 	    String ssn = txtSSN.getText();
	 	    String vehicleModel = txtVehicleModel.getText();
	 	    String vehiclePlate = txtVehiclePlate.getText().toUpperCase();
	 	    String destination = txtDestination.getText();
            String person = txtPerson.getText();
			Timestamp date = Timestamp.valueOf(LocalDateTime.now());
	 	    String type = "ENTRY";
	 	    
	 	    FlowEE entry = new FlowEE(null, ssn, vehicleModel, vehiclePlate, destination, person, date, type);
		    userDAO.entryGuest(entry);
		    clearFields();
		    guiUtil.setLblError(lblErrors, Color.GREEN, "Entry completed!");
 	    }
    }
}