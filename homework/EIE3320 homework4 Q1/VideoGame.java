
/**
 * Write a description of class VideoGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VideoGame
{
    // instance variables - replace the example below with your own
    private String title, platform, comment;
    private int numberOfPlayers, playingTime;
    private boolean gotIt;
    
    public VideoGame(String title,String platform,int numberOfPlayers,int playingTime)
    {
        this.title = title;
        this.platform = platform;
        this.numberOfPlayers = numberOfPlayers;
        this.playingTime = playingTime;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setComment(String comment)
    {
        this.comment = comment;
    }
    
    public String getComment()
    {
        return comment;
    }
    
    public void setOwn(boolean gotIt)
    {
        this.gotIt = gotIt;
    }
    
    public boolean getOwn()
    {
        return gotIt;
    }
    
    public void  print()
    {
        System.out.println("VideoGame");
        System.out.println("Title: " + title);
        if(gotIt) {
            System.out.println("Got it: Yes");
        } else {
            System.out.println("Got it: No");
        }
        System.out.println("Playing time: " + playingTime);
        System.out.println("Comment: " + comment);
        System.out.println("Platform: " + platform);
        System.out.println("No. of players: " + numberOfPlayers);
    }
    
    
}
