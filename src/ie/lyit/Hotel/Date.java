package ie.lyit.Hotel;

public class Date{
	private int day;
	private int month;
	private int year;

	public Date(){
	   day=month=year=0;
	}


  	public Date(int day, int month, int year){
       this.day = day;
       this.month = month;
	   this.year = year;
   }

	@Override
   public String toString(){
		return (day + "/" + month + "/" + year);
	}
	
	@Override
   public boolean equals(Object o){
		if(o == null) 
         return false;
	
		if (this == o)
			return true;
         
		if(!(o instanceof Date))
			return false;
		else
		{
			Date other = (Date)o;
			
			return (this.day == other.day) &&
				   (this.month == other.month) &&
				   (this.year == other.year);
		}
	}
	
	public int getDay(){
		return day;
	}
	public int getMonth(){
		return month;
	}
	public int getYear(){
		return year;
	}


	public void setDay(int setDayTo) throws IllegalArgumentException{
		if(setDayTo < 1 || setDayTo > 31)
			throw new IllegalArgumentException("Day is out of range");
       day=setDayTo;
	}
 	public void setMonth(int setMonthTo) throws IllegalArgumentException{
 		if(setMonthTo <= 0 || setMonthTo > 12)
		throw new IllegalArgumentException("Month is out of range");
 		
 		month = setMonthTo;
 	}
 	public void setYear(int setYearTo) throws IllegalArgumentException{
 		if(setYearTo < 1900 || setYearTo > 2017)
		throw new IllegalArgumentException("Year is out of range");
 		
 		year = setYearTo;
 	}
 }