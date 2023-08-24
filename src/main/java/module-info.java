module com.example.aoopproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires java.desktop;
    //requires mysql.connector.j;


    opens LabourHiring to javafx.fxml;
    exports LabourHiring;
}