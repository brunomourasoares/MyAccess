module com.myaccess {
    requires transitive javafx.base;
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    requires transitive javafx.graphics;
    requires transitive javafx.swing;
    requires transitive java.sql;
    requires transitive java.desktop;
    requires transitive webcam.capture;

    opens com.myaccess to javafx.fxml;
    opens com.myaccess.Controllers to javafx.fxml;

    exports com.myaccess;
    exports com.myaccess.Controllers;
    exports com.myaccess.Models;
    exports com.myaccess.Repositories;
    exports com.myaccess.Util;
}