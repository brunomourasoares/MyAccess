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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class LoginController implements Initializable {

    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField pfPassword;
    @FXML
    private TextField pfPassword2;
    @FXML
    private Button btShowPassword;
    @FXML
    private ImageView ivShowPassword;
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
    	
        constraints.setTextFieldLettersNumbers(txtUsername);
        constraints.setTextFieldMaxLength(txtUsername, 45);
        constraints.setPasswordFieldLettersNumbers(pfPassword);
        constraints.setPasswordFieldMaxLength(pfPassword, 20);
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
    	
        String username = txtUsername.getText();
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
    
 // ============================= Adapted ===================================

    public void showPasswordPressed() {

        Image img = new Image(LoginController.class.getResourceAsStream("/com/myaccess/gui/eye-slash.png"));
        ivShowPassword.setImage(img);
        pfPassword2.setText(pfPassword.getText());
        pfPassword.setVisible(false);
        pfPassword2.setVisible(true);
    }

    public void showPasswordReleased() {

        Image img = new Image(LoginController.class.getResourceAsStream("/com/myaccess/gui/eye.png"));
        ivShowPassword.setImage(img);
        pfPassword.setText(pfPassword2.getText());
        pfPassword2.setVisible(false);
        pfPassword.setVisible(true);
    }
}