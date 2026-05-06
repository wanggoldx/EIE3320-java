//homework7
//Lau Wang Chun, 21100151d
//software: bluej
import java.util.*;

public class MyStack<E>
{
    private ArrayList<E> list=new ArrayList<>();
    
    public void push(E o)
    {
        list.add(o);
    }
    
    public E pop()
    {
        E o = list.get(getSize()-1);
        list.remove(getSize()-1);
        return o;
    }
    
    public E peek()
    {
        E o = list.get(getSize()-1);
        return o;
    }
    
    public int getSize()
    {
         return list.size();
    }
    
    public boolean isEmpty()
    {
        return list.isEmpty();
    }
    
    @Override
    public String toString() 
    {
        return "stack: " + list.toString();
    }
}
