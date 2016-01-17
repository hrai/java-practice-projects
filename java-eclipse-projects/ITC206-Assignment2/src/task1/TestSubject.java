package task1;

import java.util.*;
import java.io.*;

public class TestSubject {

    private static Scanner scanner;

	public static void main(String[] args) throws IOException{
        
        TestSubject ts = new TestSubject();	//creating instances of TestSubject and Subject classes
        File file = new File("C:\\Users\\Nick\\Desktop\\subjectCode.txt");//creating a File object
        scanner = new Scanner(System.in);
        String sCode;
        
        //getting the list of subject codes in a ArrayList
        ArrayList<Subject> subjects = ts.readSubjectCodesFromFile(file);
                
        System.out.print("Do you want to add a new subjects? (Y/N)");
        
        //check if the input is 'Y'
        if(scanner.nextLine().equalsIgnoreCase("y")) {
            //print the array
            for(String s: Subject.allDisciplines(subjects)) {
            	System.out.println(s);  //print all the disciplines
            }

            System.out.println("Please enter a discipline code: ");
            String dCode = scanner.next();

	  		//print all the subject codes in the given discipline
            for(String s: Subject.codesPerDiscipline(subjects, dCode)) {
            	System.out.println(s);
            }
                
        	do {
        		//ask user for subject code
                System.out.println("Please enter a new subject code: ");
                sCode = scanner.next();
                
                if(!Subject.codeExists(subjects, sCode) && Subject.isValidCode(sCode)) 
                	break;
        	}
        	while(true);
        	
            System.out.println("Please enter a subject name: ");
	        String sName = scanner.next();    
            
	        //creating and adding the new Subject object to the list
        	subjects.add(new Subject(sCode, sName)); 
	            	
                 
                //System.out.println("Do you want to add another subject code: ");
                
            //writing the codes to file
            ts.writeToFile(subjects, file);
        }
        
    }
    
    /*Read the subject codes from the file and return the list of objects*/
    public ArrayList<Subject> readSubjectCodesFromFile(File f) throws IOException, FileNotFoundException {
       
       String subject;
       
       //list to hold the subject codes
       ArrayList<Subject> subjectList = new ArrayList<Subject>();
       
       try {
    	   //creating a buffered reader to read from the file
	       BufferedReader br = new BufferedReader(new FileReader(f));
		
    	   while((subject = br.readLine()) != null) {
	    	   String regex = "\\s";
	    	   
	    	   //splitting the string into subject code and subject name
	    	   String[] stringArr = subject.split(regex, 2);
	    	   
	    	   //creating objects of type Subject and adding them to arraylist
	    	   subjectList.add(new Subject(stringArr[1], stringArr[0]));	
    	   }
    	   
	       //closing the file
	       br.close();
       }
       catch(FileNotFoundException e) {
    	   e.getMessage();
       } 
       
       return subjectList;
   }
   
    //write the subject codes to file
    
    /* Write the contents of the list to the file */
    public void writeToFile(ArrayList<Subject> subjectCodes, File f) throws IOException {
        
        //creating a printwriter
        PrintWriter pw = new PrintWriter(new FileWriter(f));
        
        for(Subject s: subjectCodes) {
        	//printing the name and the subject code
            pw.printf("%s %s\r\n", s.getSubCode(), s.getSubName());	
        }
        
        //closing the file
        pw.close();
    }
}
    
    