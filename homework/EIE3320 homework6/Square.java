//lab1
//Lau Wang Chun, 21100151d
//software: bluej

import java.util.*;
public class Square extends Shape implements Drawable
{
    // instance variables - replace the example below with your own
    private float length;
    Scanner scan = new Scanner(System.in);
    /**
     * Constructor for objects of class Square
     */
    public Square()
    {
        length = 1;
    }
    
    public Square(float l)
    {
        length = l;
    }

    public void readShape()
    {
        length = scan.nextFloat();
    }
    
    public void computeArea()
    {
        area = length * length;
    }
    
    public void computePerimeter()
    {
        perimeter = length * 4;
    }
    
    public void displayShape()
    {
        System.out.println("Area of square = "+ area);
        System.out.println("Perimeter of square = "+ perimeter);
    }
    
    public void draw()
    {
        Canvas canvas = Canvas.getCanvas();
        canvas.draw(this, "blue", new java.awt.Rectangle(100, 100, (int)length, (int)length)); 
    }
    
    float getArea()
    {
        return area;
    }
    
    float getPerimeter()
    {
        return perimeter;
    }
}
