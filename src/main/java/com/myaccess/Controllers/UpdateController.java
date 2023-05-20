package com.myaccess.Controllers;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;
import com.myaccess.App;
import com.myaccess.Models.Guest;
import com.myaccess.Repositories.UserDAO;
import com.myaccess.Util.Constraints;
import com.myaccess.Util.GuiUtil;
import com.myaccess.Util.IOUtil;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class UpdateController implements Initializable {

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
    private Button btSearch;
    @FXML
    private TextField txtSSN;
    @FXML
    private TextField txtFullName;
    @FXML
    private ComboBox<String> cbGender;
    @FXML
    private TextField txtContactNumber;
    @FXML
    private TextField txtCompanyName;
    @FXML
    private TextArea txaObservation;
    @FXML
    private ImageView ivWebcam = new ImageView();
    @FXML
    private ImageView ivWebcam2;
    @FXML
    private Button btOpenWebcam;
    @FXML
    private Button btSavePhoto;
    @FXML
    private Button btLogout;
    @FXML
    private Label lblTime;
    @FXML
    private Button btClear;
    @FXML
    private Label lblErrors;
    @FXML
    private ToggleButton tbBlock;
    @FXML
    private Button btUpdate;
    @FXML
    private Button btRegister;
    @FXML
    private Button btUpdt;
    @FXML
    private Button btDelete;
    @FXML
    private Button btEntry;
    @FXML
    private Button btExit;
    
    Constraints constraints = new Constraints();
    GuiUtil guiUtil = new GuiUtil();
    UserDAO userDAO = new UserDAO();
    IOUtil ioUtil = new IOUtil();

    private ObservableList<String> obsList;
    
    private Webcam webCam = null;
	private boolean stopCamera = false;
    private BufferedImage grabbedImage;
	ObjectProperty<Image> imageProperty = new SimpleObjectProperty<Image>();

 // ========================================================================
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
    	constraints.setTextFieldOnlyNumbers(txtSSN);
    	constraints.setTextFieldMaxLength(txtSSN, 11);
        constraints.setTextFieldOnlyLetters(txtFullName);
        constraints.setTextFieldMaxLength(txtFullName, 60);
        constraints.setTextFieldOnlyNumbers(txtContactNumber);
        constraints.setTextFieldMaxLength(txtContactNumber, 11);
        constraints.setTextFieldLettersNumbersEtc(txtCompanyName);
        constraints.setTextFieldMaxLength(txtCompanyName, 60);
        constraints.setTextAreaMaxLength(txaObservation, 500);

        btHome.setDisable(true);
        btUpdt.setDisable(true);
        txtFullName.setDisable(true);
        cbGender.setDisable(true);
        txtContactNumber.setDisable(true);
        txtCompanyName.setDisable(true);
        txaObservation.setDisable(true);
        tbBlock.setDisable(true);
        btOpenWebcam.setDisable(true);
        btSavePhoto.setDisable(true);
        btUpdate.setDisable(true);
        btClear.setDisable(true);

        List<String> list = new ArrayList<>();
        list.add("Choose a gender (Required)");
        list.add("Man");
        list.add("Woman");
        list.add("Other");

        obsList = FXCollections.observableArrayList(list);
        cbGender.setItems(obsList);
        cbGender.getSelectionModel().clearSelection();

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
            ioUtil.protectUnknownPhoto(txtSSN);
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
            ioUtil.protectUnknownPhoto(txtSSN);
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
            ioUtil.protectUnknownPhoto(txtSSN);
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
            ioUtil.protectUnknownPhoto(txtSSN);
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
            ioUtil.protectUnknownPhoto(txtSSN);
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
            ioUtil.protectUnknownPhoto(txtSSN);
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
            ioUtil.protectUnknownPhoto(txtSSN);
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
            ioUtil.protectUnknownPhoto(txtSSN);
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
            ioUtil.protectUnknownPhoto(txtSSN);
        }
    }
    
    @FXML
    private void updateButtonMouseClick(MouseEvent event) {
    	
        if (event.getSource() == btUpdate) {
        	setUpdateGuest();
        }
    }
    
    @FXML
    private void searchButtonMouseClick(MouseEvent event) {
    	
    	if (event.getSource() == btSearch) {
    		getUpdateGuest();
    	}
    }
    
    @FXML
    private void ssnEnterKeyPressing(KeyEvent event) {
    	
        if (event.getCode() == KeyCode.ENTER) {
    		getUpdateGuest();
        }
    }
    
    @FXML
    private void openWebcamButtonMouseClick(MouseEvent event) {
    	
        if (event.getSource() == btOpenWebcam) {
                startWebCamCamera();
        }
    }
    
    @FXML
    private void savePhotoButtonMouseClick(MouseEvent event) {
    	
        if (event.getSource() == btSavePhoto) {
        	stopWebCamCamera();
        	try {
				ImageIO.write(grabbedImage, "JPG", new File("src/main/resources/com/myaccess/guest/" + txtSSN.getText() + ".jpg"));
			}
        	catch (IOException e) {
				e.printStackTrace();
			}
        }
    }
    
    @FXML
    private void clearButtonMouseClick(MouseEvent event) {
    	
        if (event.getSource() == btClear) {
        	clearFields();
    	}
    }
    
    private void getUpdateGuest() {
      	
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
	        cbGender.setDisable(false);
	        txtContactNumber.setDisable(false);
	        txtCompanyName.setDisable(false);
	        txaObservation.setDisable(false);
	        tbBlock.setDisable(false);
            btOpenWebcam.setDisable(false);
	        btSavePhoto.setDisable(false);
	        btUpdate.setDisable(false);
	        btClear.setDisable(false);
	        ivWebcam2.setVisible(true);
	        
		    Guest guest = userDAO.getGuestBySSN(txtSSN.getText());
		    txtFullName.setText(guest.getFullName());
		    cbGender.getSelectionModel().select(guest.getGender());
		    txtContactNumber.setText(guest.getContactNumber());
		    txtCompanyName.setText(guest.getCompanyName());
		    txaObservation.setText(guest.getObservations());
            tbBlock.setSelected(guest.getBlocked());
            initializeWebCam();
	        ioUtil.displayImage(txtSSN.getText(), ivWebcam2);
		    guiUtil.setLblError(lblErrors, Color.RED, "");
	    }
    }
    
    private void setUpdateGuest() {

	    String ssn = txtSSN.getText();
	    String fullname = txtFullName.getText();
	    String gender = cbGender.getSelectionModel().getSelectedItem();
	    String contactNumber = txtContactNumber.getText();
	    String companyName = txtCompanyName.getText();
	    String observation = txaObservation.getText();
	    Boolean block = tbBlock.isSelected();
	    
	    if(fullname.isEmpty()) {
	    	guiUtil.setLblError(lblErrors, Color.RED, "Full name: is blank!");
	    }
	    else if (gender == null || gender == "Choose a gender (Required)") {
	    	guiUtil.setLblError(lblErrors, Color.RED, "Gender: select the gender!");
	    }
	    else if (contactNumber.isEmpty()) {
	    	guiUtil.setLblError(lblErrors, Color.RED, "Contact number: is blank!");
	    }
	    else if (contactNumber.length() < 8) {
	    	guiUtil.setLblError(lblErrors, Color.RED, "Contact number: 8 at least!");
	    }
	    else if (ioUtil.existFile(ssn) == false) {
	    	guiUtil.setLblError(lblErrors, Color.RED, "Photo: you need save photo!");
	    }
	    else {
	    	Guest guest = userDAO.getGuestBySSN(ssn);
	    	Timestamp date = guest.getCreateDate();
	    	Guest updatedGuest = new Guest(null, ssn, fullname, gender, contactNumber, companyName, date, observation, block);    	
	    	userDAO.updateGuest(updatedGuest);
	    	clearFields();
	    	guiUtil.setLblError(lblErrors, Color.GREEN, "Guest has been UPDATED!");
	    }
    }
    
    private void clearFields() {
    	
		btSearch.setDisable(false);
		txtSSN.setEditable(true);
        txtFullName.setDisable(true);
        cbGender.setDisable(true);
        txtContactNumber.setDisable(true);
        txtCompanyName.setDisable(true);
        txaObservation.setDisable(true);
        tbBlock.setSelected(false);
        ivWebcam.setVisible(false);
        ivWebcam2.setVisible(false);
        btOpenWebcam.setDisable(true);
        btSavePhoto.setDisable(true);
        tbBlock.setDisable(true);
        btUpdate.setDisable(true);
        btClear.setDisable(true);
    	txtSSN.setText("");
    	txtFullName.setText("");
    	cbGender.getSelectionModel().clearSelection();
    	txtContactNumber.setText("");
    	txtCompanyName.setText("");
    	txaObservation.setText("");
    	guiUtil.setLblError(lblErrors, Color.RED, "");
    }
    
    private void initializeWebCam() {

		Task<Void> webCamTask = new Task<Void>() {

			@Override
			protected Void call() throws Exception {

				if (webCam != null) {
					webCam = Webcam.getDefault();
                    webCam.setViewSize(new Dimension(640, 480));
					webCam.open();
				}
				else {
					webCam = Webcam.getDefault();
                    webCam.setViewSize(new Dimension(640, 480));
					webCam.open();
				}
				startWebCamStream();
				return null;
			}
		};

		Thread webCamThread = new Thread(webCamTask);
		webCamThread.setDaemon(true);
		webCamThread.start();
		ivWebcam.setVisible(false);
		stopWebCamCamera();
	}
	
	private void startWebCamStream() {

		stopCamera = false;
		Task<Void> task = new Task<Void>() {

			@Override
			protected Void call() throws Exception {

				while (!stopCamera) {
					try {
						if ((grabbedImage = webCam.getImage()) != null) {

							Platform.runLater(new Runnable() {
								@Override
								public void run() {
									final Image mainiamge = SwingFXUtils.toFXImage(grabbedImage, null);
									imageProperty.set(mainiamge);
								}
							});
							
							grabbedImage.flush();
						}
					}
					catch (Exception e) {
					}
					finally {
					}
				}
				return null;
			}
		};
		Thread th = new Thread(task);
		th.setDaemon(true);
		th.start();
		ivWebcam.imageProperty().bind(imageProperty);
	}
    
	private void startWebCamCamera() {
		
		stopCamera = false;
		startWebCamStream();
		ivWebcam.setVisible(true);
		ivWebcam2.setVisible(false);
		btSavePhoto.setDisable(false);
		btOpenWebcam.setDisable(true);
	}

	private void stopWebCamCamera() {
		
		stopCamera = true;
		btOpenWebcam.setDisable(false);
		btSavePhoto.setDisable(true);
	}
}