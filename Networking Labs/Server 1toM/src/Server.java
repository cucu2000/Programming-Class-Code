import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server extends Frame {

    //variables
    private TextArea dbox;


    //methods
    public void serverRun(){
        ServerSocket server;
        Socket socket;
        MThread mt;
        int clientNum = 1;

        try{
            server = new ServerSocket(2000, 10);
            dbox.append("Waiting--------------------------");

            try{
                while(true){
                    socket = server.accept();
                    mt = new MThread(dbox, socket, clientNum);
                    dbox.append("Client " + clientNum + " Connected with Name: " + socket.getInetAddress().getHostAddress());
                    mt.start();
                }

            }catch(IOException err2){
                err2.printStackTrace();
            }
        }catch(IOException err1){
            err1.printStackTrace();
        }
    }

    //constructor
    public Server(){
        super("Multi-Comm Server Program");
        dbox = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        add(dbox, BorderLayout.CENTER);
        addWindowListener(new WinListener());

        setSize(450, 300);
        setVisible(true);
    }

    public static void main(String [] args){

    }

}
