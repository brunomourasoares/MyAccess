package com.myaccess.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.myaccess.App;
import com.myaccess.Models.Guest;
import com.myaccess.Repositories.UserDAO;
import com.myaccess.Util.Constraints;
import com.myaccess.Util.GuiUtil;
import com.myaccess.Util.IOUtil;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;

public class DeleteController implements Initializable {
	
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
    private Label lblErrors;
    @FXML
    private Button btSearch;
    @FXML
    private TextField txtSSN;
    @FXML
    private TextField txtFullName;
    @FXML
    private TextField txtGender;
    @FXML
    private TextField txtCompanyName;
    @FXML
    private ImageView ivPhoto;
    @FXML
    private Button btClear;
    @FXML
    private Button btDelete;
    @FXML
    private Button btRegister;
    @FXML
    private Button btUpdate;
    @FXML
    private Button btDel;
    @FXML
    private Button btEntry;
    @FXML
    private Button btExit;
    
    UserDAO userDAO = new UserDAO();
    Constraints constraints = new Constraints();
    IOUtil ioUtil = new IOUtil();
    GuiUtil guiUtil = new GuiUtil();
    
// ========================================================================
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
        constraints.setTextFieldOnlyNumbers(txtSSN);
        constraints.setTextFieldMaxLength(txtSSN, 11);
        
        btHome.setDisable(true);
        btDel.setDisable(true);
        txtFullName.setDisable(true);
        txtGender.setDisable(true);
        txtCompanyName.setDisable(true);
        btDelete.setDisable(true);
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
            try {
                App.setRoot("Exit");
            }
            catch (IOException e) {
            	e.printStackTrace();
            }
        }
    }
    
    @FXML
    private void searchButtonMouseClick(MouseEvent event) {
    	
    	if (event.getSource() == btSearch) {
    		getDeleteGuest();
    	}
    }
    
    @FXML
    private void ssnEnterKeyPressing(KeyEvent event) {
    	
        if (event.getCode() == KeyCode.ENTER) {
        	getDeleteGuest();
        }
    }
    
    @FXML
    private void deleteButtonMouseClick(MouseEvent event) {
    	
        if (event.getSource() == btDelete) {
        	setDeleteGuest();
        }
    }

    @FXML
    private void clearButtonMouseClick(MouseEvent event) {
        if (event.getSource() == btClear) {
        	clearFields();
    	}
    }
    
    private void getDeleteGuest() {
      	
	    if (txtSSN.getText().isEmpty()) {
	    	guiUtil.setLblError(lblErrors, Color.RED, "SSN: is blank!");
	    }
    	else if(txtSSN.getText().length() != 9 && txtSSN.getText().length() != 11) {
    		guiUtil.setLblError(lblErrors, Color.RED, "SSN: 9 or 11 digits");
    	}
	    else if (userDAO.findGuestBySSN(txtSSN.getText()) == false) {
	    	guiUtil.setLblError(lblErrors, Color.RED, "SSN: not found!");
	    }
	    else {
		    txtSSN.setEditable(false);
		    btSearch.setDisable(true);
            txtFullName.setDisable(false);
            txtGender.setDisable(false);
            txtCompanyName.setDisable(false);
	        btDelete.setDisable(false);
	        btClear.setDisable(false);
	        
		    Guest guest = userDAO.getGuestBySSN(txtSSN.getText());
		    txtFullName.setText(guest.getFullName());
		    txtGender.setText(guest.getGender());
		    txtCompanyName.setText(guest.getCompanyName());
		    guiUtil.setLblError(lblErrors, Color.RED, "");
	        ioUtil.displayImage(txtSSN.getText(), ivPhoto);
	    }
    }
    
    private void setDeleteGuest() {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText("DELETING...");
		alert.setContentText("Are you sure you want to delete this Guest?");
		alert.initStyle(StageStyle.UNDECORATED);
			
		if (alert.showAndWait().get() == ButtonType.OK) {
			userDAO.deleteGuest(txtSSN.getText());
			ioUtil.deletePhoto(txtSSN.getText());
			clearFields();
			guiUtil.setLblError(lblErrors, Color.GREEN, "Guest has been DELETED!");
		}
    }
    
    private void clearFields() {
    	
    	txtSSN.setText("");
        txtFullName.setText("");
    	txtGender.setText("");
    	txtCompanyName.setText("");
	    btSearch.setDisable(false);
	    txtSSN.setEditable(true);
        txtFullName.setDisable(true);
        txtGender.setDisable(true);
        txtCompanyName.setDisable(true);
        btDelete.setDisable(true);
        btClear.setDisable(true);
    	ioUtil.hideImage(txtSSN.getText(), ivPhoto);
        guiUtil.setLblError(lblErrors, Color.RED, "");
    }
}
