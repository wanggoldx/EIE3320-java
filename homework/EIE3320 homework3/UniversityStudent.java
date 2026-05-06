//homework3 question1
//Lau Wang Chun, 21100151d
//software: bluej

public class UniversityStudent
{
    // instance variables - replace the example below with your own
    private int courseNumber;
    String studentName;
    Course[] courseList=new Course[10];
    
    public UniversityStudent(String studentName,int courseNumber, Course[] courseList)
    {
        this.studentName=studentName;
        this.courseNumber=courseNumber;
        this.courseList=courseList;
    }

    public void print()
    {
        System.out.println("Student Name: "+ studentName);        
        for (int i=0;i<courseNumber;i++)
        {
            System.out.println(courseList[i].toString());     
        }
    }
}
