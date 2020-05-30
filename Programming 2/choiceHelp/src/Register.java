import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class Register extends JFrame implements  ActionListener, TextListener{
    //field
    Button bm = new Button("Register");
    TextArea tab = new TextArea(2, 40);
    String result = "Elie is successfully registered";

    //method
    @Override
    public void actionPerformed(ActionEvent ae) {
        tab.setText("");
        tab.append(result);
    }

    @Override
    public void textValueChanged(TextEvent te) {

    }

    //constructor
    Register(){
        //container
        JFrame frame = new JFrame("Register");

        frame.setBounds(100, 100, 800, 600);


        //layout
        GridLayout gl = new GridLayout(3, 1);
        frame.setLayout(gl);

        //components
        Font font1 = new Font("Times New Romans", Font.BOLD, 24);
        Font font2 = new Font("Times New Romans", Font.BOLD, 12);

        //top
        Label lt = new Label("Register", Label.CENTER);
        lt.setFont(font1);
        lt.setForeground(Color.darkGray);
        frame.add(lt);

        //middle
        bm.addActionListener(this);
        Panel pm = new Panel();
        pm.add(bm); frame.add(pm);

        //bottom
        Label lb = new Label("Output", Label.CENTER);
        lb.setFont(font2);
        tab.addTextListener(this);
        tab.setEditable(false);


        Panel pb = new Panel();
        pb.add(lb); pb.add(tab);
        frame.add(pb);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
