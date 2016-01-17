package assignment2.task1;

import java.util.*;
import java.io.*;

public class TestSubject {

    public static void main(String[] args) throws IOException{
        
        TestSubject ts = new TestSubject();	//creating instances of TestSubject and Subject classes
        File file = new File("H:\\subjectCode.txt");//creating a File object
        Scanner scanner = new Scanner(System.in);	//creating Scanner object
        
        //populating the list with subjects in an ArrayList
        ArrayList<Subject> subjects = ts.readSubjectCodesFromFile(file);
        int listSize = subjects.size();
                
        System.out.print("Do you want to add a new subjects? (Y/N)");
        
        //check if the input is 'Y'
        if(scanner.nextLine().equalsIgnoreCase("y")) {
        	System.out.printf("The disciplines are: \n");
        	
            do {
            	//print the array of disciplines
                for(String s: Subject.allDisciplines(subjects)) {
                	System.out.println(s);  //print all the disciplines
                }

            	String dCode;
            	do {
            		System.out.println("Please enter a discipline code: ");
                    dCode = scanner.next().toUpperCase();
                    
                    if(ts.checkDiscipline(subjects, dCode) == true) 
                    	break;	//break out of loop if the discipline is correct
            	}
            	while(true);
                
            	System.out.printf("The subject codes in '%s' discipline are: \n", dCode);
    	  		//print all the subject codes in the given discipline
                for(String s: Subject.codesPerDiscipline(subjects, dCode)) {
                	System.out.printf("%s\n", s);
                }
                    
            	do {
            		
            		String sCode;
            		do {
                		//ask user for subject code
                        System.out.println("Please enter a new subject code: ");
                        sCode = scanner.next();
                        
                        if(!Subject.codeExists(subjects, sCode) && Subject.codeMatches(sCode)) 
                        	break; //repeat while the user enters the incorrect subject code and break when the input is right
                	}
                	while(true);	
                	
            		//asking the user for subject name
                    System.out.println("Please enter a subject name: ");
        	        String sName = scanner.next();    
                    
        	        //creating and adding the new Subject object to the list
                	subjects.add(new Subject(sName, sCode));
                	
                	System.out.println("The new subject was created.");
                	String ans;
                	do {
                		//ask if user wants to enter more subjects
                    	System.out.println("Do you want to enter new subject in the same discipline? (Y/N)");
                    	ans = scanner.next();
                    	
                    	if(ans.equalsIgnoreCase("y") || ans.equalsIgnoreCase("n")) {
                    		break;	//break out of loop if the input is either 'y' or 'n'
                    	}
                	}
                	while(true);
                	
                	if(ans.equalsIgnoreCase("n")) {
                		break;	//break out of loop if the input is 'n'
                	}
            	}
            	while(true);
            	
            	String answer;
            	do {
            		//ask if user wants to enter subjects of different discipline
                	System.out.println("Do you want to enter new subject in another discipline? (Y/N)");
                	answer = scanner.next();
                	
                	if(answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n")) {
                		break;	//break out of loop if the input is either 'y' or 'n'
                	}
            	}
            	while(true);
            	
            	if(answer.equalsIgnoreCase("n")) {
            		break;	//break out of loop if the input is 
            	}
            }
            while(true);
            
            if(listSize != subjects.size()) {
            	//writing the codes to file
                ts.writeToFile(subjects, file);
                System.out.println("The new subjects have been written on the file.");
                
            }
            else {
            	System.out.println("No changes was made to the file.");
            }
            
            scanner.close();
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
	    	   
	    	   //converting the string to upper case and splitting the string into subject code and subject name
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
   
    
    /* Write the contents of the list to the file */
    public void writeToFile(ArrayList<Subject> subjects, File f) throws IOException {
        
    	//sorting the subjects in the alphabetical order by their subject name
        Subject.sortDisciplines(subjects);
        
        //creating a printwriter
        PrintWriter pw = new PrintWriter(new FileWriter(f));
        
        for(Subject s: subjects) {
        	//printing the name and the subject code
            pw.printf("%s %s", s.getSubCode(), s.getSubName());	
            pw.println();
        }
        
        //closing the file
        pw.close();
        
        
    }

    
    public boolean checkDiscipline(ArrayList<Subject> subs, String str) {
    	
    	boolean result = false;
    	
    	for(String dspln: Subject.allDisciplines(subs)) {
        	if(str.equalsIgnoreCase(dspln)) {
        		result = true;
            	break;	//break out of loop if the user entered discipline is correct
            }
        }
    	
    	return result;
    }
}   
    