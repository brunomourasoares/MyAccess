package com.myaccess.Controllers;

import java.io.IOException;

import com.myaccess.App;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ReportsController {

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
    private Button btEntry;
    @FXML
    private Button btExit;
    @FXML
    private Button btGuest;
    @FXML
    private Button btVehicle;
    @FXML
    private Button btCompany;
    @FXML
    private Button btRegister;
    @FXML
    private Button btLogout;
    @FXML
    private Label lblUser;
    
 // ========================================================================

    @FXML
    public void homeButtonMouseClick(MouseEvent event) {
        if (event.getSource() == btHome) {
            try {
            	App.setRoot("Home");
            }
            catch (IOException e) {
            	e.printStackTrace();
            }
        }
    }

    @FXML
    public void optionsButtonMouseClick(MouseEvent event) {
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
    public void supportButtonMouseClick(MouseEvent event) {
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
    public void aboutButtonMouseClick(MouseEvent event) {
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
    public void entryButtonMouseClick(MouseEvent event) {
        if (event.getSource() == btEntry) {
            try {
            	App.setRoot("EntryRep");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void exitButtonMouseClick(MouseEvent event) {
        if (event.getSource() == btExit) {
            try {
            	App.setRoot("ExitRep");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void guestButtonMouseClick(MouseEvent event) {
        if (event.getSource() == btGuest) {
            try {
            	App.setRoot("GuestRep");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void vehicleButtonMouseClick(MouseEvent event) {
        if (event.getSource() == btVehicle) {
            try {
            	App.setRoot("VehicleRep");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void companyButtonMouseClick(MouseEvent event) {
        if (event.getSource() == btCompany) {
            try {
            	App.setRoot("CompanyRep");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void registerButtonMouseClick(MouseEvent event) {
        if (event.getSource() == btRegister) {
            try {
            	App.setRoot("RegisterRep");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void logoutButtonMouseClick(MouseEvent event) {
        if (event.getSource() == btLogout) {
            try {
                App.setRoot("Login");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}