import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JFrame implements ActionListener, ItemListener {

    //field
    Button btnBot = new Button("Continue");
    Choice cMid = new Choice();



    //constr
    public Menu() {
        //container
        JFrame f = new JFrame("Menu");
        f.setBounds(100, 100, 800, 500);

        //layout
        GridLayout gl = new GridLayout(3, 1);
        f.setLayout(gl);

        //components
        Font font1 = new Font("Times New Roman", Font.BOLD, 24);
        Font font2 = new Font("Times New Roman", Font.BOLD, 12);

        //top
        Label lblTop = new Label("Employee Management System: Menu", Label.CENTER);
        cMid.add("Register");
        cMid.add("Search");
        cMid.add("Count");
        cMid.add("Print");
        cMid.add("Exit");
        cMid.addItemListener(this);
        lblTop.setFont(font1);
        lblTop.setForeground(Color.BLUE);
        f.add(lblTop);

        //mid
        Label lblMid = new Label("Select: ");
        btnBot.addActionListener(this);
        Panel pMid = new Panel();
        pMid.add(lblMid); pMid.add(cMid); pMid.add(btnBot);
        f.add(pMid);


        //bot

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (cMid.getSelectedItem().equals("Register")) {
            new Register();

        }
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {

    }
}
