package LabourHiring;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class userProfilePageController {

    @FXML
    private Button backButton;

    @FXML
    private Button editButton;
    @FXML
    private Button chooseArea;

    @FXML
    private Button chooseWorker;
    @FXML
    private TextField fullAddress;

    @FXML
    private ChoiceBox<?> locationChoose;

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
    private TextField zipCode;

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

    }

}
