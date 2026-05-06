import java.util.*;
import java.lang.*;
public class Picture
{
    private ArrayList shapes;
    
    public Picture() 
    {
        shapes = new ArrayList ();
    }
    
    void addShape(Shape s)
    {
        shapes.add(s);
    }
    
    void computeShape()
    {
        for(Iterator iter = shapes.iterator(); iter.hasNext();)
        {
            Shape shape = (Shape)iter.next();
            shape.computeArea();
            shape.computePerimeter();
        }
    }
    
    public void listAllShapeTypes()
    {
        for(Iterator iter = shapes.iterator(); iter.hasNext();)
        {
            Shape shape = (Shape)iter.next();
            shape.displayShape();
        }
    }
    
    public void listSingleShapeType(String className)
    {
        for(Iterator iter = shapes.iterator(); iter.hasNext();)
        {
            Shape shape = (Shape)iter.next();
            String temp=shape.getClass().getName();
            if (temp == className)
                shape.displayShape();
        }
    }
}
