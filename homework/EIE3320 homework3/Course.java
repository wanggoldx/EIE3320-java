//homework3 question1
//Lau Wang Chun, 21100151d
//software: bluej

public class Course
{
    // instance variables - replace the example below with your own
    private int testMarks;
    String courseName;

    /**
     * Constructor for objects of class Course
     */
    public Course(String courseName,int testMarks)
    {
        this.courseName=courseName;
        this.testMarks=testMarks;
    }

    public String toString()
    {
        return courseName+", "+testMarks;
    }
}
