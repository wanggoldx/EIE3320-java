import java.util.Scanner;

public class question4
{
     public void main()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a month (January = 1): ");  
        int month=input.nextInt();
        String smonth="p";
        if (month==1)
        {
            smonth="january";
        }
        else if (month==7)
        {
            smonth="July";
        }
        System.out.printf("%s has %d days.",smonth,daysInMonth(month));  
    }
    
    public static int daysInMonth(int month)
    {
        int day=0;
        switch (month) 
        {
        case 1: 
            day= 31;
        break;
        case 2: 
            day= 28;
        break;
        case 3: 
            day= 31;
        break;
        case 4: 
            day= 30;
        break;
        case 5: 
            day= 31;
        break;
        case 6: 
            day= 30;
        break;
        case 7: 
            day= 31;
        break;
        case 8: 
            day= 31;
        break;
        case 9: 
            day= 30;
        break;
        case 10: 
            day= 31;
        break;
        case 11: 
            day= 30;
        break;
        case 12: 
            day= 31;
        break;
        }
        return day;
    }
} 

