package LabourHiring;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

import java.io.IOException;

public class ExpertWelcomePageController {

    @FXML
    private Button expertProfileButton;

    @FXML
    private Button logoutButton;

    @FXML
    private SplitPane panel1;

    @FXML
    private ImageView profileImage;

    @FXML
    private Circle profilePicCircle;

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

    void blackLoginPage() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("logIn.fxml"));
            Parent root1 = fxmlLoader.load();
            logoutButton.getScene().setRoot(root1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void onActionLogout(ActionEvent event) {
            blackLoginPage();
    }

}
