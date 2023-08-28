package LabourHiring;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import java.io.IOException;

public class ExpertWelcomePageController {

    @FXML
    private Button expertProfileButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Pane pane;

    @FXML
    private ImageView messageImage;

    @FXML
    private ImageView profileImage;

    @FXML
    private Circle profilePicCircle;

    @FXML
    private Button messaging;
    @FXML
    private ImageView backgroundimage;


    void profileDetailsPage() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("expertProfilePage.fxml"));
            Parent root1 = fxmlLoader.load();
            expertProfileButton.getScene().setRoot(root1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void onActionInProfileButton(ActionEvent event) {
            profileDetailsPage();
    }


    @FXML
    void onActionLogout(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("logIn.fxml"));
            Parent root1 = fxmlLoader.load();
            logoutButton.getScene().setRoot(root1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void onActionMessaging(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ExpertiseChatScene.fxml"));
            Parent root1 = fxmlLoader.load();
            messaging.getScene().setRoot(root1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
