package LabourHiring;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

public class userProfilePageController {

    @FXML
    private Button backButton;

    @FXML
    private Button editButton;
    @FXML
    private TextField fullAddress;
    @FXML
    private Button saveButton;

    @FXML
    private Text text1;

    @FXML
    private Text text2;

    @FXML
    private Text text3;

    @FXML
    private Text text4;

    @FXML
    private Text text5;

    @FXML
    private Text text6;

    @FXML
    private TextField useName;

    @FXML
    private TextField userEmail;

    @FXML
    private TextField userPhnNumber;

    @FXML
    private Label outputTextLabel;

    @FXML
    void onActionBackButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserWelcomePage.fxml"));
            Parent root1 = fxmlLoader.load();
            backButton.getScene().setRoot(root1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void onActionEditButton(ActionEvent event) {

    }

    @FXML
    void onActionSaveButton(ActionEvent event) {
        userProfileDB();
    }

    public void userProfileDB() {

        DatabaseConnection connect_project = new DatabaseConnection();
        Connection connect_database = connect_project.getConnection();

        String phone_num = userPhnNumber.getText();

       // if (phone_num.length() == 11) {

            try {
                String insertExpertDB = "SET sql_mode='STRICT_ALL_TABLES'";
                Statement statement = connect_database.createStatement();
                statement.executeUpdate(insertExpertDB);
                insertExpertDB = "INSERT INTO userinfo(name,email,phone,address) VALUES('" + useName.getText() + "','" + userEmail.getText() + "','" + userPhnNumber.getText() + "','" + fullAddress.getText() + "')";
                statement.executeUpdate(insertExpertDB);
                outputTextLabel.setText("Your Profile is Now complete");

            } catch (Exception e) {
                e.printStackTrace();
                outputTextLabel.setText("Invalid Input.Please Fill all Requirements");
            }

       // }else {
       //     outputTextLabel.setText("Phone number should 11 digits.");
        // }
    }

}
