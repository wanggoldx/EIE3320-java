public class Video extends Item
{
    // instance variables - replace the example below with your own
    private String director;
    
    public Video(String theTitle, String theDirector, int time)
    {
        super(theTitle,time);
        this.director = theDirector;
    }

    public void print()
    {
        System.out.println("Video");
        super.print();
        System.out.println("Director: " + director);
    }   
    
    public String toString()
    {
        String s = super.tostring() + director;
        return s;
    } 
}
