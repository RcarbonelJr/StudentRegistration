module com.rcarbonel.studentregistration {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.rcarbonel.studentregistration to javafx.fxml;
    exports com.rcarbonel.studentregistration;
}