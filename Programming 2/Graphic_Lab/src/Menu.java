import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Menu extends JFrame implements ItemListener, ActionListener {
    //field
    Checkbox cb1 = new Checkbox("Registration");
    Button bm = new Button("Go to");
    private String option;

    //method
    @Override
    public void itemStateChanged(ItemEvent ie) {
        option = ie.getItem().toString();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(option.equals("Registration")){
            new Register();
        }
    }

    //constructor
    Menu(){
        //container
        JFrame frame = new JFrame("Menu");

        frame.setBounds(100, 100, 800, 600);


        //layout
        GridLayout gl = new GridLayout(3, 1);
        frame.setLayout(gl);

        //components
        Font font1 = new Font("Times New Romans", Font.BOLD, 24);
        Font font2 = new Font("Times New Romans", Font.BOLD, 12);

        //top
        Label lt = new Label("Menu", Label.CENTER);
        lt.setFont(font1);
        lt.setForeground(Color.darkGray);
        frame.add(lt);

        //middle
        cb1.addItemListener(this);
        Checkbox cb2 = new Checkbox("Search");
        Checkbox cb3 = new Checkbox("Count");
        Checkbox cb4 = new Checkbox("List");
        Checkbox cb5 = new Checkbox("Exit");

        bm.addActionListener(this);

        Panel pm = new Panel();
        pm.add(cb1); pm.add(cb2); pm.add(cb3); pm.add(cb4); pm.add(cb5); pm.add(bm);
        frame.add(pm);
        //bottom

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
