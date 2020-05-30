import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Front extends JFrame implements ActionListener{
    //field
    Button bm = new Button("Login");
    TextField tfm1 = new TextField(20);
    TextField tfm2 = new TextField(20);

    //method
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        //Check username and password
        if(tfm1.getText().equals("admin") && tfm2.getText().equals("admin123")){
            new Menu();
        }else{
            new Front();
        }
    }

    //constructor
    Front(){
        //container
        JFrame frame = new JFrame("Front");

        frame.setBounds(100, 100, 800, 600);


        //layout
        GridLayout gl = new GridLayout(3, 1);
        frame.setLayout(gl);

        //components
        Font font1 = new Font("Times New Romans", Font.BOLD, 24);
        Font font2 = new Font("Times New Romans", Font.BOLD, 12);

        //top
        Label lt = new Label("Employee Management System", Label.CENTER);
        lt.setFont(font1);
        lt.setForeground(Color.darkGray);
        frame.add(lt);

        //middle
        Label lm1 = new Label("ID:");
        lm1.setFont(font2);


        Label lm2 = new Label("Password:");
        lm2.setFont(font2);

        tfm2.setEchoChar('*');

        bm.addActionListener(this);
        bm.setFont(font2);

        Panel pm = new Panel();
        pm.add(lm1); pm.add(tfm1); pm.add(lm2); pm.add(tfm2); pm.add(bm);
        frame.add(pm);

        //bottom
        Label lb = new Label("Raid Shadow Legends", Label.CENTER);
        lb.setFont(font2);
        lb.setForeground(Color.darkGray);
        frame.add(lb);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
