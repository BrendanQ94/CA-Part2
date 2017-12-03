package ie.lyit.serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import ie.lyit.Hotel.Customer;

public class CustomerSerializer implements CustomerDAO {
	private ArrayList<Customer> customers;
	
	private final String FILENAME = "customers.ser";
	
	// Default Constructor
	public CustomerSerializer() {
		//Construct CustomerList ArrayList
		customers = new ArrayList<Customer>();
	}
	@Override
	public void add() {
		//Create a new Customer object
		Customer Customer = new Customer();
		//Read in its details
		Customer.read();
		//add it to the customers arraylist
		Customer.setNumber(customers.size() + 1);
		customers.add(Customer);
	}
	//Displays an object within the arraylist
	@Override
	public Customer view() {
		//Text asking for input and even giving the range of number to choose from
		System.out.println("Enter the Customer Number. Available Numbers range between 1 and " + customers.size());
		Scanner kbInt = new Scanner(System.in);
	   	int option=kbInt.nextInt();
	   	
	   	//If the entered number matches a number in the arraylist then it will display it
	   	for(Customer tmpCust: customers) {
	   		if(tmpCust.getNumber() == option)
	   		{
	   			System.out.println(tmpCust);
	   			//returns the found customer for use with delete and edit
	   			return tmpCust;
	   		}
	   
	   	}
	   	//returns if the entered number was not found
	   	return null;
	}
	//lists everything in the arraylist
	@Override
	public void list() {
		for(Customer tmpCust:customers)
			System.out.println(tmpCust + "  " + tmpCust.getNumber() );
	}
	//Allows you to rewrite an object in the arraylist
	@Override
	public void edit() {
	   	Customer tempCust = view();
		// If the customer != null, i.e. it was found then...
	    if(tempCust != null){
		   // get it's index
		   int index=customers.indexOf(tempCust);
		   // read in a new customer and...
		   tempCust.read();
		   // reset the object in customers
		   customers.set(index, tempCust);
	   			
	   	}
	}
	//deletes an object in the arraylist
	@Override
	public void delete() {
	 // Call view() to find, display, & return the customer to delete
	 		Customer tempCust = view();
	 		// If the customer != null, i.e. it was found then...
	 	    if(tempCust != null) 
	 		   // ...remove it from customers
	 	       customers.remove(tempCust);
	 	    int newCustNumber = 1;
	 	    	for(Customer tmpCust: customers)
	 	    	{
	 	    		
	 	    		tmpCust.setNumber(newCustNumber);
	 	    		newCustNumber ++;
	 	    		
	 	    	}
	 	    
	}
	// This method will serialize the Customers ArrayList when called, 
		// i.e. it will write it to a file called customers.ser
	@Override
		public void writeRecordsToFile(){
			ObjectOutputStream os=null;
			try {
				// Serialize the ArrayList...
				FileOutputStream fileStream = new FileOutputStream(FILENAME);
			
				os = new ObjectOutputStream(fileStream);
					
				os.writeObject(customers);
			}
			catch(FileNotFoundException fNFE){
				System.out.println("Cannot create file to store customers.");
			}
			catch(IOException ioE){
				System.out.println(ioE.getMessage());
			}
			finally {
				try {
					os.close();
				}
				catch(IOException ioE){
					System.out.println(ioE.getMessage());
				}
			}
		}

		// This method will deserialize the customers ArrayList when called, 
		// i.e. it will restore the ArrayList from the file customers.ser
	@Override
		public void readRecordsFromFile(){
			ObjectInputStream is=null;
			
			try {
				// Deserialize the ArrayList...
				FileInputStream fileStream = new FileInputStream(FILENAME);
			
				is = new ObjectInputStream(fileStream);
					
				customers = (ArrayList<Customer>)is.readObject();
				
			}
			catch(FileNotFoundException fNFE){
				System.out.println("Cannot create file to store Customers.");
			}
			catch(IOException ioE){
				System.out.println(ioE.getMessage());
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
			finally {
				try {
					is.close();
				}
				catch(IOException ioE){
					System.out.println(ioE.getMessage());
				}
			}
		}
}
