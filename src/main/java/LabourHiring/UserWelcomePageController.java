package LabourHiring;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public class UserWelcomePageController {
    @FXML
    private Button SearchButton;

    @FXML
    private ChoiceBox<?> choiceBoxLocation;

    @FXML
    private ChoiceBox<?> choiceBoxWorker;

    @FXML
    private TextField chooseArea;

    @FXML
    private TextField chooseWorker;

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
    void onActionInProfileButton(ActionEvent event) {

    }

    @FXML
    void onActionLogoutButton(ActionEvent event) {

    }

    @FXML
    void onActionSearchButton(ActionEvent event) {

    }
}
