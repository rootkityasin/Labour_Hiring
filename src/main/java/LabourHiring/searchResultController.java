package LabourHiring;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import javafx.scene.control.TableCell;

public class searchResultController implements  Initializable {


    @FXML
    private Label lable1;
    @FXML
    private Button messagingButton;
    @FXML
    private Button backButton;

    @FXML
    private TableView<searchmodel> myTable;

    @FXML
    private TextField searchBoxfield;

    @FXML
    private TableColumn<searchmodel, String> tableAddress;

    @FXML
    private TableColumn<searchmodel, String> tableCategory;

    @FXML
    private TableColumn<searchmodel, String> tableArea;

    @FXML
    private TableColumn<?, ?> tableClick;

    @FXML
    private TableColumn<searchmodel, String> tableEmail;

    @FXML
    private TableColumn<searchmodel, String> tableName;

    @FXML
    private TableColumn<searchmodel, String> tablePhone;




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
        ObservableList<searchmodel> searchlist= FXCollections.observableArrayList();

        DatabaseConnection connectNow = new DatabaseConnection ();
        Connection connectDB = connectNow.getConnection();
        String searchQuery ="SELECT Name,Phone,Email,Address,Area,Category FROM workerinfo";



        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(searchQuery);
            while (queryOutput.next()) {
                String queryname = queryOutput.getString("Name");
                Integer queryphone = queryOutput.getInt("Phone");
                String queryemail = queryOutput.getString("Email");
                String queryaddress = queryOutput.getString("Address");
                String queryarea = queryOutput.getString("Area");
                String querycategory = queryOutput.getString("Category");

                searchlist.add(new searchmodel(queryname,queryphone,queryemail,queryaddress,queryarea,querycategory));

            }


            tableName.setCellValueFactory(new PropertyValueFactory<>("Name"));
            tablePhone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
            tableEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
            tableAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
            tableArea.setCellValueFactory(new PropertyValueFactory<>("Area"));
            tableCategory.setCellValueFactory(new PropertyValueFactory<>("Category"));



           myTable.setItems(searchlist);

            FilteredList<searchmodel> filteredData = new FilteredList<>(searchlist,b ->true);
                    searchBoxfield.textProperty().addListener((observable,oldValue,newValue)->{
                        filteredData.setPredicate(searchmodel -> {
                            if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                                return true;
                            }
                            String searchKeyword = newValue.toLowerCase();

                            if (searchmodel.getCategory().toLowerCase().contains(searchKeyword)) {
                                return true;
                            } else if (searchmodel.getArea().toLowerCase().contains(searchKeyword)) {
                                return true;
                            } else
                                return false;
                        });
                    });
            SortedList<searchmodel> sortedData = new SortedList <>(filteredData);
            sortedData.comparatorProperty().bind(myTable.comparatorProperty());
            myTable.setItems(sortedData);


            }catch(SQLException e) {
            Logger.getLogger(searchmodel.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }



    }
}