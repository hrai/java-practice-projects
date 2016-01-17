import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class CodingBat {

	public static void main(String[] args) {
        System.out.println(stringToDate("13/01/2012"));
    }
	
	public static Date stringToDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date d = null;
		
		try {
			d = sdf.parse(date);
			System.out.println("m");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(d);
		return d;
	}
	


}
