//Name: Lau Wang Chun,21100151d
public class Book {
	private String title; // store the title of the book
	private String ISBN; // store the ISBN of the book
	private boolean available; // keep the status of whether the book is available;
	 						   // initially should be true
	private MyQueue<String> reservedQueue = new MyQueue<>(); // store the queue of waiting list
	
	public void setISBN(String ISBN)
	{
		this.ISBN = ISBN;
	}
	
	public String getISBN()
	{
		return ISBN;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setAvailable(boolean available)
	{
		this.available = available;
	}
	
	public boolean getAvailable()
	{
		return available;
	}
	
	public boolean isAvailable()
	{
		return available;
	}
	
	public void setReservedQueue(MyQueue<String> reservedQueue)
	{
		this.reservedQueue = reservedQueue;
	}
	
	public MyQueue<String> getReservedQueue()
	{
		return reservedQueue;
	}
}
