module com.myaccess {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    opens com.myaccess to javafx.fxml;
    opens com.myaccess.Controllers to javafx.fxml;
    requires javafx.graphics;
    requires javafx.swing;

    requires java.sql;
    requires java.desktop;
    
    requires webcam.capture;
   
    exports com.myaccess;

}