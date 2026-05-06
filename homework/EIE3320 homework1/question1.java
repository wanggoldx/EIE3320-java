//homework1 question1
//Lau Wang Chun, 21100151d
//software: bluej
import java.util.*;
public class question1
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of lines: ");  
        int no_of_line=input.nextInt();
        int i,j;
        int linelocation=1;
        for (i = no_of_line; i >= 1; --i)
        {
          for (j = 1; j <= i; ++j) 
          {
             System.out.print("   ");  
          }
          
          for (j = linelocation; j >= 1; --j) 
          {
            if (j<=9)
            {
             System.out.print(j);  
             System.out.print("  ");
            }
            else
            {
             System.out.print(j);  
             System.out.print(" ");
            }
          }
          
          if (linelocation!=1)
          {
              for (j = 2; j <= linelocation; ++j) 
              {
                 if (j<=9)
            {
             System.out.print(j);  
             System.out.print("  ");
            }
            else
            {
             System.out.print(j);  
             System.out.print(" ");
            }
              }
          }
        
          linelocation=linelocation+1;
          System.out.println();  
        }
    }
}
