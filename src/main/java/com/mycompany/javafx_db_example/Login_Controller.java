package com.mycompany.javafx_db_example;


import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Login_Controller extends Application{

    @FXML
    private TextField txtUserName;

    @FXML
    private TextField visiblePasswordField;

    @FXML
    private PasswordField hiddenPasswordField;

    @FXML
    private Button btnToggleTheme;
    private boolean isDarkTheme = false;

    private static Scene scene;
    private static Stage primaryStage;

    @FXML
    private Button btnTogglePassword;
    private boolean passwordVisible = false;


    /**
     * sets up the primary stage
     */
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setResizable(false);
        showScene1();
    }

    /**
     * loads the splash screen, with the animation
     */
    private void showScene1() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("splash_screen.fxml"));
            scene = new Scene(root, 850, 560);
            scene.getStylesheets().add("style.css");
            primaryStage.setScene(scene);
            primaryStage.show();
            changeScene();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * change scene after the animation to the login screen
     */
    public void changeScene() {
        try {
            Parent newRoot = FXMLLoader.load(getClass().getResource("login.fxml"));
            //"db_interface_gui.fxml"));

            Scene currentScene = primaryStage.getScene();
            Parent currentRoot = currentScene.getRoot();
            currentScene.getStylesheets().add("style.css");
            FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), currentRoot);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);
            fadeOut.setOnFinished(e -> {


                Scene newScene = new Scene(newRoot,550, 460);
                primaryStage.setScene(newScene);

            });

            fadeOut.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * after login button clicked db interface page is displayed
     */
    @FXML
    public void change() {
        try {
            Parent newRoot = FXMLLoader.load(getClass().getResource("db_interface_gui.fxml"));

            Scene currentScene = primaryStage.getScene();
            Parent currentRoot = currentScene.getRoot();
            currentScene.getStylesheets().add("style.css");


            Scene newScene = new Scene(newRoot,850, 560);
            primaryStage.setScene(newScene);




        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * this method allows for when button is clicked password will ve visible or not visible
     */
    @FXML
    private void togglePasswordVisibility()
    {
        if (passwordVisible) {
            hiddenPasswordField.setVisible(false);
            hiddenPasswordField.setManaged(false);
            visiblePasswordField.setVisible(true);
            visiblePasswordField.setManaged(true);
            btnTogglePassword.setText("Hide");
            // Copy the text from hiddenPasswordField to visiblePasswordField
            visiblePasswordField.setText(hiddenPasswordField.getText());

        } else {

            visiblePasswordField.setVisible(false);
            visiblePasswordField.setManaged(false);
            hiddenPasswordField.setVisible(true);
            hiddenPasswordField.setManaged(true);
            btnTogglePassword.setText("Show");
            // Copy the text from visiblePasswordField to hiddenPasswordField
            hiddenPasswordField.setText(visiblePasswordField.getText());


        }

        passwordVisible = !passwordVisible;
    }

    public void toggleTheme() {
        // Get the current scene and its root node (in this case, the AnchorPane)
        Scene scene = btnToggleTheme.getScene();
        Parent root = scene.getRoot();

        // Toggle between light and dark themes
        if (isDarkTheme) {
            // Apply the light theme stylesheet
            scene.getStylesheets().remove("loginDark.css");
            scene.getStylesheets().add("login.css");
        } else {
            // Apply the dark theme stylesheet
            scene.getStylesheets().remove("login.css");
            scene.getStylesheets().add("loginDark.css");
        }

        // Update the theme state
        isDarkTheme = !isDarkTheme;

        if (isDarkTheme) {
            // Apply dark theme styles
            root.getStyleClass().remove("left_pane-light");
            root.getStyleClass().add("left_pane-dark");

        } else {
            // Apply light theme styles
            root.getStyleClass().remove("left_pane-dark");
            root.getStyleClass().add("left_pane-light");

        }
    }

        /**
         * main method that lauches the program
         */
        public static void main (String[]args)
        {
            launch();
        }

    }
