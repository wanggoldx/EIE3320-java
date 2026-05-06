import java.util.Scanner;

public class question5
{
 
    int total=0;
    public question5()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Input >> ");
        int n=input.nextInt();
        int m=input.nextInt();
        total=n;
        total_candy_after_return(n,m);
        System.out.printf("n = %d,m = %d, total candy =%d",n,m,total);
    }

    public void total_candy_after_return(int n,int m)
    {
        if (n>=m)
        {
            total=total+n/m;
            n=n/m+n%m;
            total_candy_after_return(n,m);
        }
    }
  
}
