package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client extends Application {
    //field
    Socket socket;
    TextArea textArea;

    //method
    public void startClient(String IP, int port){  //start client
        Thread thread = new Thread(){
            public void run(){
                try{
                    socket = new Socket(IP, port);
                    receive();
                }catch(Exception e){
                    if(!socket.isClosed()){
                        stopClient();
                        System.out.println("[fail to access server]");
                        Platform.exit();
                    }//fi
                }//try..catch
            }//run
        };
        thread.start();
    }//stC

    public void stopClient(){  //stop client
        try{
            if(socket != null && !socket.isClosed()){
                socket.close();
            }//fi
        }catch(Exception e){
            e.printStackTrace();
        }//try..catch
    }//spC

    public void receive(){  //receive message from server
        while (true) {
            try{
                InputStream in = socket.getInputStream();
                byte[] buffer = new byte[512];
                int length = in.read(buffer);
                if(length == -1) throw new IOException();
                String message = new String(buffer, 0, length, "UTF-8");
                Platform.runLater(() -> {
                    textArea.appendText(message);
                });
            }catch(Exception e){
                stopClient();
                break;
            }//try..catch
        }//while
    }//receive


    public void send(String message){
        Thread thread = new Thread(){
            public void run(){
                try{
                    OutputStream out = socket.getOutputStream();
                    byte[] buffer = message.getBytes("UTF-8");
                    out.write(buffer);
                    out.flush();
                } catch(Exception e){
                    stopClient();
                }//try..catch
            }//run
        };
        thread.start();
    }//send


    //run client program
    @Override
    public void start(Stage primaryStage) {  //dialog design
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(5));

        HBox hbox = new HBox();
        hbox.setSpacing(5);

        TextField userName = new TextField();
        userName.setPrefWidth(150);
        userName.setPromptText("enter your name: ");
        HBox.setHgrow(userName, Priority.ALWAYS);

        TextField IPText = new TextField("127.0.0.1");
        TextField portText = new TextField("9876");
        portText.setPrefWidth(80);

        //top block in dialog box
        hbox.getChildren().addAll(userName, IPText, portText);
        root.setTop(hbox);

        //middle block in dialog box
        textArea = new TextArea();
        textArea.setEditable(false);
        root.setCenter(textArea);

        //bottom block in dialog box
        TextField input = new TextField();
        input.setPrefWidth(Double.MAX_VALUE);
        input.setDisable(true);

        input.setOnAction(event ->{
            send(userName.getText()+": "+input.getText()+"\n");
            input.setText(" ");
            input.requestFocus();
        });

        Button sendButton = new Button("send");
        sendButton.setDisable(true);

        sendButton.setOnAction(event -> {
            send(userName.getText()+": "+input.getText()+"\n");
            input.setText(" ");
            input.requestFocus();
        });

        Button connectionButton = new Button("access");
        connectionButton.setOnAction(event -> {
            if(connectionButton.getText().equals("access")){
                int port = 9876;
                try{
                    port = Integer.parseInt(portText.getText());
                }catch(Exception e){
                    e.printStackTrace();
                }//try..catch
                startClient(IPText.getText(), port);
                Platform.runLater(() -> {
                    textArea.appendText("[access chatroom]\n");
                });
                connectionButton.setText("exit");
                input.setDisable(false);
                sendButton.setDisable(false);
                input.requestFocus();
            }//fi
            else{
                stopClient();
                Platform.runLater(() -> {
                    textArea.appendText("[exit chatroom]\n");
                });
                connectionButton.setText("access");
                input.setDisable(true);
                sendButton.setDisable(true);
            }//esle
        });
        BorderPane pane = new BorderPane();
        pane.setLeft(connectionButton);
        pane.setCenter(input);
        pane.setRight(sendButton);

        root.setBottom(pane);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("[Chatting Client]");
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(event -> stopClient());
        primaryStage.show();

        connectionButton.requestFocus();

    }//start



    public static void main(String[] args) {
        launch(args);
    }//main

}//Fx_client class
