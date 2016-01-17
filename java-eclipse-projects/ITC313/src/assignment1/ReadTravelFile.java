package assignment1;
import java.util.*;
import java.io.*;

public class ReadTravelFile {
	@SuppressWarnings({ "unused", "rawtypes" })
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		File f = new File("E:\\assignment1.dat");
		
		ObjectInputStream os = new ObjectInputStream(new FileInputStream(f));
		
		Object o;
		while((o = os.readObject()) != null) {
			if(o instanceof List) {
				List customers = (List)o;
			}
			else
				
				System.out.println(((Flight)o).getFlightNum());
				System.out.println(((Flight) o).getMovieList());
			
		}
		
		
		os.close();
	}
}
