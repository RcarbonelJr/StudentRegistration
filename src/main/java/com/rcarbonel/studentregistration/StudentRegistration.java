/* Author: Randall Carbonel
 * Date: 7/27/24
 * Class: ASD216 - Java Programming
 * Assignment: Create a GUI application that accepts student registration data.
 * Specifications:
 *      - Use JavaFX to create the GUI.
 *      - The text box that displays the temporary password should be read-only.
 *      - The temporary password consists of the user’s first name, an asterisk (*), and the user’s birth year.
 *      - If the user enters data in the first three fields, display a temporary password in the appropriate text field
 *        and a welcome message in the label below the text fields.
 *      - If the user does not enter data, clear the temporary password from the text field, and display an error
 *        message in the label below the text fields.
 */

package com.rcarbonel.studentregistration;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentRegistration extends Application {

    private TextField fName;
    private TextField lName;
    private TextField birthYear;
    private TextField password;
    private Label msg;

    @Override
    public void start(Stage stage) {

        stage.setTitle("Student Registration");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setHgap(10);
        grid.setVgap(10);

        Scene scene = new Scene(grid);

        grid.add(new Label("First Name:"), 0, 0);
        fName = new TextField();
        grid.add(fName, 1, 0);

        grid.add(new Label("Last Name:"), 0, 1);
        lName = new TextField();
        grid.add(lName, 1, 1);

        grid.add(new Label("Year of Birth:"), 0, 2);
        birthYear = new TextField();
        grid.add(birthYear, 1, 2);

        grid.add(new Label("Temporary Password:"), 0, 3);
        password = new TextField();
        password.setEditable(false);
        grid.add(password, 1, 3);

        msg = new Label();
        grid.add(msg, 0, 4, 2, 1);

        Button registerButton = new Button("Register");
        registerButton.setOnAction(
                event -> registerButtonClicked());

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(
                event -> exitButtonClicked());


        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().add(registerButton);
        buttonBox.getChildren().add(exitButton);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        grid.add(buttonBox, 0, 5, 2, 1);

        stage.setScene(scene);
        stage.show();
    }

    private void registerButtonClicked() {
        String firstName = fName.getText().trim();
        String lastName = lName.getText().trim();
        String birthYearStr = birthYear.getText().trim();
        int yearOfBirth = 0;

        // Validate input
        if (firstName.isEmpty() || lastName.isEmpty() || birthYearStr.isEmpty()) {
            msg.setText("Please enter first name, last name, and year of birth.");
            return;
        }

        String tempPassword = firstName + "*" + birthYearStr;
        password.setText(tempPassword);

        msg.setText("Welcome " + firstName + " " + lastName + "!");
    }

    private void exitButtonClicked() {
        System.exit(0);
    }

    public static void main(String[] args) {
        launch();
    }
}