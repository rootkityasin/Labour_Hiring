package LabourHiring;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import java.sql.Connection;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

public class loginController {

    @FXML
    private Button CancelButton;

    @FXML
    private Button SignUp;

    @FXML
    private TextField UserPassword;

    @FXML
    private ImageView emailIcon;

    @FXML
    private Button login;

    @FXML
    private ImageView passIcon;

    @FXML
    private TextField userEmail;

    @FXML
    private Label message_label;

    @FXML
    private RadioButton adminRadioButton;

    @FXML
    private RadioButton userRadioButton;

    @FXML
    private RadioButton workerRadioButton;

    @FXML
    private RadioButton invisibleRadioButton;

    @FXML
    private Label loginLabelSelectInterface;



    public void onActionPassText(KeyEvent event) {

        if (event.getCode().equals(KeyCode.ENTER)){
            UserPassword.requestFocus();
        }
    }

    public void onActionEmailText(KeyEvent event) {

        if (event.getCode().equals(KeyCode.ENTER)){
            login.requestFocus();
        }
    }



    @FXML
    void OnActionButton(ActionEvent event) {
        userEmail.setText("");
        UserPassword.setText("");
        invisibleRadioButton.setSelected(true);

    }

    @FXML
    void onActionLoginButton(ActionEvent event) {

        //checking if email/password field is empty
        if (!userEmail.getText().isBlank() && !UserPassword.getText().isBlank()) {

            validate_login();
        } else {
            message_label.setText("Enter Username and Password");
        }


    }
    @FXML
    void onActionchooseInterface(ActionEvent event) {

    }


    //To check name+pass match
    public void validate_login() {

        //connecting DB using DatabaseConnection class
        DatabaseConnection connect_project = new DatabaseConnection();
        Connection connect_database = connect_project.getConnection();

        String check="SET sql_mode='STRICT_ALL_TABLES'";

        if (adminRadioButton.isSelected()){
            check = "SELECT count(1) FROM Admin WHERE email='" + userEmail.getText() + "' AND password='" + UserPassword.getText() + "'";
        }
        else if(userRadioButton.isSelected()){
             check = "SELECT count(1) FROM user WHERE email='" + userEmail.getText() + "' AND password='" + UserPassword.getText() + "'";
        }

        else if(workerRadioButton.isSelected()){
            check = "SELECT count(1) FROM worker WHERE email='" + userEmail.getText() + "' AND password='" + UserPassword.getText() + "'";
        }

        else {
            message_label.setText("Please Choose a Category First");
        }

        try {

            Statement statement = connect_database.createStatement();
            ResultSet queryResult = statement.executeQuery(check);

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    message_label.setText("Welcome!");
                } else {
                    message_label.setText("Wrong Username or Password. Please try again.");
                }

            }
        }catch(Exception e){
                    e.printStackTrace();
                }

            }


            @FXML
            void onActionSignupButton (ActionEvent event){
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("signUp.fxml"));
                    Parent root2 = fxmlLoader.load();
                    SignUp.getScene().setRoot(root2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }



}