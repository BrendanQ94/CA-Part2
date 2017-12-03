package ie.lyit.serialize;



import ie.lyit.Hotel.Customer;

public interface CustomerDAO {
	
	public void add();
	
	public Customer view();

	public void list();
		
	public void edit(); 
	   			
	public void delete(); 
	
	public void writeRecordsToFile();
	
	public void readRecordsFromFile();
}
