package LabourHiring;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class searchResultController {

    @FXML
    private Label lable1;
    @FXML
    private Button messagingButton;
    @FXML
    private Button backButton;

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
    void onActionMessagingButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Parent root1 = fxmlLoader.load();
            messagingButton.getScene().setRoot(root1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
