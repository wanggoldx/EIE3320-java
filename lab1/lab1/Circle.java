//lab1
//Lau Wang Chun, 21100151d
//software: bluej

import java.util.*;
import java.awt.*;
import java.awt.geom.*;
public class Circle extends Shape implements Drawable
{
    // instance variables - replace the example below with your own
    private float radius;
    Scanner scan = new Scanner(System.in);
    /**
     * Constructor for objects of class Circle
     */
    public Circle()
    {
        radius = 1;
    }
    
    public Circle(float r)
    {
        radius = r;
    }

    public void readShape()
    {
        radius = scan.nextFloat();
    }
    
    public void computeArea()
    {
        area = radius * radius * (float)Math.PI;
    }
    
    public void computePerimeter()
    {
        perimeter = 2 * radius * (float)Math.PI;
    }
    
    public void displayShape()
    {
        System.out.println("Area of circle = "+ area);
        System.out.println("Perimeter of circle = "+ perimeter);
    }
    
    public void draw()
    {
        Canvas canvas = Canvas.getCanvas();
        canvas.draw(this, "blue", new Ellipse2D.Double(10, 10, (radius*2), (radius*2))); 
    }
}   