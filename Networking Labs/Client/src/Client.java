import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    //variables
    private BufferedReader br;
    private BufferedWriter bw;
    private Scanner scan = new Scanner(System.in);

    //method

    //constructor
    public Client(){
        try{

            // Socket creation
            Socket client = new Socket("localhost", 3030);
            System.out.println(client.getInetAddress().getHostName() + ": Connected");

            //IOStream set up
            br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            System.out.println("IOStream set up");
            System.out.println("-------------------------------------------------------");

            // Communication through While
            while(true){

                System.out.println("send>> ");
                String clientMessage = scan.nextLine();

                if(clientMessage.equals("quit")){
                    bw.write(clientMessage + "\n");
                    bw.flush();
                    break;
                }else{
                    bw.write(clientMessage + "\n");
                    bw.flush();
                }

                String serverMessage = br.readLine();
                System.out.println("Server: " + serverMessage);
            }

            //Socket Close
            System.out.println("Client Shutting Down");
            client.close();

        }catch (IOException err){
            System.out.println(err.getMessage());
        }
    }

    public static void main(String [] args){
        Client client = new Client();
    }
}

