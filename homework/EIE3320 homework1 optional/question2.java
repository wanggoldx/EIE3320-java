import java.util.Scanner;

public class question2
{
     public void main()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of seconds: ");  
        int inputsecond=input.nextInt();
        int second,hour,minute;
        hour=inputsecond/3600;
        second=inputsecond-hour*3600;
        minute=second/60;
        second=second-minute*60;
        System.out.printf("%d second is %d hours,%d minutes, and %d seconds",inputsecond,hour,minute,second);
    }
}
