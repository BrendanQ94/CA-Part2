package ie.lyit.Hotel;

import ie.lyit.Hotel.Name;
import java.io.Serializable;

public class Name implements Serializable {
	private String title;
	private String firstName;
	private String surname;
	
	public Name() {
		//title=firstName=surname=null;
		
	}
	
	public Name(String t, String fn, String sn) {
		
		this.title = t;
		this.firstName = fn;
		this.surname = sn;
		
	}
	@Override
	public String toString() {
	
		return   title + "  " + firstName + "  " + surname;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		Name nObject;
		if(obj instanceof Name)
			nObject = (Name)obj;
		else
			return false;
		
		return this.title.equals(nObject.title)
				&& this.firstName.equals(nObject.firstName)
				&& this.surname.equals(nObject.surname);
		
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getSurName() {
		return surname;
	}
	
	public void setTitle(String T) {
		title = T;
	}
	public void setFirstName(String Fn) {
		firstName = Fn;
	}
	public void setSurname(String Sn) {
		surname = Sn;
	}
	
	public boolean isFemale() {
		if(title.equals("Miss") || 
		   title.equals("Ms") || 
	   	   title.equals("Mrs"))
			return true;
		else
			return false;
	}
	}


