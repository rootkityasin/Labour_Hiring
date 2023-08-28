package LabourHiring;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import java.io.IOException;

public class adminWelcomePageController {

    @FXML
    private Button LOgoutButton;

    @FXML
    private Pane pane;

    @FXML
    private Button adminProfileButton;

    @FXML
    private ImageView adminProfileImage;

    @FXML
    private Circle adminprofile;

    @FXML
    private Button databaseButton;

    @FXML
    private ImageView databaseLabelImage;

    @FXML
    private Label manageDatabaseLabel;

    @FXML
    void OnActionLogoutButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("logIn.fxml"));
            Parent root1 = fxmlLoader.load();
            LOgoutButton.getScene().setRoot(root1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void onActionAdminProfileButton(ActionEvent event) {

    }

    @FXML
    void onActionDatabaseButton(ActionEvent event) {

    }

}
