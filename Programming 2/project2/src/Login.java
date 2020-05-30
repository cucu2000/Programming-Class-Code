import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
    //field
    Button bb1 = new Button("Login");
    Button bb2 = new Button("Exit");
    TextField tfm1  = new TextField(20);
    TextField tfm2 = new TextField(20);

    //method
    @Override
    public void actionPerformed(ActionEvent e) {
        //check for exit or username and password
        if(e.getSource()==bb1){
            if(tfm1.getText().equals("admin") && tfm2.getText().equals("admin123")){
                new Menu();
            }else{
                new Login();
            }
        }else if(e.getSource()==bb2){
            System.exit(0);

            }
        }
    //constructor
    Login(){
        //container
        JFrame frame = new JFrame("Login");

        frame.setBounds(100, 100, 800, 600);

        //layout
        GridLayout grid = new GridLayout(3, 1);
        frame.setLayout(grid);

        //components
        Font font1 = new Font("Times New Romans", Font.BOLD, 24);
        Font font2 = new Font("Times New roman", Font.BOLD, 12);

            //top
            Label lt = new Label("Employee Management System", Label.CENTER);
            lt.setFont(font1);
            frame.add(lt);

            //middle
            Label lm1 = new Label("Username:");
            lm1.setFont(font2);
            frame.add(lm1);



            Label lm2 = new Label("Password:");
            lm2.setFont(font2);
            frame.add(lm2);


            tfm2.setEchoChar('*');

            Panel pm = new Panel();
            pm.add(lm1); pm.add(tfm1); pm.add(lm2); pm.add(tfm2); frame.add(pm);

            //bottom
            bb1.addActionListener(this);
            bb1.setFont(font2);
            frame.add(bb1);

            bb2.addActionListener(this);
            bb2.setFont(font2);
            frame.add(bb2);

            Panel pb = new Panel();
            pb.add(bb1); pb.add(bb2);
            frame.add(pb);

        //actions

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
