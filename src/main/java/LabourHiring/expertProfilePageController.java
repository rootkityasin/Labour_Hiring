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

public class expertProfilePageController {

    @FXML
    private Button BackButton;

    @FXML
    private ChoiceBox<?> cityChoiceBox;

    @FXML
    private ChoiceBox<?> areaChoiceBox1;

    @FXML
    private Button editButton;

    @FXML
    private TextField expertDetailsAddress;

    @FXML
    private TextField expertEmail;

    @FXML
    private TextField expertName;

    @FXML
    private TextField expertPhoneNum;

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
    private TextField zipField;


    @FXML
    void onActionBackButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ExpertWelcomePage.fxml"));
            Parent root1 = fxmlLoader.load();
            BackButton.getScene().setRoot(root1);
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
