/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dgram_server;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

/*
 * @author njpar
 */
public class Dgram_server extends Frame{
   
    //field
    private TextArea info, mess;
    private int port = 7777;
    private int buffsize = 100;
    private DatagramSocket ds = null;
        
    //constr
    public Dgram_server() {
        super("datagram server program");
        
        Panel p1 = new Panel(new BorderLayout());
        Panel p2 = new Panel(new BorderLayout());
        
        p1.add("West", new Button("Received Packet"));
        info = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        p1.add("Center", info);
        add(p1, BorderLayout.CENTER);
        p2.add("West", new Button("Received Data"));
        mess = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        p2.add("Center", mess);
        add(p2, BorderLayout.SOUTH);
        
        
        addWindowListener(new WinListener());
        setSize(450, 300);
        setVisible(true);
        
    }//constr
    
    //method
    public void runServer(){
        DatagramPacket dp = null;
        int cnt = 1;
                
        try{
            ds = new DatagramSocket(port);
            
            while(true){                
                try{
                    byte[] buff = new byte[buffsize];
                    dp = new DatagramPacket(buff, buff.length);
                    ds.receive(dp);
                    String rdata = new String(dp.getData(), 0, dp.getLength());
                    buff = rdata.getBytes();
                    InetAddress rAdd = dp.getAddress();
                    int port = dp.getPort();
                    info.append("Client"+" --------"+"\naddress: "+rAdd+"\nport: "+port+"\nmessage length: "+dp.getLength()+"\n");
                    mess.append("Received Message "+ cnt++ +": "+rdata+"\n");
                    dp = new DatagramPacket(buff, buff.length, rAdd, port);
                    ds.send(dp);                    
                    
                }catch(IOException e){
                    mess.append(e.toString());
                }//try..catch
                
            }//while            
            
        }catch(SocketException se){
            mess.append(se.toString());
        }//try..catch        
        
    }//rS

    public static void main(String[] args) {
        Dgram_server ds = new Dgram_server();
        ds.runServer();
    } //main
    
}//Main class
