import java.util.Scanner;

public class question3
{
     public void main()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("The first 100 triangular numbers are: ");  
        int count=0;
        for (int i=1;i<=100;i++)
        {  
            if (count==10)
            {
                System.out.println();
                System.out.print(getTriangularNumber(i));  
                System.out.print(" "); 
                count=1;
            }
            else
            {
                System.out.print(getTriangularNumber(i));  
                System.out.print(" "); 
                count=count+1;
            }
        }    
    }
    
    public static int getTriangularNumber(int n)
    {
        int answer=n;
        while (n!=0)
        {
            n=n-1;
            answer=answer+n;     
        };
        return answer;
    }
}


