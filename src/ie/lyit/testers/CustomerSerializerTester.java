package ie.lyit.testers;

import java.util.Scanner;

import ie.lyit.serialize.CustomerSerializer;

public class CustomerSerializerTester {
	
	public static void main(String[] args) {
		CustomerSerializer CustomerSerializer = new CustomerSerializer();
		
		// Deserialize the ArrayList from the File,
		// i.e. read the customers ArrayList from the file back into the ArrayList
		CustomerSerializer.readRecordsFromFile();
		int option = 0;
		Scanner kbInt = new Scanner(System.in);
	    // Create a Menu Object
	//	Menu menuObj = new Menu();
		do{
			System.out.println("Select one of the following options ");
			System.out.println("1 - Add");
			System.out.println("2 - View");
			System.out.println("3 - Edit");
			System.out.println("4 - Delete");
			System.out.println("5 - List");
			System.out.println("6 - Quit\n--");
			option=kbInt.nextInt();
			if(option == 1)
			{
				CustomerSerializer.add();
			}
			else if(option == 2)
			{
				CustomerSerializer.view();
			}
			else if(option == 3)
			{
				CustomerSerializer.edit();
			}
			else if(option == 4)
			{
				CustomerSerializer.delete();
			}
			else if(option == 5)
			{
				CustomerSerializer.list();
			}
			else if(option == 6)
			{
				break;
			}
			else 
			{
				System.out.println("Invaild Option");
			}
		}while(option != 6);	
																			
		// Serialize the ArrayList to the File
		// i.e. write the customers ArrayList back into the the file		
		CustomerSerializer.writeRecordsToFile();
		
	}
}