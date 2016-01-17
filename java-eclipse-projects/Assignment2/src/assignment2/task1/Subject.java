package assignment2.task1;

import java.util.*;

public class Subject {
    
    private String subName;
    private String subCode;
    
    /* Construct an object of Subject class with defined 
     * subject name and subject code 
     */
    public Subject(String subName, String subCode) {
        this.subName = subName.toUpperCase();	//changing the name to upper case
        this.subCode = subCode.toUpperCase();	//changing the code to upper case
    }
    
    /* Return subject name */
    public String getSubName() {
        return subName;
    }
    
    /* Return subject code */
    public String getSubCode() {
        return subCode;
    }
    
    /* Return discipline of the subject */
    public String getDiscipline() {
        
        String discipline = getSubCode().substring(0,3);
        return discipline;
    }
    
    /* Check if entered subject code is valid */
    public static boolean codeMatches(String subCode) {
    	
        //regular expression of subject code format
    	String regex = "[a-zA-Z]{3}[0-9]{3}";	
    	
        if(subCode.matches(regex)) {
            return true;
        }
        else 
            return false;
    }
    
    /* Return the subject code and subject name */
    public String toString() {
        String str = "";
        
        str = String.format("The subject name is %s and the subject code is %s", subName, subCode);
        return str;        
    }
    
    /* Return the list of disciplines of the subjects passed to this method */
    public static ArrayList<String> allDisciplines(ArrayList<Subject> subjects) {
        
        //Holds disciplines
        ArrayList<String> disciplines = new ArrayList<String>();
        ArrayList<String> noDuplicates = new ArrayList<String>();
        
        for(Subject sub: subjects) {
            String discipline = sub.getDiscipline();   //getting discipline 
            disciplines.add(discipline);	//adding the discipline to list
        }
        
        Collections.sort(disciplines);  //sorts the ArrayList in alphabetical order
        String previousDiscipline = "";
        
        for(String s: disciplines) {
         
            //check if the discipline already exists
            if(!previousDiscipline.equalsIgnoreCase(s)) {
            	noDuplicates.add(s);    //adding discipline to ArrayList
            	previousDiscipline = s;
            }
            else {
            	continue;
            }
        }
        return noDuplicates;
    }
    
    /* Return a list of subject codes for the discipline passed to this method */
    public static ArrayList<String> codesPerDiscipline(ArrayList<Subject> subjects, String discipline) {
        
        //Holds subject codes
        ArrayList<String> subCodes = new ArrayList<String>();
        
        for(Subject sub: subjects) {
            String subjectCode = sub.getSubCode();  //getting subject code
            
            //check if the disciplines are same
            if(discipline.compareToIgnoreCase(sub.getDiscipline()) == 0) {
                subCodes.add(subjectCode);  
            }
        }
        
        return subCodes;        
    }
    
    /* Return boolean value to determine if the code passes to this method 
     * can be accepted as a subject code or not
     */
    public static boolean isValidCode(String subCode) {
        
        boolean test1 = false;
        boolean test2 = false;
        
        if(subCode.length() == 6) {
	        	
	        String firstHalf = subCode.substring(0,3);  //create a substring to check for alphabet content
	        String secondHalf = subCode.substring(3);   //create a substring to check for numeric content
	        
	        //check for alphabetic content
	        for(int i=0; i<3; i++) {
	            if(Character.isLetter(firstHalf.charAt(i))){
	                test1 = true;
	            }
	            else {
	                test1 = false;
	                break;
	            }
	        }
	      //check for numeric content
	        for(int i=0; i<3; i++) {
	            if(Character.isDigit(secondHalf.charAt(i))) {
	                test2 = true;
	            }
	            else {
	                test2 = false;
	            }
	        }
	        
	        //return true if both of above tests are true 
	        if(test1==true && test2==true) {
	            return true;
	        }
	        else
	            return false;
        }
        
        else {
        	return false;
        }
    }
    
    
    /* Check if the subject code passed to this method already exists 
     * and returns boolean value accordingly
     */
    public static boolean codeExists(ArrayList<Subject> subjects, String subCode) {
        
        boolean result = false;
        
        for(Subject subject: subjects) {
            if(subject.getSubCode().compareToIgnoreCase(subCode)==0) {  //checks if the subject codes are same
                result = true;
                break;  //break out of loop when result becomes false
            }
        }
        
        return result;
    }
    
    /* Return an alphabetically sorted array of Subject objects */
    public static ArrayList<Subject> sortDisciplines(ArrayList<Subject> subjects) {
        
        for(int i=0; i<subjects.size(); i++) {
            for(int j=i; j<subjects.size(); j++) {
                
                //check if the subject names are in alphabetical order
                if(subjects.get(i).getSubName().compareToIgnoreCase(subjects.get(j).getSubName())>0) {
                    //exchanging the position of objects
                    Subject tempSub = subjects.get(i);
                    subjects.set(i, subjects.get(j));
                    subjects.set(j, tempSub);
                }
            }
        }
        
        return subjects;
    }
}