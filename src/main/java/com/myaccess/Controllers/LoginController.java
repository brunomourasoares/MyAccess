package com.myaccess.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.myaccess.App;
import com.myaccess.Repositories.UserDAO;
import com.myaccess.Util.Constraints;
import com.myaccess.Util.GuiUtil;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class LoginController implements Initializable {

    @FXML
    private TextField txtLogin;
    @FXML
    private PasswordField pfPassword;
    @FXML
    private Button btShowPassword;
    @FXML
    private Button btLogin;
    @FXML
    private Button btForgot;
    @FXML
    private Label lblErrors;
    
    UserDAO userDAO = new UserDAO();
    GuiUtil guiUtil = new GuiUtil();
    Constraints constraints = new Constraints();
    
 // ========================================================================

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
        constraints.setTextFieldLettersNumbers(txtLogin);
        constraints.setTextFieldMaxLength(txtLogin, 15);
        constraints.setPasswordFieldLettersNumbers(pfPassword);
        constraints.setPasswordFieldMaxLength(pfPassword, 15);
    }

    @FXML
    private void loginButtonMouseClick(MouseEvent event) {
    	
        if (event.getSource() == btLogin) {
            loginCheck();
        }
    }

    @FXML
    private void passwordEnterKeyPressing(KeyEvent event) {
    	
        if (event.getCode() == KeyCode.ENTER) {
            loginCheck();
        }
    }

    @FXML
    private void forgotButtonMouseClick(MouseEvent event) {
    	
        if (event.getSource() == btForgot) {
            try {
                App.setRoot("ForgotPassword");
            }
            catch (IOException e) {
            	e.printStackTrace();
            }
        }
    }

    private void loginCheck() {
    	
        String username = txtLogin.getText();
        String password = pfPassword.getText();
        
        if (username.isEmpty()) {
        	guiUtil.setLblError(lblErrors, Color.RED, "Username: is blank!");
        }
        else if (password.isEmpty()) {
        	guiUtil.setLblError(lblErrors, Color.RED, "Password: is blank!");
        }
        else if (userDAO.findBlockedUserStatusByName(username) == true) {
        	guiUtil.setLblError(lblErrors, Color.RED, "User is blocked!");
        }
        else if (userDAO.findLogin(username, password) == false) {
        	guiUtil.setLblError(lblErrors, Color.RED, "Incorrect username or password");
        }
        else {
        	userDAO.setLoggedStatus(true, username);
        	guiUtil.setLblError(lblErrors, Color.GREEN, "Login successfully!");
            try {
                App.setRoot("Register");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
 // ======================= ADAPTADO ============================
    
    private String backup = new String();
    private void copyPass() {
        backup = pfPassword.getText();
    }
    
    public void showPasswordPressed() {
        copyPass();
        pfPassword.setPromptText(pfPassword.getText());
        pfPassword.setText("");
    }

    public void showPasswordReleased() {
        pfPassword.setText(backup);
        pfPassword.setPromptText("Password:");
    }
}