package org.example.regexjavadoc;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.regex.Pattern;

public class RegistrationFormUI extends Application {

    private TextField firstNameField, lastNameField, emailField, dobField, zipField;
    private Label statusLabel;
    private Button addButton;

    private boolean[] valid = new boolean[5]; // Tracks validity of all fields

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("User Registration");

        GridPane formGrid = new GridPane();
        formGrid.setAlignment(Pos.CENTER);
        formGrid.setPadding(new Insets(20));
        formGrid.setHgap(10);
        formGrid.setVgap(12);
        formGrid.setStyle("-fx-background-color: #f4f4f4;");

        Label title = new Label("Registration Form");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // First Name
        Label fnLabel = new Label("First Name:");
        firstNameField = new TextField();
        firstNameField.setPromptText("e.g., John");
        validateField(firstNameField, "^[a-zA-Z]{2,25}$", 0);

        // Last Name
        Label lnLabel = new Label("Last Name:");
        lastNameField = new TextField();
        lastNameField.setPromptText("e.g., Smith");
        validateField(lastNameField, "^[a-zA-Z]{2,25}$", 1);

        // Email
        Label emailLabel = new Label("Email:");
        emailField = new TextField();
        emailField.setPromptText("e.g., user@farmingdale.edu");
        validateField(emailField, "^[a-zA-Z0-9._%+-]+@farmingdale\\.edu$", 2);

        // Date of Birth
        Label dobLabel = new Label("Date of Birth:");
        dobField = new TextField();
        dobField.setPromptText("MM/DD/YYYY");
        validateField(dobField, "^(0[1-9]|1[0-2])/([0-2][0-9]|3[01])/\\d{4}$", 3);

        // Zip Code
        Label zipLabel = new Label("Zip Code:");
        zipField = new TextField();
        zipField.setPromptText("5-digit ZIP");
        validateField(zipField, "^\\d{5}$", 4);

        // Add Button
        addButton = new Button("Add");
        addButton.setDisable(true);
        addButton.setOnAction(e -> showSuccessScreen());

        // Status Label
        statusLabel = new Label();
        statusLabel.setTextFill(Color.RED);

        // Layout positions
        formGrid.add(title, 0, 0, 2, 1);
        formGrid.add(fnLabel, 0, 1); formGrid.add(firstNameField, 1, 1);
        formGrid.add(lnLabel, 0, 2); formGrid.add(lastNameField, 1, 2);
        formGrid.add(emailLabel, 0, 3); formGrid.add(emailField, 1, 3);
        formGrid.add(dobLabel, 0, 4); formGrid.add(dobField, 1, 4);
        formGrid.add(zipLabel, 0, 5); formGrid.add(zipField, 1, 5);
        formGrid.add(statusLabel, 0, 6, 2, 1);
        formGrid.add(addButton, 1, 7);

        Scene scene = new Scene(formGrid, 420, 450);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Adds focus-based validation to a field using regex.
     * @param field TextField to validate
     * @param regex Validation pattern
     * @param index Position in valid[] to track this field's status
     */
    private void validateField(TextField field, String regex, int index) {
        field.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal) {
                boolean isValid = Pattern.matches(regex, field.getText());
                valid[index] = isValid;
                if (!isValid) {
                    statusLabel.setText("Invalid input in: " + field.getPromptText());
                } else {
                    statusLabel.setText("");
                }
                updateButtonState();
            }
        });
    }

    /** Enables the button only if all fields are valid */
    private void updateButtonState() {
        addButton.setDisable(!(valid[0] && valid[1] && valid[2] && valid[3] && valid[4]));
    }

    /** Opens a success screen after clicking the Add button */
    private void showSuccessScreen() {
        Label success = new Label("Registration Successful!");
        success.setStyle("-fx-font-size: 16px; -fx-text-fill: green;");
        VBox layout = new VBox(success);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(30));
        Stage successStage = new Stage();
        successStage.setTitle("Success");
        successStage.setScene(new Scene(layout, 300, 100));
        successStage.show();
    }
}
