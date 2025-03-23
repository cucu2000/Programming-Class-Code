package com.cosgrave.serverfx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server extends Application {

    //variables
    public static ExecutorService threadPool;
    public static Vector<ClientUtil> clients = new Vector<ClientUtil>();
    ServerSocket server;

    //methods
    public void startServer(String ipAddress, int port){
        try{
            server = new ServerSocket();
            server.bind(new InetSocketAddress(ipAddress, port));

        }catch (Exception err){
            err.printStackTrace();
            if(!server.isClosed()){
                stopServer();
            }
            return;
        }

        //wait until Client accesses Server
        Runnable thread = new Runnable() {
            @Override
            public void run() {

                while(true){
                    try{
                        Socket socket = server.accept();
                        clients.add(new ClientUtil(socket));
                        System.out.println("Client accessed: " + socket.getRemoteSocketAddress() + ": " + Thread.currentThread().getName());

                    }catch(Exception err){
                        err.printStackTrace();
                        if(!server.isClosed()){
                            stopServer();
                        }
                        break;
                    }
                }
            }
        };
        //threadPool initialize
        threadPool = Executors.newCachedThreadPool();
        threadPool.submit(thread);
    }

    public void stopServer(){
        try{
            //close all socket currently accessed
            Iterator<ClientUtil> iterator = clients.iterator();
            while(iterator.hasNext())  {
                ClientUtil client = iterator.next();
                client.socket.close();
                iterator.remove();
            }

            //close server socket
            if(server != null && !server.isClosed()){
                server.close();
            }

            if(threadPool != null && threadPool.isShutdown()){
                threadPool.shutdown();
            }

        }catch(Exception err){
            err.printStackTrace();
        }
    }

    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(5));

        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("TimesNewRoman", 12));
        root.setCenter(textArea);

        //server start button
        Button toggleButton = new Button("start");
        toggleButton.setMaxWidth(Double.MAX_VALUE);
        BorderPane.setMargin(toggleButton, new Insets(1,0,0,0));
        root.setBottom(toggleButton);

        String IP = "127.0.0.1";
        int port = 9876;

        toggleButton.setOnAction(event -> {
            if(toggleButton.getText().equals("start")){
                startServer(IP, port);
                Platform.runLater(() -> {
                    String message = String.format("[server start]\n", IP, port);
                    textArea.appendText(message);
                    toggleButton.setText("stop");
                });
            }//fi
            else{
                stopServer();
                Platform.runLater(() -> {
                    String message = String.format("[server stop]\n", IP, port);
                    textArea.appendText(message);
                    toggleButton.setText("start");
                });
            }//esle
        });

        Scene scene = new Scene(root, 400, 400);
        stage.setTitle("[chat server]");
        stage.setOnCloseRequest(event -> stopServer());
        stage.setScene(scene);
        stage.show();

    }//start

    public static void main(String[] args) {
        launch(args);
    }
}