package com.myaccess.Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

public class ExitController implements Initializable {

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
    private Button btEntry;
    @FXML
    private Button btEx;
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
    private TextField txtEntryDate;
    @FXML
    private Button btExit;
    @FXML
    private Button btClear;
    @FXML
    private ImageView ivPhoto;
    
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
        btEx.setDisable(true);
        txtVehicleModel.setDisable(true);
        txtVehiclePlate.setDisable(true);
        txtDestination.setDisable(true);
        txtPerson.setDisable(true);
        txtEntryDate.setDisable(true);
        btExit.setDisable(true);
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
    private void entryButtonMouseClick(MouseEvent event) {
    	
        if (event.getSource() == btEntry) {
            try {
                App.setRoot("Entry");
            }
            catch (IOException e) {
            	e.printStackTrace();
            }
        }
    }

    @FXML
    private void exitButtonMouseClick(MouseEvent event) {
    	
        if (event.getSource() == btExit) {
        	setExitGuest();
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
    	
    	btSearch.setDisable(false);
    	txtSSN.setText("");
	    txtSSN.setEditable(true);
    	txtVehicleModel.setText("");
        txtVehicleModel.setDisable(true);
    	txtVehiclePlate.setText("");
        txtVehiclePlate.setDisable(true);
    	txtDestination.setText("");
        txtDestination.setDisable(true);
        txtPerson.setText("");
        txtPerson.setDisable(true);
    	txtEntryDate.setText("");
        txtEntryDate.setDisable(true);
    	btExit.setDisable(true);
    	btClear.setDisable(true);
    	guiUtil.setLblError(lblErrors, Color.RED, "");
    }
    
    private void getGuest() {
      	
	    FlowEE exit = userDAO.getLastFlowBySSN(txtSSN.getText());

	    if (txtSSN.getText().isEmpty()) {
	    	guiUtil.setLblError(lblErrors, Color.RED, "SSN: is blank!");
	    }
    	else if(txtSSN.getText().length() != 9 && txtSSN.getText().length() != 11) {
    		guiUtil.setLblError(lblErrors, Color.RED, "SSN: 9 or 11 digits");
    	}
	    else if (userDAO.findGuestBySSN(txtSSN.getText()) == false) {
	    	guiUtil.setLblError(lblErrors, Color.RED, "SSN: is not found!");
	    }
	    else if (exit == null) {
	    	guiUtil.setLblError(lblErrors, Color.RED, "There is no entry from this Guest!");
	    }
	    else if (exit.getType().equalsIgnoreCase("EXIT")) {
	    	guiUtil.setLblError(lblErrors, Color.RED, "You need to Entry the Guest first!");
	    }
	    else {
		    txtSSN.setEditable(false);
		    btSearch.setDisable(true);
            txtVehicleModel.setDisable(false);
            txtVehiclePlate.setDisable(false);
            txtDestination.setDisable(false);
            txtPerson.setDisable(false);
            txtEntryDate.setDisable(false);
		    btClear.setDisable(false);
	        btExit.setDisable(false);

	        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		    
		    txtVehicleModel.setText(exit.getVehicleModel());
		    txtVehiclePlate.setText(exit.getVehiclePlate());
		    txtDestination.setText(exit.getDestination());
            txtPerson.setText(exit.getPerson());
		    txtEntryDate.setText(exit.getDate().toLocalDateTime().format(dtf).toString());
	        guiUtil.setLblError(lblErrors, Color.RED, "");
	        ioUtil.displayImage(txtSSN.getText(), ivPhoto);

            txtVehicleModel.setEditable(false);
            txtVehiclePlate.setEditable(false);
            txtDestination.setEditable(false);
            txtPerson.setEditable(false);
            txtEntryDate.setEditable(false);
	    }
    }
    
    private void setExitGuest() {

 	    String ssn = txtSSN.getText();
 	    String vehicleModel = txtVehicleModel.getText();
 	    String vehiclePlate = txtVehiclePlate.getText().toUpperCase();
 	    String destination = txtDestination.getText();
        String person = txtPerson.getText();
		Timestamp date = Timestamp.valueOf(LocalDateTime.now());
 	    String type = "EXIT";
 	    
 	    FlowEE exit = new FlowEE(null, ssn, vehicleModel, vehiclePlate, destination, person, date, type);
	    userDAO.exitGuest(exit);
    	ioUtil.hideImage(txtSSN.getText(), ivPhoto);
	    clearFields();
	    guiUtil.setLblError(lblErrors, Color.GREEN, "Exit completed!");
    }
}