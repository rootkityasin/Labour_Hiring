package LabourHiring;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class ExpertiseChatSceneController {

    @FXML
    private TextArea area;

    @FXML
    private Button backbuttonExpertise;

    @FXML
    private ImageView backgroundImage;

    @FXML
    private Button button;

    @FXML
    private TextField tx;
    boolean isConnected = false ;
    BufferedWriter writer;
    BufferedReader reader;

    @FXML
    void buttonAction() {
        if (!isConnected ){
            String data = tx.getText();
            tx.clear();
            if( data == null || data.length() == 0 ){
                area.appendText("Enter a valid name\n");
                return;
            }
            try {
                Socket sc = new Socket("localhost" , 6020);


                OutputStreamWriter output = new OutputStreamWriter(sc.getOutputStream());
                writer = new BufferedWriter(output) ;

                writer.write(data+ "\n");
                writer.flush();

                InputStreamReader input = new InputStreamReader(sc.getInputStream());
                reader = new BufferedReader(input);

                Thread t = new Thread(){
                    @Override
                    public void run() {
                        while (true){
                            try {
                                String input = reader.readLine()+ "\n";
                                area.appendText(input);
                            }
                            catch(SocketException z){
                                area.appendText("Connection Lost\n");
                                break;
                            }
                            catch (Exception x){
                                x.printStackTrace();
                            }
                        }
                    }
                };
                t.start();

                area.appendText("Connection Established.\n");
                button.setText("Send");
                tx.setPromptText("Enter a message.");
                isConnected = true ;
            }
            catch (Exception a){
                a.printStackTrace();
            }




        }

        else {

            try {
                String msg = tx.getText();
                tx.clear();

                if( msg == null || msg.length() == 0 ){
                    return;
                }
                writer.write(msg + "\n");
                writer.flush();
            }
            catch (Exception a ){
                a.printStackTrace();
            }
        }

    }

    @FXML
    void onActionBackButtonExpertise(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ExpertWelcomePage.fxml"));
            Parent root1 = fxmlLoader.load();
            backbuttonExpertise.getScene().setRoot(root1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
