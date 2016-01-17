/**
 * ITC206 Assignment 2 - Task 1
 * @(#)Subject.java
 * Purpose: Class representing a point with 3D coordinates with certain state and functionality.
 *
 * @author Mahima Shrestha
 * @version 1.00 26/05/2011
 */

import java.util.*;

public class Subject {

    /*Two fields for name and code of Subject*/
    private String name;
    private String subjectCode;

    /*No-arg constructor*/
    public Subject(){
	}

    /**Constructing a 'Subject' object by passing a subject name and validated subject code*/
    public Subject(String subjectCode,String name){
           setSubjectCode(subjectCode);
           setName(name);
	}

    /**Mutator or setter method for each of the fields*/
    public void setName(String name){
	this.name = name;
    }
    public void setSubjectCode(String subjectCode){
	this.subjectCode = subjectCode;
    }

    /**Accessor or getter method for each of the fields*/
    public String getName(){
	return this.name;
    }
    public String getSubjectCode(){
	return this.subjectCode;
    }

    /*Accessor Method to return string containing first three characters of subject code*/
    public String getDiscipline(){
	return getSubjectCode().substring(0,3);
    }

    /*Returns boolean value if the code matches another */
    public boolean codeMatches(String anotherSubjectCode){
           return getSubjectCode().matches(anotherSubjectCode);
    }

    /*toString method to return subject code and name*/
    public String toSting(){
	return (getSubjectCode()+ "," + getName());
    }

    /* addDiscipines method to display all unique disciplines in the list
     * subject objects. ArrayList of subject objects is passed the method.
     * Returns arrayList of all unique disciplines
     */
    public ArrayList<String> allDisciplines(ArrayList<Subject> subjects){
        //Creating arrayList to store all disciplines
        ArrayList<String> disciplineCodes = new ArrayList<String>();
        Iterator<Subject> iterator = subjects.iterator();
        while(iterator.hasNext()){
            Subject aSubject = iterator.next();
            //add the code in the arrayList only if the code isn't already
            //existing in the arrayList - this gives unique codes
            if(!disciplineCodes.contains(aSubject.getDiscipline()))
                    disciplineCodes.add(aSubject.getDiscipline());
            }
        //returns the arrayList of disciplineCodes
        return disciplineCodes;

	}

     /*codesPerDiscipline method to display all unique subject codes in the list
     * subject objects that matches the supplied discipline code.
     * ArrayList of subject objects and a disciplineCode string is passed to the method.
     * Returns arrayList of all subject Codes of the particular discipline.
     */
    public ArrayList<String> codesPerDiscipline(ArrayList<Subject> subjects, String disciplineCode){
            ArrayList<String> subjectCodes = new ArrayList<String>();
            Iterator<Subject> iterator = subjects.iterator();
            while(iterator.hasNext()){
                Subject aSubject = iterator.next();
                //add subject code to the arrayList if the disciplineCode is
                //equal to the object's discipline code
                if(aSubject.getDiscipline().equalsIgnoreCase(disciplineCode)){
                   subjectCodes.add(aSubject.getSubjectCode());
               }
            }
            //returns the arrayList of subject Codes
            return subjectCodes;
	}

    //boolean method to check the validity of new subject code supplied
    public boolean isValidCode(String newSubjectCode){

        // return false if the lenght of code is anything other than 6
        if(newSubjectCode.length() != 6)
                return false;
        /* returns true only if the first three charcters are letters
         * and last three are digits.
         * Character checking after converting each element of the code to
         * a chracter.
         */
        else if(Character.isLetter(newSubjectCode.charAt(0)) &&
                    Character.isLetter(newSubjectCode.charAt(1)) &&
                    Character.isLetter(newSubjectCode.charAt(2)) &&
                    Character.isDigit(newSubjectCode.charAt(3)) &&
                    Character.isDigit(newSubjectCode.charAt(4)) &&
                    Character.isDigit(newSubjectCode.charAt(5)))
                return true;
        else
                return false;

        }


    //boolean method to check if the new subject code already exists in the array
    //created from the source file contents
    public boolean codeExists(ArrayList<Subject> subjects, String newSubjectCode){

            Iterator<Subject> iterator = subjects.iterator();
            while(iterator.hasNext()){
                Subject aSubject = iterator.next();
                //return true if code exists
                if(aSubject.getSubjectCode().equalsIgnoreCase(newSubjectCode)){
                   return true;
                 }
            }
            return false;
        }//end codeExists()




}//end Subject
