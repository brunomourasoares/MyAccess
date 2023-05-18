package com.myaccess;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

	private static Scene scene;
	public final String title = "MyAccess";

	@Override
	public void start(Stage stage) throws IOException {
		scene = new Scene(loadFXML("Login"));
		stage.setTitle(title);
		stage.getIcons().add(new Image(App.class.getResourceAsStream("/com/myaccess/gui/security.png")));
		stage.setScene(scene);
		//stage.setMaximized(true);
		stage.show();

		stage.setOnCloseRequest(event -> {
			event.consume();
			logout(stage);
		});
	}

	public static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(fxml));
	}

	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}

	public void logout(Stage stage) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(title);
		alert.setHeaderText("Exiting...");
		alert.setContentText("Do you want close program?");
		//alert.initStyle(StageStyle.UNDECORATED);

		if (alert.showAndWait().get() == ButtonType.OK) {
			System.out.println("You successfully exit!");
			stage.close();
		}
	}
	
	public static void main(String[] args) {
		launch();
	}
}