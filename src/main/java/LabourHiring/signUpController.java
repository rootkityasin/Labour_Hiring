package LabourHiring;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class signUpController implements Initializable {

    @FXML
    private Button backButton;

    @FXML
    private ImageView backgroundPicture;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private Label createAccountLabel;

    @FXML
    private Button signUpButton;

    @FXML
    private ImageView signUpLogo;

    @FXML
    private ImageView userEmailLogo;

    @FXML
    private TextField userEmailTextfield;

    @FXML
    private ImageView userNameLogo;

    @FXML
    private TextField userNameTextfield;

    @FXML
    private ImageView userPassLogo;

    @FXML
    private TextField userPassTextfield;

    @FXML
    private Label welcomeMessageLable;

    @FXML
    private Label signUpLabel;

    private String[] items = {"Admin", "Expertise", "User"};

    @FXML
    void onActionNameField(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            userEmailTextfield.requestFocus();
        }

    }

    public void onActionPassField(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            signUpButton.requestFocus();
        }

    }

    public void onActionEmailField(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            userPassTextfield.requestFocus();
        }
    }

    @FXML
    void onActionBackButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("logIn.fxml"));
            Parent root1 = fxmlLoader.load();
            backButton.getScene().setRoot(root1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        choiceBox.getItems().addAll(items);

    }

    @FXML
    void onActionsignUp(ActionEvent event) {

        signUpDB();
    }

    public void signUpDB() {

        //connecting DB using DatabaseConnection class
        DatabaseConnection connect_project = new DatabaseConnection();
        Connection connect_database = connect_project.getConnection();


        String insertDB="SET sql_mode='STRICT_ALL_TABLES'";
        if (choiceBox.getValue().equals("Admin")){

            insertDB = "INSERT INTO Admin(name,email,password) VALUES('" + userNameTextfield.getText() + "','" + userEmailTextfield.getText() + "','" + userPassTextfield.getText() + "')";

        } else if (choiceBox.getValue().equals("Worker")) {
             insertDB = "INSERT INTO worker(name,email,password) VALUES('" + userNameTextfield.getText() + "','" + userEmailTextfield.getText() + "','" + userPassTextfield.getText() + "')";

        }
        else if(choiceBox.getValue().equals("User")){
            insertDB = "INSERT INTO user(name,email,password) VALUES('" + userNameTextfield.getText() + "','" + userEmailTextfield.getText() + "','" + userPassTextfield.getText() + "')";
        }
        else{
            signUpLabel.setText("Please Choose a Category");
        }


        try {

            Statement statement = connect_database.createStatement();
            statement.executeUpdate(insertDB);

            signUpLabel.setText("Register Successful");

        } catch (Exception e) {
            e.printStackTrace();
            signUpLabel.setText("Invalid Input");
        }

    }
}






