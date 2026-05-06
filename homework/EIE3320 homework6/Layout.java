import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Layout extends JFrame
{
    private JButton result = new JButton("Get Results");
    private JTextField chooseshape = new JTextField();
    private JTextField Tradius = new JTextField();
    private JTextField Tlength = new JTextField();
    private JTextField Twidth = new JTextField();
    private JTextField Tarea = new JTextField();
    private JTextField Tperimeter = new JTextField();

    public Layout()
    {
        // Set GridLayout, 3 rows, 2 columns, and gaps 5 between
        // components horizontally and vertically
        setLayout(new GridLayout(7, 2, 5, 5));
        // Add labels and text fields to the frame
        add(new JLabel("Choose shape: 's', 'r' or 'c'"));
        add(chooseshape);
        add(new JLabel("Input radius of circle"));
        add(Tradius);
        add(new JLabel("Input length of square or rectangle"));
        add(Tlength);
        add(new JLabel("Input width of rectangle"));
        add(Twidth);
        add(new JLabel("Area:"));
        add(Tarea);
        add(new JLabel("Perimeter:"));
        add(Tperimeter);
        add(result);
        
        ButtonListener listener = new ButtonListener();
        result.addActionListener(listener);
    }

    public class ButtonListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            String input;
            float width=0,length=0,radius=0;
            input = chooseshape.getText();
            
            if (input.equals("c"))
            {
                radius = Float.parseFloat(Tradius.getText());
                Circle t = new Circle(radius);
                t.computeArea();
                t.computePerimeter();
                Tarea.setText(Float.toString(t.getArea()));
                Tperimeter.setText(Float.toString(t.getPerimeter()));
                t.draw();
            }
            else if(input.equals("s"))
            {
                length = Float.parseFloat(Tlength.getText());
                Square t = new Square(length);
                t.computeArea();
                t.computePerimeter();
                Tarea.setText(Float.toString(t.getArea()));
                Tperimeter.setText(Float.toString(t.getPerimeter()));
                t.draw();
            }
            else if(input.equals("r"))
            {
                length = Float.parseFloat(Tlength.getText());
                width = Float.parseFloat(Twidth.getText());               
                Rectangle t = new Rectangle(length,width);
                t.computeArea();
                t.computePerimeter();
                Tarea.setText(Float.toString(t.getArea()));
                Tperimeter.setText(Float.toString(t.getPerimeter()));
                t.draw();
            }
        }
    }
}
