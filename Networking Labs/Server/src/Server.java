import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    //variables
    private BufferedReader br;
    private BufferedWriter bw;
    private Scanner scan = new Scanner(System.in);

    //method

    //constructor
    public Server(){
        try{

            //ServerSocket creatiom
            ServerSocket server = new ServerSocket(3030, 10);
            System.out.println("Connecting........");

            // Socket creation for accept()
            Socket accept = server.accept();
            System.out.println(accept.getInetAddress().getHostName() + ": Connected");

            //IOStream set up
            br = new BufferedReader(new InputStreamReader(accept.getInputStream()));
            bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
            System.out.println("IOStream set up");
            System.out.println("-------------------------------------------------------");

            // Communication through While
            while(true){

                String clientMessage = br.readLine();

                if(clientMessage.equals("quit")){
                    System.out.println("Client Quit");
                    break;
                }else{
                    System.out.println("Client: " + clientMessage);
                }

                System.out.print("send>> ");
                String serverMessage = scan.nextLine();
                bw.write(serverMessage + "\n");
                bw.flush();
            }

            //Socket Close
            System.out.println("Server Shutting Down");
            accept.close();

        }catch (IOException err){
            System.out.println(err.getMessage());
        }
    }

    public static void main(String [] args){
        Server server = new Server();
    }
}
