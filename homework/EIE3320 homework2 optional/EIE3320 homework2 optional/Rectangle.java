public class Rectangle
{
    // instance variables - replace the example below with your own
    private double width, height;

    /**
     * Constructor for objects of class Rectangle
     */
    public Rectangle()
    {
        width=1;
        height=1;
    }
    
    public Rectangle(double x,double y)
    {
        width=x;
        height=y;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public double getArea()
    {
        return width * height;
    }
    
    public double getPerimeter()
    {
        return (width + height)*2;
    }
}
