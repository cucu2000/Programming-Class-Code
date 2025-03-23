/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dgram_client;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

/*
 * @author njpar
 */
public class Dgram_client extends Frame implements ActionListener{

    //field
    private TextField data;
    private TextArea info, mess;
    private String host = "localhost";
    private DatagramSocket ds = null;
    private DatagramPacket dp = null;
    private int port = 7777;
    private int cnt=1;    
    
    public Dgram_client() {
        super("datagram client program");
        
        Panel pi = new Panel(new BorderLayout());
        Panel ps = new Panel(new BorderLayout());
        Panel pm = new Panel(new BorderLayout());
        Panel pd = new Panel(new BorderLayout());
        
        pi.add("West", new Button("Received Packet"));
        info = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        pi.add("Center", info);
        add(pi, BorderLayout.CENTER);
        
        pm.add("West", new Button("Received Data"));
        mess = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        pm.add("Center", mess);
        
        pd.add("West", new Label("input: ", Label.CENTER));
        data = new TextField(" ");
        pd.add("Center", data);
        
        ps.add("Center", pm);
        ps.add("South", pd);
        add(ps, BorderLayout.SOUTH);
        data.addActionListener(this);
        
        addWindowListener(new WinListener());
        setSize(450, 300);
        setVisible(true);        
        
    }//constr

    public static void main(String[] args) {
        Dgram_client dc = new Dgram_client();
        dc.runClient();
        
    } //main

    //method
    public void runClient(){
        //local
        String send;
        int cnt=1;
              
        try{
            ds = new DatagramSocket();
            byte[] buff = new byte[100];            
            try{
                while(true){
                    //byte[] buff = new byte[buffsize];
                    dp = new DatagramPacket(buff, buff.length);
                    ds.receive(dp);
                    String rdata = new String(dp.getData());                    
                    mess.append("Received Message "+cnt+": "+rdata+"\n");
                    info.append("Server"+" ---------"+"\naddress: "+dp.getAddress()+"\nport: "+dp.getPort()+"\nmessage length: "+dp.getLength()+"\n");
                    cnt++;                    
                }//while
                
            }catch(IOException e){
                mess.append(e.toString());
            }//try..catch   
        }catch(SocketException se){
            mess.append(se.toString());
        }//try..catch        
        
    }//rC
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String str = data.getText();
            mess.append("Sent Message "+ cnt++ +": "+str+"\n");
            data.setText("");
            byte[] data = str.getBytes();
            dp = new DatagramPacket(data, data.length, InetAddress.getByName(host), port);
            ds.send(dp);
            //mess.append("complete sending message!\n");
            
        }catch(IOException ie){
            mess.append(ie.toString()+"\n");
        }//try..catch
    }//aP
    
}//Main class
