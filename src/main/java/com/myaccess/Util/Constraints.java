package com.myaccess.Util;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Constraints {
    
	// textfield somente Integer
	public void setTextFieldInteger(TextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && !newValue.matches("\\d*")) {
				txt.setText(oldValue);
			}
		});
	}

	// textfield somente Double
	public void setTextFieldDouble(TextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && !newValue.matches("\\d*([\\.]\\d*)?")) {
				txt.setText(oldValue);
			}
		});
	}

	// textfield somente letras
	public void setTextFieldOnlyLetters(TextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && !newValue.matches("^[a-zA-Z ]*$")) {
				txt.setText(oldValue);
			}
		});
	}

	// textfield somente numeros
	public void setTextFieldOnlyNumbers(TextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && !newValue.matches("^[0-9]*$")) {
				txt.setText(oldValue);
			}
		});
	}

	// textfield somente letras e numeros
	public void setTextFieldLettersNumbers(TextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && !newValue.matches("^[a-zA-Z0-9]*$")) {
				txt.setText(oldValue);
			}
		});
	}
	
	// textfield somente letras e numeros
	public void setTextFieldLettersNumbersEtc(TextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && !newValue.matches("^[a-zA-Z0-9 ]*$")) {
				txt.setText(oldValue);
			}
		});
	}

	// textfield maximo de caracteres
	public void setTextFieldMaxLength(TextField txt, int max) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && newValue.length() > max) {
				txt.setText(oldValue);
			}
		});
	}
	
	// textfield maximo de caracteres
	public void setTextAreaMaxLength(TextArea txt, int max) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && newValue.length() > max) {
				txt.setText(oldValue);
			}
		});
	}

	// passwordfield maximo de caracteres
	public void setPasswordFieldMaxLength(PasswordField txt, int max) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && newValue.length() > max) {
				txt.setText(oldValue);
			}
		});
	}

	// passwordfield somente letras e numeros
	public void setPasswordFieldLettersNumbers(PasswordField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && !newValue.matches("^[a-zA-Z0-9]*$")) {
				txt.setText(oldValue);
			}
		});
	}
}