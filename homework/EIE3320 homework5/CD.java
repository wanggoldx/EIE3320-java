public class CD extends Item
{
    // instance variables - replace the example below with your own
    private String artist;
    private int numberOfTracks;
    
    public CD(String theTitle, String theArtist, int tracks, int time)
    {
        super(theTitle,time);
        this.artist = theArtist;
        this.numberOfTracks = tracks;
    }

    public void print()
    {
        System.out.println("CD");
        super.print();
        System.out.println("Artist: " + artist);
        System.out.println("No. of tracks: " + numberOfTracks);
    }   
    
    public String toString()
    {
        String s = super.tostring() + artist + numberOfTracks;
        return s;
    } 
}
