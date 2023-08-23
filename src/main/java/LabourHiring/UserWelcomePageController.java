package LabourHiring;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserWelcomePageController implements Initializable {
    @FXML
    private Button SearchButton;
    @FXML
    private ImageView bacgroundImage;

    @FXML
    private ChoiceBox<String> choiceBoxLocation;

    @FXML
    private Button logoutButton;
    @FXML
    private RadioButton radiobuttonCarpenter;

    @FXML
    private RadioButton radiobuttonElectrician;

    @FXML
    private RadioButton radiobuttonGardener;

    @FXML
    private RadioButton radiobuttonMechanic;

    @FXML
    private RadioButton radiobuttonPainter;

    @FXML
    private SplitPane panel1;

    @FXML
    private ImageView profileImage;

    @FXML
    private Circle profilePicCircle;

    @FXML
    private Button userProfileButton;

    @FXML
    private Label chooseArea;

    @FXML
    private Label chooseWorker;

    private final String[] area_names = {"Tejgaon", "Notunbazar", "Badda"};


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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBoxLocation.getItems().addAll(area_names);

    }
}
