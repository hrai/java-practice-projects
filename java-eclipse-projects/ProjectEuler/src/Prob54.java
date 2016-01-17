import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


public class Prob54 {
	
	public static void main(String[] args) throws IOException {
		
		ArrayList<Hand> handsList = readFromFile("E:\\Eclipse Projects\\ProjectEuler\\src\\poker.txt");
		
		for(int i=0; i<handsList.size(); i++) {
			
		}
		
	}
	
	public static ArrayList<Hand> readFromFile(String filePath) throws IOException {
		ArrayList<Hand> handsList = new ArrayList<Hand>();
		
		Path fPath = FileSystems.getDefault().getPath(filePath);
		BufferedReader br = Files.newBufferedReader(fPath, StandardCharsets.UTF_8);
		String fileString = "";
		
		//Read file's contents
		while((fileString = br.readLine()) != null) {
			String[] cards = fileString.split(" ");	//Splitting the read string
			
			//Creating Hand objects using the card values read from file
			Hand player1 = new Hand(cards[0], cards[1], cards[2], cards[3], cards[4]);
			Hand player2 = new Hand(cards[5], cards[6], cards[7], cards[8], cards[9]);
			
			//Adding Hand objects to list
			handsList.add(player1);
			handsList.add(player2);
		}
		
		return handsList;
	}

	/**
	 * This method determines the winner. If player one wins, true is returned else false is returned.
	 * 
	 * @param player1
	 * @param player2
	 * @return
	 */
	public static boolean chooseWinner(Hand player1, Hand player2) {
		
		
		return true;
	}
}
