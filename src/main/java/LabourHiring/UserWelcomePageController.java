package LabourHiring;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

import java.io.IOException;

public class UserWelcomePageController {
    @FXML
    private Button SearchButton;

    @FXML
    private ChoiceBox<?> choiceBoxLocation;

    @FXML
    private ChoiceBox<?> choiceBoxWorker;

    @FXML
    private Button logoutButton;

    @FXML
    private SplitPane panel1;

    @FXML
    private ImageView profileImage;

    @FXML
    private Circle profilePicCircle;

    @FXML
    private Button userProfileButton;

    @FXML
    private Button chooseArea;

    @FXML
    private Button chooseWorker;



    @FXML
    void onActionInProfileButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("userProfilePage.fxml"));
            Parent root1 = fxmlLoader.load();
           userProfileButton.getScene().setRoot(root1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void onActionLogoutButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("logIn.fxml"));
            Parent root1 = fxmlLoader.load();
            logoutButton.getScene().setRoot(root1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionSearchButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("searchResult.fxml"));
            Parent root1 = fxmlLoader.load();
            SearchButton.getScene().setRoot(root1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void onActionchooseArea(ActionEvent event) {

    }

    @FXML
    void onActionchooseWorker(ActionEvent event) {

    }
}
