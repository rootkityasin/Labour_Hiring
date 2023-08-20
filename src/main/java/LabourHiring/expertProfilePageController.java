package LabourHiring;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class expertProfilePageController implements Initializable {

    @FXML
    private Button BackButton;

    @FXML
    private ChoiceBox<String> cityChoiceBox;

    @FXML
    private ChoiceBox<String> areaChoiceBox1;

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
    private Label label1;

    @FXML
    private RadioButton radioboxCarpenter;

    @FXML
    private RadioButton radioboxElectrician;

    @FXML
    private RadioButton radioboxGardener;

    @FXML
    private RadioButton radioboxMechanic;

    @FXML
    private RadioButton radioboxPainter;

    @FXML
    private TextField zipField;

    @FXML
    private Label outputTextLabel;

    private final String[] city_names = {"Dhaka", "Barishal", "Noakhali"};
    private final String[] area_names = {"Tejgaon", "Notunbazar", "Badda"};


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


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        cityChoiceBox.getItems().addAll(city_names);
        areaChoiceBox1.getItems().addAll(area_names);
        cityChoiceBox.setOnAction(this::choicebox);

    }

    public void choicebox(ActionEvent event){
       String choosedcity= cityChoiceBox.getValue();
        String choosedarea= cityChoiceBox.getValue();

    }


    @FXML
    void onActionSaveButton(ActionEvent event) {
        expertProfileDB();

    }

    public void expertProfileDB() {

        //connecting DB using DatabaseConnection class
        DatabaseConnection connect_project = new DatabaseConnection();
        Connection connect_database = connect_project.getConnection();



        String phone_num = expertPhoneNum.getText();

      //  if (phone_num.length() == 11) {

            try {
                String worker_category = null;
                if(radioboxCarpenter.isSelected()){
                    worker_category="carpenter";
                } else if (radioboxElectrician.isSelected()) {
                    worker_category="electrician";
                }else if (radioboxGardener.isSelected()) {
                    worker_category="gardener";
                }else if (radioboxMechanic.isSelected()) {
                    worker_category="mechanic";
                }else if (radioboxPainter.isSelected()) {
                    worker_category="painter";
                }
                String insertExpertDB = "SET sql_mode='STRICT_ALL_TABLES'";
                Statement statement = connect_database.createStatement();
                statement.executeUpdate(insertExpertDB);
                insertExpertDB = "INSERT INTO workerinfo(name,email,phone,address,city,area,workercategory) VALUES('" + expertName.getText() + "','" + expertEmail.getText() + "','" + expertPhoneNum.getText() + "','" + expertDetailsAddress.getText() + "','" + cityChoiceBox.getValue() + "','" + areaChoiceBox1.getValue() + "','"+ worker_category +"')";
                statement.executeUpdate(insertExpertDB);
                outputTextLabel.setText("Your Profile is Now complete");

            } catch (Exception e) {
                e.printStackTrace();
                outputTextLabel.setText("Invalid Input.Please Fill all Requirements");
            }

      //  }else {
       //     outputTextLabel.setText("Phone number should 11 digits.");
       // }
    }
    }
