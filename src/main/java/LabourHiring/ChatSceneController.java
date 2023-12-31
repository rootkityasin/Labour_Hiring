package LabourHiring;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class ChatSceneController {
    @FXML
    private TextArea area1;

    @FXML
    private Button button1;

    @FXML
    private Button exitButton;

    @FXML
    private Label lable2;

    @FXML
    private TextField tx1;


    boolean isConnected = false ;
    BufferedWriter writer;
    BufferedReader reader;

    @FXML
    void buttonAction1() {
        if (!isConnected ){
            String data = tx1.getText();
            tx1.clear();
            if( data == null || data.length() == 0 ){
                area1.appendText("Enter a valid name\n");
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
                                area1.appendText(input);
                            }
                            catch(SocketException z){
                                area1.appendText("Connection Lost\n");
                                break;
                            }
                            catch (Exception x){
                                x.printStackTrace();
                            }
                        }
                    }
                };
                t.start();

                area1.appendText("Connection Established.\n");
                button1.setText("Send");
                tx1.setPromptText("Enter a message.");
                isConnected = true ;
            }
            catch (Exception a){
                a.printStackTrace();
            }




        }

        else {

            try {
                String msg = tx1.getText();
                tx1.clear();

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
    void onActionExitButtonExpertise(ActionEvent event) {

        Platform.exit();
    }

}
