package javaMVCHomework;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class CalendarDays {

	public static void main(String[] args)  {
	
	Scanner scanner = new Scanner(System.in);	
		
	System.out.println("請輸入月份");
	String m = scanner.next();
	System.out.println("請輸入日期");
	String n = scanner.next();	
	
	Calendar ca = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    String dayString = "2020/"+m+"/"+n;
    System.out.println("你查詢的日期為"+dayString);
    try {
//		System.out.println(sdf.parse(dayString));
	    Date date =sdf.parse(dayString);	    
	    ca.setTime(date);
	    System.out.println(m+"月"+n+"日為今年的第"+ca.get(Calendar.DAY_OF_YEAR)+"天");
	    
	} catch (ParseException e) {
		e.printStackTrace();
	}
		
	}

}
