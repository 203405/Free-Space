module com.example.freespace {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.freespace to javafx.fxml;
    exports com.example.freespace;
    exports com.example.freespace.controllers;
    opens com.example.freespace.controllers to javafx.fxml;
}