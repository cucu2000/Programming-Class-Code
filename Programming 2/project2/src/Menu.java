import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Menu extends JFrame implements ActionListener, ItemListener {
    //field
    CheckboxGroup cbgm = new CheckboxGroup();
    Checkbox c1 = new Checkbox("Register", false, cbgm);
    Checkbox c2 = new Checkbox("Search", false, cbgm);
    Checkbox c3 = new Checkbox("Count", false, cbgm);
    Checkbox c4 = new Checkbox("List", false, cbgm);
    Checkbox c5 = new Checkbox("Exit", false, cbgm);

    Button bm = new Button("Go To");

    TextArea tab = new TextArea("");

    JPanel r2 = new JPanel();

    Label r2l1 = new Label("ID:", Label.CENTER);
    Label r2l2 = new Label("Name:", Label.CENTER);
    Label r2l3 = new Label("DOB:", Label.CENTER);

    Button execute = new Button("Execute");

    TextField r2tb1 = new TextField(20);
    TextField r2tb2 = new TextField(20);
    TextField r2tb3 = new TextField(20);

    CRUD crud = new CRUD();

    //method
    @Override
    public void actionPerformed(ActionEvent ae) {

        if (c5.getState() == true) {
            System.exit(0);
        } else if (c1.getState() == true) {
            r2.add(r2l1);
            r2.add(r2tb1);
            r2.add(r2l2);
            r2.add(r2tb2);
            r2.add(r2l3);
            r2.add(r2tb3);
            r2.add(execute);
            r2.setVisible(true);
            if (ae.getSource() == execute) {

                String idS = r2tb1.getText();
                int id = Integer.parseInt(idS);

                String Name = r2tb2.getText();

                String DOB = r2tb3.getText();

                Employee emp = new Employee(id, Name, DOB);

                Employee result = crud.register(emp);

                tab.append(result.getName() + " was registered successfully.");
                tab.append("\n");
                c1.setState(false);
                r2tb1.setText("");
                r2tb2.setText("");
                r2tb3.setText("");
                r2.remove(r2l1);
                r2.remove(r2tb1);
                r2.remove(r2l2);
                r2.remove(r2tb2);
                r2.remove(r2l3);
                r2.remove(r2tb3);
                r2.remove(execute);
                r2.setVisible(false);
            }
        } else if (c2.getState() == true) {
            r2.add(r2l1);
            r2.add(r2tb1);
            r2.add(execute);
            r2.setVisible(true);
            if (ae.getSource() == execute) {
                String idS = r2tb1.getText();
                int id = Integer.parseInt(idS);
                Employee result = crud.searchID(id);
                if (result == null) {
                    tab.append("Employee not found.");
                } else {
                    tab.append("Employee Found: " + "ID: " + result.getiD() + " Name: " + result.getName() + " DOB: " + result.getdOB());
                }
                tab.append("\n");
                c2.setState(false);
                r2tb1.setText("");
                r2.remove(r2l1);
                r2.remove(r2tb1);
                r2.remove(execute);
                r2.setVisible(false);
            }
        } else if (c3.getState() == true) {
            r2.add(execute);
            r2.setVisible(true);
            if (ae.getSource() == execute) {
                int count = crud.returnEmployeeCount();
                String countS = Integer.toString(count);
                tab.append("Number of Employees: " + countS);
                tab.append("\n");
                c3.setState(false);
                r2.remove(execute);
                r2.setVisible(false);
            }
        } else if (c4.getState() == true) {
            r2.add(execute);
            r2.setVisible(true);
            if (ae.getSource() == execute) {
                tab.append("Printing Employees-------");
                tab.append("\n");
                Employee [] employees = crud.printEmployees();
                int employeeSize = crud.returnEmployeeCount();
                for(int x = 0; x < employeeSize; x++){
                    tab.append("ID: " + employees[x].getiD() + " Name: " + employees[x].getName() + " DOB: " + employees[x].getdOB());
                    tab.append("\n");
                }
                c4.setState(false);
                r2.remove(execute);
                r2.setVisible(false);
            }
        }
    }
    @Override
    public void itemStateChanged(ItemEvent itemEvent) {

    }

    //constructor
    Menu(){
            //container
            JFrame frame = new JFrame("System Menu");

            frame.setBounds(100, 100, 800, 600);

            //layout
            GridLayout grid = new GridLayout(4, 1);
            frame.setLayout(grid);

            //components
            Font font1 = new Font("Times New Romans", Font.BOLD, 24);
            Font font2 = new Font("Times New roman", Font.BOLD, 12);

            //top
            Label lt = new Label("System Menu", Label.CENTER);
            lt.setFont(font1);
            frame.add(lt);

            //middle (Row 2)
            c1.addItemListener(this);
            c2.addItemListener(this);
            c3.addItemListener(this);
            c4.addItemListener(this);
            c5.addItemListener(this);
            bm.addActionListener(this);
            Panel pm = new Panel();
            pm.add(c1); pm.add(c2); pm.add(c3); pm.add(c4); pm.add(c5); pm.add(bm);
            frame.add(pm);

            //Middle (Row 3)
            r2l1.setFont(font2);

            r2l2.setFont(font2);

            r2l3.setFont(font2);

            execute.addActionListener(this);

            frame.add(r2);
            r2.setVisible(false);

            //bottom
            tab.enableInputMethods(false);
            tab.setEditable(false);
            tab.setFocusable(false);
            frame.add(tab);


            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
}

