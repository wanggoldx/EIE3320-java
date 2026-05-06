import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI
{
    public static void main(String[] args)
    {
        Layout frame = new Layout();
        frame.setTitle("Calculate");
        frame.setSize(400, 225);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); 
    }
}