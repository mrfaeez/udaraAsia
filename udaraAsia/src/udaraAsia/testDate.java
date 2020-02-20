package udaraAsia;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class testDate {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
		Calendar date = new GregorianCalendar(2013,1,28,13,24,56);
		
		date.add(date.DAY_OF_MONTH, 1);
		
		
		System.out.println(sdf.format(date.getTime()));
	}

}
