//Name: Lau Wang Chun,21100151d
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;

import java.io.*;

public class GUI extends JFrame
{
	String[] columns={"ISBN","Title","Available"};
	DefaultTableModel tableModel = new DefaultTableModel(columns,0){
	    @Override
	    public boolean isCellEditable(int row, int column) {
	       //all cells false
	       return false;
	    }
	};
	JTable Table = new JTable(tableModel);
	JScrollPane sp = new JScrollPane(Table);
	
	JButton Add = new JButton("Add"); 
	JButton Edit = new JButton("Edit"); 
	JButton Save = new JButton("Save"); 
	JButton Delete = new JButton("Delete"); 
	JButton Search = new JButton("Search"); 
	JButton More = new JButton("More>>"); 
	JButton Load = new JButton("Load Test Data"); 
	JButton Display = new JButton("Display All"); 
	JButton Display_ISBN = new JButton("Display All by ISBN"); 
	JButton Display_Title = new JButton("Display All by Title"); 
	JButton Exit = new JButton("Exit"); 
	JButton Borrow = new JButton("Borrow");
	JButton Return = new JButton("Return");
	JButton Reserve = new JButton("Reserve");
	JButton Waiting = new JButton("Waiting Queue");
	JButton Export = new JButton("Export");
	JButton Import = new JButton("Import");
	
	JTextField ISBNInput = new JTextField(10); 
	JTextField TitleInput = new JTextField(10); 
    Container c=getContentPane();
    
	int editbook=0;
	
    MyLinkedList<Book> bookLinkedList = new MyLinkedList<Book> ();
    JFrame MorePage=new JFrame(TitleInput.getText());
	JTextArea Bookinfo = new JTextArea(5,5);
	JPanel MorePagepanel = new JPanel();
	JTextArea systemMessage = new JTextArea(1,5);
	public GUI()
	{	
		Save.setEnabled(false);
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.CENTER));
		p2.add(new JLabel("ISBN: "));
		p2.add(ISBNInput);
		p2.add(new JLabel("Title: "));
		p2.add(TitleInput);
		
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.CENTER));
		p3.add(Add);
		p3.add(Edit);
		p3.add(Save);
		p3.add(Delete);
		p3.add(Search);
		p3.add(More);
		
		JPanel p4 = new JPanel();
		p4.setLayout(new FlowLayout(FlowLayout.CENTER));
		p4.add(Export);
		p4.add(Import);
		p4.add(Load);
		p4.add(Display);
		p4.add(Display_ISBN);
		p4.add(Display_Title);
		p4.add(Exit);
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(3,1));
		p1.add(p2);
		p1.add(p3);
		p1.add(p4);
		
		JTextArea jTextArea = new JTextArea(5,20);
		jTextArea.setEditable(false);
		Date date = new Date();
		jTextArea.append("Student Name and ID: Lau Wang Chun (21100151d)\n");
		jTextArea.append(date.toString());
		
	    JPanel p5 = new JPanel(new BorderLayout());
	    p5.add(jTextArea, BorderLayout.NORTH);
	    p5.add(sp, BorderLayout.CENTER);
	    p5.add(p1, BorderLayout.SOUTH);
	    
	    c.add(p5);
	    
	    ButtonListener listener = new ButtonListener(); 
	    
	    Add.addActionListener(listener);
	    Load.addActionListener(listener);
	    Edit.addActionListener(listener);
	    Save.addActionListener(listener);
	    Delete.addActionListener(listener);
	    Search.addActionListener(listener);
	    Display.addActionListener(listener);
	    Display_ISBN.addActionListener(listener);
	    Display_Title.addActionListener(listener);
	    More.addActionListener(listener);
	    Exit.addActionListener(listener);
	    Borrow.addActionListener(listener);
	    Reserve.addActionListener(listener);
	    Waiting.addActionListener(listener);
	    Return.addActionListener(listener);
	    Export.addActionListener(listener);
	    Import.addActionListener(listener);
		Table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = Table.getSelectedRow();
				String ISBNValue = (Table.getModel().getValueAt(row, 0).toString());
				String titleValue = (Table.getModel().getValueAt(row, 1).toString());
				ISBNInput.setText(ISBNValue);
				TitleInput.setText(titleValue);	
			}
		}
		);
	}
	
	public void displaytotable()
	{
		tableModel = new DefaultTableModel(columns,0){	
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		Table.setModel(tableModel);
		for(int i=0;i< bookLinkedList.size();i++)
		{
			String[] info = {bookLinkedList.get(i).getISBN(), bookLinkedList.get(i).getTitle(), String.valueOf(bookLinkedList.get(i).getAvailable())};    
			tableModel.addRow(info);
		}
	}
	
	public void clearTextfield()
	{
		ISBNInput.setText("");
        TitleInput.setText("");
	}
	
	boolean ISBNsortorder=true,Titlesortorder=true;
	public void sorting(String name)
	{
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(Table.getModel());
		Table.setRowSorter(sorter);
		List<RowSorter.SortKey> sortKeys = new ArrayList<>();
		 
		if(name=="ISBN"&&ISBNsortorder)
		{
			ISBNsortorder=false;
			sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
		}
		else if (name=="ISBN"&&!ISBNsortorder)
		{
			ISBNsortorder=true;
			sortKeys.add(new RowSorter.SortKey(0, SortOrder.DESCENDING));
		}
		else if(name=="Title"&&Titlesortorder)
			
		{
			Titlesortorder=false;
			sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
		}
		else
		{
			Titlesortorder=true;
			sortKeys.add(new RowSorter.SortKey(1, SortOrder.DESCENDING));
		}
		 
		sorter.setSortKeys(sortKeys);
		sorter.sort();
	}
	
	class ButtonListener implements ActionListener 
    {
    	public void actionPerformed(ActionEvent e) 
    	{
    	if (e.getSource() == Add)
    	{
    		boolean ISBNrepeated=false;
    		for(int i = 0;i<bookLinkedList.size();i++) 
				if(ISBNInput.getText().equals(bookLinkedList.get(i).getISBN())) 
					ISBNrepeated = true;
    		if(ISBNInput.getText().equals(""))
    		{
    			 JOptionPane.showMessageDialog(null, "Error: ISBN cannot be blank", "Error", JOptionPane.ERROR_MESSAGE);
    		}
    		else if (TitleInput.getText().equals(""))
    		{
    			JOptionPane.showMessageDialog(null, "Error: Title cannot be blank", "Error", JOptionPane.ERROR_MESSAGE);
    		}
    		else if (ISBNrepeated)
    		{
    			JOptionPane.showMessageDialog(null, "Error: ISBN is repeated", "Error", JOptionPane.ERROR_MESSAGE);
    		}
    		else
    		{
    			Book book1 = new Book();
    	        book1.setISBN(ISBNInput.getText());
    	        book1.setTitle(TitleInput.getText());
    	        book1.setAvailable(true);	
    	        bookLinkedList.add(book1);	
    	        
    	        displaytotable();
    	        clearTextfield();
    		}
    	}
    	else if (e.getSource() == Load)
    	{
    		boolean loaddata1=true,loaddata2=true,loaddata3=true;
    		for(int i = 0;i<bookLinkedList.size();i++) 
    		{
				if("0131450913".equals(bookLinkedList.get(i).getISBN())) 
					loaddata1 = false;
	    		if("0131857576".equals(bookLinkedList.get(i).getISBN())) 
					loaddata2 = false;
	    		if("0132222205".equals(bookLinkedList.get(i).getISBN())) 
					loaddata3 = false;
    		}
    		if(loaddata1)
    		{
	    		Book book1 = new Book();
		        book1.setISBN("0131450913");
		        book1.setTitle("HTML How to Program");
		        book1.setAvailable(true);	
		        bookLinkedList.add(book1);	
    		}
    		else
    			JOptionPane.showMessageDialog(null, "Error: HTML How to Program with ISBN:0131450913 already exist", "Error", JOptionPane.ERROR_MESSAGE);
    		if(loaddata2)
    		{
    			Book book2 = new Book();
    	        book2.setISBN("0131857576");
    	        book2.setTitle("C++ How to Program");
    	        book2.setAvailable(true);	
    	        bookLinkedList.add(book2);	
    		}
    		else
    			JOptionPane.showMessageDialog(null, "Error: C++ How to Program with ISBN:0131857576 already exist", "Error", JOptionPane.ERROR_MESSAGE);
    		if(loaddata3)
    		{
    			Book book3 = new Book();
    	        book3.setISBN("0132222205");
    	        book3.setTitle("Java How to Program");
    	        book3.setAvailable(true);	
    	        bookLinkedList.add(book3);	
    		}
    		else
    			JOptionPane.showMessageDialog(null, "Error: Java How to Program with ISBN:0132222205 already exist", "Error", JOptionPane.ERROR_MESSAGE);
  	        
    		displaytotable();
    		clearTextfield();
    	}
    	else if (e.getSource() == Edit)
    	{
    		String ISBNchecked=ISBNInput.getText();	
    		boolean ISBNrepeated=false;
    		for(int i = 0;i<bookLinkedList.size();i++) 
				if(ISBNchecked.equals(bookLinkedList.get(i).getISBN()))
				{
					ISBNrepeated = true;
					editbook=i;
				}
    		if (bookLinkedList.size()==0)
    		{
    			JOptionPane.showMessageDialog(null, "Error: No data in the DataBase", "Error", JOptionPane.ERROR_MESSAGE);
    		}
    		else if (ISBNrepeated == false)
    		{
    			JOptionPane.showMessageDialog(null, "Error: Book ISBN is not in the DataBase", "Error", JOptionPane.ERROR_MESSAGE);
    		}
    		else
    		{
    			TitleInput.setText(bookLinkedList.get(editbook).getTitle());
    			Save.setEnabled(true);
        		Add.setEnabled(false);
        		Edit.setEnabled(false);
        		Delete.setEnabled(false);
        		Search.setEnabled(false);
        		More.setEnabled(false);
        		Load.setEnabled(false);
        		Display.setEnabled(false);
        		Display_ISBN.setEnabled(false);
        		Display_Title.setEnabled(false);
        		Exit.setEnabled(false);
        		Import.setEnabled(false);
        		Export.setEnabled(false);
    		}	
    	}
    	else if (e.getSource() == Save)
    	{
    		boolean ISBNrepeated=false;
    		for(int i = 0;i<bookLinkedList.size();i++) 
				if(ISBNInput.getText().equals(bookLinkedList.get(i).getISBN()))	
					ISBNrepeated = true;
    		if (ISBNInput.getText().equals(bookLinkedList.get(editbook).getISBN())==false && ISBNrepeated == true)
    		{
    			JOptionPane.showMessageDialog(null, "Error: Book ISBN exist in the current DataBase", "Error", JOptionPane.ERROR_MESSAGE);
    		}
    		else
    		{
    			bookLinkedList.get(editbook).setISBN(ISBNInput.getText());
    			bookLinkedList.get(editbook).setTitle(TitleInput.getText());
    			Save.setEnabled(false);
        		Add.setEnabled(true);
        		Edit.setEnabled(true);
        		Delete.setEnabled(true);
        		Search.setEnabled(true);
        		More.setEnabled(true);
        		Load.setEnabled(true);
        		Display.setEnabled(true);
        		Display_ISBN.setEnabled(true);
        		Display_Title.setEnabled(true);
        		Exit.setEnabled(true);
        		Import.setEnabled(true);
        		Export.setEnabled(true);
        		
        		displaytotable();
        		clearTextfield();
    		}	
    	}
    	else if (e.getSource() == Delete)
    	{
    		boolean ISBNrepeated=false;
    		for(int i = 0;i<bookLinkedList.size();i++) 
				if(ISBNInput.getText().equals(bookLinkedList.get(i).getISBN()))	
				{
					ISBNrepeated = true;
					editbook=i;
				}
    		if (bookLinkedList.size()==0)
    		{
    			JOptionPane.showMessageDialog(null, "Error: No data in the DataBase", "Error", JOptionPane.ERROR_MESSAGE);
    		}
    		else if (ISBNrepeated == false)
    		{
    			JOptionPane.showMessageDialog(null, "Error: Book ISBN is not in the DataBase", "Error", JOptionPane.ERROR_MESSAGE);
    		}
    		else
    		{
    			bookLinkedList.remove(editbook);
    		}
    		displaytotable();
    		clearTextfield();
    	}
    	else if (e.getSource() == Search)
    	{
    		tableModel = new DefaultTableModel(columns,0);
			Table.setModel(tableModel); 
			if (ISBNInput.getText().equals("")&&TitleInput.getText().equals("")) {displaytotable();}
			else if (ISBNInput.getText().equals("")==false&&TitleInput.getText().equals("")==true)
    		{
    			for(int i = 0;i<bookLinkedList.size();i++) 
    				if(bookLinkedList.get(i).getISBN().contains(ISBNInput.getText()))
    				{   					
    					String[] info = {bookLinkedList.get(i).getISBN(), bookLinkedList.get(i).getTitle(), String.valueOf(bookLinkedList.get(i).getAvailable())};    
    					tableModel.addRow(info);
    				}
    		}
			else if (ISBNInput.getText().equals("")==true&&TitleInput.getText().equals("")==false)
    		{
    			for(int i = 0;i<bookLinkedList.size();i++) 
    				if(bookLinkedList.get(i).getTitle().contains(TitleInput.getText()))
    				{   					
    					String[] info = {bookLinkedList.get(i).getISBN(), bookLinkedList.get(i).getTitle(), String.valueOf(bookLinkedList.get(i).getAvailable())};    
    					tableModel.addRow(info);
    				}
    		}
			else if (ISBNInput.getText().equals("")==false&&TitleInput.getText().equals("")==false)
    		{
    			for(int i = 0;i<bookLinkedList.size();i++) 
    				if(bookLinkedList.get(i).getISBN().contains(ISBNInput.getText())||bookLinkedList.get(i).getTitle().contains(TitleInput.getText()))
    				{   					
    					String[] info = {bookLinkedList.get(i).getISBN(), bookLinkedList.get(i).getTitle(), String.valueOf(bookLinkedList.get(i).getAvailable())};    
    					tableModel.addRow(info);
    				}
    		}
    		clearTextfield();
    	}
    	else if (e.getSource() == Display)
    	{
    		displaytotable();
    	}
    	else if (e.getSource() == Display_ISBN)
    	{
    		if(bookLinkedList.size()!=0)
    			sorting("ISBN");
    	}
    	else if (e.getSource() == Display_Title)
    	{
    		if(bookLinkedList.size()!=0)
    			sorting("Title");
    	}
    	else if (e.getSource() == Exit)
    	{
    		System.exit(0);
    	}
    	else if (e.getSource() == More)
    	{
    		boolean ISBNhere=false;
    		for(int i = 0;i<bookLinkedList.size();i++) 
				if(ISBNInput.getText().equals(bookLinkedList.get(i).getISBN()))	
				{
					ISBNhere = true;
					editbook=i;
				}
    		if(ISBNInput.getText()==""||ISBNhere == false)
    		{
    			JOptionPane.showMessageDialog(null, "Error: Book ISBN is not exist in the DataBase", "Error", JOptionPane.ERROR_MESSAGE);
    		}
    		else
    		{
    			MorePage.setSize(500, 400);
    			MorePage.setLocationRelativeTo(null); // Center the frame
    			MorePage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
    			MorePage.setVisible(true);
    			MorePage.setLayout(new BorderLayout());
    			
    			Bookinfo.setEditable(false);
    			Bookinfo.setText("");
    			Bookinfo.append("ISBN: "+ISBNInput.getText()+"\n");
    			Bookinfo.append("Title: "+bookLinkedList.get(editbook).getTitle()+"\n");
    			Bookinfo.append("Available: "+bookLinkedList.get(editbook).getAvailable());
    			MorePage.add(Bookinfo, BorderLayout.NORTH);
    			
    			MorePagepanel.setLayout(new FlowLayout());
    			MorePagepanel.add(Borrow);
    			MorePagepanel.add(Return);
    			MorePagepanel.add(Reserve);
    			MorePagepanel.add(Waiting);  
    			MorePage.add(MorePagepanel, BorderLayout.CENTER);
    			
    			systemMessage.setText("");
    			MorePage.add(systemMessage, BorderLayout.SOUTH);		
    			
    			if(bookLinkedList.get(editbook).getAvailable()==false)
    			{
    				Borrow.setEnabled(false);
    				Return.setEnabled(true);
    				Reserve.setEnabled(true);
    				Waiting.setEnabled(true);
    			}
    			else
    			{
    				Borrow.setEnabled(true);
	    			Return.setEnabled(false);
	    			Reserve.setEnabled(false);
	    			Waiting.setEnabled(false);
    			}
    		}
    	}
    	else if (e.getSource() == Borrow)
        {
    		bookLinkedList.get(editbook).setAvailable(false);
    		Borrow.setEnabled(false);
			Return.setEnabled(true);
			Reserve.setEnabled(true);
			Waiting.setEnabled(true);
			Bookinfo.setText("");
			Bookinfo.append("ISBN: "+ISBNInput.getText()+"\n");
			Bookinfo.append("Title: "+bookLinkedList.get(editbook).getTitle()+"\n");
			Bookinfo.append("Available: "+bookLinkedList.get(editbook).getAvailable());
			systemMessage.setText("The book is borrowed.");
			displaytotable();
        }
    	else if (e.getSource() == Reserve)
        {	
    		String input=JOptionPane.showInputDialog("What's your name?");
    		bookLinkedList.get(editbook).getReservedQueue().enqueue(input);
    		systemMessage.setText("The book is reserved by "+input+".");
    		displaytotable();
        }
    	else if (e.getSource() == Waiting)
        {	
    		systemMessage.setText("The waiting queue:\n");
    		for (int i=0;i<bookLinkedList.get(editbook).getReservedQueue().getList().size();i++)
    			systemMessage.append(bookLinkedList.get(editbook).getReservedQueue().getList().get(i)+"\n");
    		displaytotable();
        }
    	else if (e.getSource() == Return)
        {	
    		if(bookLinkedList.get(editbook).getReservedQueue().getList().size()==0)
    		{
        		systemMessage.setText("The book is returned.");
    			bookLinkedList.get(editbook).setAvailable(true);
    		}
    		else
    		{
    			String next=bookLinkedList.get(editbook).getReservedQueue().dequeue();
    			systemMessage.setText("The book is returned.\n");
    			systemMessage.append("The book is now borrowed by "+next+".");
    		}
    		if(bookLinkedList.get(editbook).getAvailable()==false)
			{
				Borrow.setEnabled(false);
				Return.setEnabled(true);
				Reserve.setEnabled(true);
				Waiting.setEnabled(true);
			}
			else
			{
				Borrow.setEnabled(true);
    			Return.setEnabled(false);
    			Reserve.setEnabled(false);
    			Waiting.setEnabled(false);
    			Bookinfo.setText("");
    			Bookinfo.append("ISBN: "+ISBNInput.getText()+"\n");
    			Bookinfo.append("Title: "+bookLinkedList.get(editbook).getTitle()+"\n");
    			Bookinfo.append("Available: "+bookLinkedList.get(editbook).getAvailable());
			}
    		displaytotable();
        }
    	else if (e.getSource() == Export)
        {
    		File book_record = new File("book_record.txt");
    		PrintWriter output=null;
			try {
				output = new PrintWriter(book_record);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		for(int i = 0;i<bookLinkedList.size();i++) 
    		{
    			output.println(bookLinkedList.get(i).getISBN());
    			output.println(bookLinkedList.get(i).getTitle());
    			output.println(String.valueOf(bookLinkedList.get(i).getAvailable()));
    			output.println(bookLinkedList.get(i).getReservedQueue());
    		}
			output.close();
        }   
    	else if (e.getSource() == Import)
        {
    		File book_record = new File("book_record.txt");
    		try {
				Scanner input = new Scanner(book_record);
				bookLinkedList = new MyLinkedList<Book> ();
				while (input.hasNextLine())
	    		{
					Book book1=new Book();
					MyQueue<String> reservedQueue = new MyQueue<>();
					book1.setISBN(input.nextLine());
					book1.setTitle(input.nextLine());
					book1.setAvailable(Boolean.valueOf(input.nextLine()));
					String a = input.nextLine();
					String[] b = a.split(",");
					for (String c : b) {
						reservedQueue.enqueue(c);
				}
					book1.setReservedQueue(reservedQueue);
					bookLinkedList.add(book1);
					for(int i = 0;i<bookLinkedList.size();i++) 
		    		{
		    			if (bookLinkedList.get(i).getAvailable()==true)
		    			{
		    				bookLinkedList.get(i).getReservedQueue().dequeue();
		    			}
		    		}
	    		}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		displaytotable();
        }

    }
    }
    
	public static void main(String[] args) 
	{
		GUI frame = new GUI();
		frame.setTitle("Library Admin System");
		frame.setSize(800, 500);
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		frame.setVisible(true);

	}
}
