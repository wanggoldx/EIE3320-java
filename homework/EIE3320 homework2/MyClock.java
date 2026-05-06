//homework2 question1
//Lau Wang Chun, 21100151d
//software: bluej

public class MyClock
{
 public static void main(String[] args) 
 {
     ClockDisplay hkTime = new ClockDisplay(15,59);
     ClockDisplay londonTime = new ClockDisplay(24,30);
     hkTime.timeTick();
     londonTime.timeTick();
     System.out.println(hkTime.getTime());
     System.out.println(londonTime.getTime());

 }
 
 
}
