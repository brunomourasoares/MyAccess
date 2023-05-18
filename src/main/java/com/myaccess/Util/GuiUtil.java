package com.myaccess.Util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class GuiUtil {
    
	public Label setLblError(Label lblErrors, Color color, String text) {
		lblErrors.setTextFill(color);
        lblErrors.setText(text);
        lblErrors.setStyle("-fx-font-weight: bold");
        return lblErrors;
    }

    public Label initClock(Label lblTime) {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> { 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        lblTime.setText(LocalDateTime.now().format(formatter));
	}
	), new KeyFrame(Duration.seconds(0.8)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
        return lblTime;
    }
}
