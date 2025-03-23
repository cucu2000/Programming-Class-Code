import java.awt.*;
import java.io.*;
import java.net.Socket;

public class MThread extends Thread {

    //variables
    TextArea dbox;
    Socket socket;
    InputStream inputStream;
    OutputStream outputStream;
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;
    int count;

    //methods
    public void run(){
        int count = 1;
        String clientMessage;
        try{
            dbox.append("IOStream Setup---------------");
            dbox.append("Server Connected to Client " + count);
            bufferedWriter.write("CLient" + count + " Connected");
            bufferedWriter.flush();

            while(true){
            clientMessage = bufferedReader.readLine();
            dbox.append("CLient" + count + ": " + clientMessage);

            if(clientMessage.equals("quit")){
                dbox.append("Server: Client " + count + " Closing");
                bufferedWriter.write("Goodbye Client " + count);
                bufferedWriter.flush();
                break;
            }
            }

        }catch(IOException err){
            err.printStackTrace();
        }
    }

    //constructors
    public MThread(TextArea dbox, Socket socket, int count){
        this.dbox = dbox;
        this.socket = socket;
        this.count = count;

        try{
          inputStream = socket.getInputStream();
          bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
          outputStream = socket.getOutputStream();
          bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        }catch(IOException err){
            err.printStackTrace();
        }

    }
}
