package LabourHiring;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.jar.Attributes;

public class searchResultController implements  Initializable {


    @FXML
    private Label lable1;
    @FXML
    private Button messagingButton;
    @FXML
    private Button backButton;
    @FXML
    private TableView<?> myTable;

    @FXML
    private VBox vBox1;


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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserChatScene.fxml"));
            Parent root1 = fxmlLoader.load();
            messagingButton.getScene().setRoot(root1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TableColumn name = new TableColumn("Name");
        TableColumn num = new TableColumn("Mobile Number");
        TableColumn email = new TableColumn("E-mail");
        TableColumn click = new TableColumn("Click Here");

        myTable.getColumns().addAll(name,num,email,click);

    }
}
