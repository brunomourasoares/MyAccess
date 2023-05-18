package com.myaccess.Util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class IOUtil {

	public boolean deletePhoto(String ssn) {
		
	Path path = Paths.get("src/main/resources/com/myaccess/guest/" + ssn + ".jpg");
		try {
			Files.deleteIfExists(path);
			return true;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
    public ImageView displayImage(String ssn, ImageView ivPhoto) {
    	Image guestImage = new Image(IOUtil.class.getResourceAsStream("/com/myaccess/guest/" + ssn + ".jpg"));
    	ivPhoto.setImage(guestImage);
        return ivPhoto;
    }
    
    public ImageView hideImage(String ssn, ImageView ivPhoto) {
        Image guestImage = new Image(IOUtil.class.getResourceAsStream("/com/myaccess/guest/base.png"));
        ivPhoto.setImage(guestImage);
        return ivPhoto;
    }

	public boolean existFile(String ssn) {
		File file = new File("src/main/resources/com/myaccess/guest/" + ssn + ".jpg");
		if (file.exists()) {
			return true;
		}
		else {
			return false;
		}
	}
}
