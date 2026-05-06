public class VideoGame extends Item
{
    // instance variables - replace the example below with your own
    private String platform;
    private int numberOfPlayers;
    
    public VideoGame(String title,String platform,int numberOfPlayers,int playingTime)
    {
        super(title,playingTime);
        this.platform = platform;
        this.numberOfPlayers = numberOfPlayers;
    }

    public void print()
    {
        System.out.println("VideoGame");
        super.print();
        System.out.println("Platform: " + platform);
        System.out.println("No. of players: " + numberOfPlayers);
    }   
}
