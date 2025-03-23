package com.cosgrave.serverfx;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientUtil {
    //field
    Socket socket;

    //constr
    public ClientUtil(Socket socket){
        this.socket = socket;
        receive();
    }//constr

    //method
    public void receive(){    //to receive message from client
        Runnable thread = new Runnable(){
            @Override
            public void run() {
                try{
                    while(true){
                        InputStream in = socket.getInputStream();
                        byte[] buffer = new byte[512];
                        int length = in.read(buffer);
                        while(length == -1) throw new IOException();
                        System.out.println("[message successfully received] "
                                + socket.getRemoteSocketAddress()
                                + ": " + Thread.currentThread().getName());
                        String message = new String(buffer, 0, length, "UTF-8");

                        //share message with other clients
                        for(ClientUtil client: Server.clients){
                            client.send(message);
                        }//for
                    }//while
                }catch(Exception e){
                    //e.printStackTrace();
                    try{
                        System.out.println("[message receive error] "
                                + socket.getRemoteSocketAddress()
                                + ": " + Thread.currentThread().getName());
                    }catch(Exception e2){
                        e2.printStackTrace();
                    }//try..catch
                }//try..catch
            }//run
        };
        Server.threadPool.submit(thread);
    }//receive

    public void send(String message){    //to send message to client
        Runnable thread = new Runnable(){
            @Override
            public void run() {
                try{
                    OutputStream out = socket.getOutputStream();
                    byte[] buffer = message.getBytes("UTF-8");
                    out.write(buffer);
                    out.flush();
                }catch(Exception e){
                    try {
                        System.out.println("[message send error] "
                                + socket.getRemoteSocketAddress()
                                + ": " + Thread.currentThread().getName());
                        //remove errored client from server
                        Server.clients.remove(ClientUtil.this);
                        socket.close();
                    }catch (Exception e2) {
                        e2.printStackTrace();
                    }//try..catch
                }//try..catch
            }//run
        };
        Server.threadPool.submit(thread);
    }//send

}//ClientUtil class
