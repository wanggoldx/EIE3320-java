//lab1
//Lau Wang Chun, 21100151d
//software: bluej

import java.util.*;
public class ShapeTester
{
    public static void main (String args[])
    {
        String input;
        do
        {
            Scanner scan = new Scanner(System.in);
            System.out.println();
            System.out.println("************************************");
            System.out.println("*Please choose one the followings: *");
            System.out.println("*Press 'c' - Circle                *");
            System.out.println("*Press 's' - Square                *");
            System.out.println("*Press 'r' - Rectangle             *");
            System.out.println("*Press 'x' - Exit                  *");
            System.out.println("************************************");
            input = scan.nextLine();
            if (input.equals("c"))
            {
                Shape t = new Circle();
                System.out.println("Please input the radius:");
                t.readShape();
                t.computeArea();
                t.computePerimeter();
                t.displayShape();
                t.draw();
            }
            else if(input.equals("s"))
            {
                Shape t = new Square();
                System.out.println("Please input the length:");
                t.readShape();
                t.computeArea();
                t.computePerimeter();
                t.displayShape();
                t.draw();
            }
            else if(input.equals("r"))
            {
                Shape t = new Rectangle();
                System.out.println("Please input the length:");
                t.readShape();
                t.computeArea();
                t.computePerimeter();
                t.displayShape();
                t.draw();
            }
            else if(input.equals("x"))            
                System.out.println("End!");
            else
                System.out.println("Invalid command!");
        } while (!input.equals("x"));
        
        
    }
}
