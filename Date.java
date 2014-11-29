/*INSY 4305-002 Homework 3
Joel Smith
Raude Woods
Madhu Dhakal
Sudhir Kayastha
*/ 
 public class Date
{
	private int month;
	private int day;
	private int year;
	
	public Date(int _month, int _day, int _year)
	{
		setMonth(_month);
		setDay(_day);
		setYear(_year);
		
	}//End Date Constructor
	
	//get Methods
	public  int getMonth()
	{
		return month;
	}
	public  int getDay()
	{
		return day;
	}
	public  int getYear()
	{
		return year;
	}

	//set Methods
	public  void setMonth(int _month)
	{
		month = _month;
	}
	
	public  void setDay(int _day)
	{
		day = _day;
	}
	
	public  void setYear(int _year)
	{
		year = _year;
	}
	
	//toString Method
	public String toString()
	{
		return (month + "-" + day + "-" + year);
	}
	
	public static Date parseDate(String _date)
	{
		String tmpLoc="";
 
		//System.out.println("Date Passed :" + _date + "\n");
		try
		{
			//check for the delimiter being passed
			char[] delims = { '/', '\\', '_', '-' };
			String delim ="";
			int 	yr = 0, 
					dy = 0,
					mo = 0;
			
			for(int i = 0 ; i < delims.length ; i++)
			{
 				if(_date.indexOf(delims[i])>0)
				{ 
					delim = String.valueOf(delims[i]); 
				}			
			}			
			
			//System.out.println("Date delim=" + delim);
			
			String[] tDate = _date.split(delim);
			
			//System.out.println( tDate[0] + "\n\r" + tDate[1] + "\n\r" + tDate[2] + "\n\r") ;
			//Find the Year location
			if(tDate[0].length()==4) 
			{
				// YYYYdMMdDD
				yr = 0;
				mo = 1;
				dy = 2;
 
			}
			else if(tDate[1].length()==4) 
			{
				// MMdYYYYdDD
				yr = 1;
				mo = 0;
				dy = 2;
 
			}
			else if(tDate[2].length()==4) 
			{
				// MMdDDdYYYY
				yr = 2;
				mo = 0;
				dy = 1;

			}
			
			//System.out.println("Year : " + tDate[yr] + "\n\rMonth:" + tDate[mo] + "\n\rDay  :" + tDate[dy] + "\n\r") ;
			
			if(Integer.parseInt(tDate[mo])>12)
			{
				tmpLoc = " Month:" + tDate[mo];
				int err = 1/0;

			}
			if(Integer.parseInt(tDate[dy])>31)
			{
				tmpLoc += " Day:" + tDate[dy];
				int err = 1/0;
			}	
			if(Integer.parseInt(tDate[yr])<1000 || Integer.parseInt(tDate[yr])>9999)
			{
				tmpLoc = " Year:" + tDate[yr];				
				int err = 1/0;
			}
						

			Date dateOut = new Date( 
			Integer.parseInt(tDate[mo]),
			Integer.parseInt(tDate[dy]), 
			Integer.parseInt(tDate[yr]));
			return dateOut;
		}
		catch(Exception exc)
		{
			System.out.println("Parsing the Date - Error. "+ tmpLoc);
			throw exc;
		}
	}
}//End Class