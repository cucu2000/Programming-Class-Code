import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;


public class ClientAWT {

    public static class clientAWT extends JFrame implements ActionListener {

        //Variables
        TextArea dialog;
        JTextField message;
        BufferedWriter bw;
        BufferedReader br;


        //Methods
        @Override
        public void actionPerformed(ActionEvent e) {

            dialog.append("Client: " + message.getText());
            dialog.append("\n");

            try{
                bw.write(message.getText() + "\n");
                bw.flush();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            message.setText("");
        }

        private  void backEnd(){
            try {

                //Server creation
                Socket client = new Socket("localhost", 3030);
                dialog.append("Connecting------------------------------");
                dialog.append("\n");

                //IOStream set up
                br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                dialog.append("IOStream set up \n");
                dialog.append("------------------------------------------------------- \n");

                // Communication through While
                while(true){

                    String serverMessage = br.readLine();

                    if(serverMessage.equals("quit")){
                        dialog.append("Server Quit \n");
                        break;
                    }else {
                        dialog.append("Server: " + serverMessage + "\n");
                    }
                }

                //Socket Close
                dialog.append("Server Shutting Down");
                client.close();

            }catch (IOException err){
                dialog.append(err.getMessage());
            }
        }

        //Constructor
        clientAWT() {

            //graphic
            // 1. Frame
            setBounds(100, 200, 500, 500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // 2. layout
            BorderLayout bLayout = new BorderLayout();
            setLayout(bLayout);

            // 3. Component
            Label lb1 = new Label("Dialog Box: Client", Label.CENTER);
            add(lb1, BorderLayout.NORTH);

            dialog = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
            dialog.setFocusable(false);
            add(dialog, BorderLayout.CENTER);

            Label lb2 = new Label("Message: ");
            message = new JTextField(30);


            Panel panel = new Panel();
            panel.add(lb2);
            panel.add(message);


            add(panel, BorderLayout.SOUTH);

            //4. Event
            message.addActionListener(this);

            setVisible(true);


            backEnd();
        }
    }

    public static void main(String[] args) {
        clientAWT window = new clientAWT();
    }
}