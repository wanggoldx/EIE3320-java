//lab1
//Lau Wang Chun, 21100151d
//software: bluej

import java.util.*;
public class Rectangle extends Shape implements Drawable
{
    private float length;
    private float width;
    Scanner scan = new Scanner(System.in);
    
    public Rectangle()
    {
        length = 1;
        width = 1;
    }
    
    public Rectangle(float l, float w)
    {
        length = l;
        width = w;
    }

    public void readShape()
    {
        length = scan.nextFloat();
        System.out.println("Please input the width:");
        width = scan.nextFloat();
    }
    
    public void computeArea()
    {
        area = length * width;
    }
    
    public void computePerimeter()
    {
        perimeter = (length+width) * 2;
    }
    
    public void displayShape()
    {
        System.out.println("Area of rectangle = "+ area);
        System.out.println("Perimeter of rectangle = "+ perimeter);
    }
    
    public void draw()
    {
        Canvas canvas = Canvas.getCanvas();
        canvas.draw(this, "blue", new java.awt.Rectangle(150, 150, (int)length, (int)width)); 
    }
}
