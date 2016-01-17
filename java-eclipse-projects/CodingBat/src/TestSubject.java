/**
 *
 * @author Admin
 */


import java.io.*;
import java.util.*;


public class TestSubject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Creating an arrayList of subjects
        ArrayList<Subject> subjects = new ArrayList<Subject>();
        //Creating an instance of new subject
        Subject aSubject = new Subject();

        /* Loading Existing records from File to ArrayList
         * Text file is created in a way that separates the name and
         * subject code by a comma (,)
         */
        try {
        Scanner input = new Scanner(new File("H:\\subjectCode.txt"));
        while(input.hasNextLine()){
            //This creates a token of string or substring of string to create
            //an StringTokenizer object split by comma.
            //In this, it creates two tokens - name and code
            StringTokenizer line = new StringTokenizer(input.nextLine(),",");
            while (line.hasMoreTokens()) {
                /*
                 * Creating new instances of the Subject class
                 * and passing each subject name and code from the txt file
                 * Adding each subject object to the arraylist
                 */
                subjects.add(new Subject(line.nextToken(),line.nextToken()));
            }
         }

        //closing the file
        input.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }


        /*Allowing to Add New Subjects*/
        /* Instanciating scanner class*/
        Scanner keyboardInput = new Scanner(System.in);

        //creating boolean varaible to check if data is added to file or not
        // this is because, file is updated only if data is appended
        boolean isAdded = false;

        boolean repeat = true;

        //while repeat is true, keep asking user to enter subject after the end
        //of each adding
        while(repeat){
        //Asking user if they want to add a subject
            System.getProperty("line.separator");
            System.out.print("Do you want to add subject? (Y/N)");
            //If y/Y then display all discipline areas
            if(keyboardInput.nextLine().equalsIgnoreCase("Y")){
                  //Call the allDisciplines () method to get an arrayList of all unique disciplines
                  //Loop through and display all codes
                System.out.println("The existing discipline Codes are: ");
                ArrayList<String> disciplineCodes = aSubject.allDisciplines(subjects);
                  Iterator<String> iterDisCode = disciplineCodes.iterator();
                  while(iterDisCode.hasNext()){
                      System.out.println(iterDisCode.next());
                  }

                  //Ask user to enter discipline code
                  System.out.print("Enter a Discipline Code:");
                 String disciplineCodeInput = (keyboardInput.nextLine()).toUpperCase();
                 System.out.println("The subject codes of discipline " + disciplineCodeInput + " are: ");
                  //Call codePerDiscipline() method to display all digit codes beloning the the user entered discipline
                  ArrayList<String> subjectCodesPerDiscipline = aSubject.codesPerDiscipline(subjects, disciplineCodeInput);
                  Iterator<String> iterSubCodePerDis = subjectCodesPerDiscipline.iterator();
                  while(iterSubCodePerDis.hasNext()){
                      System.out.println(iterSubCodePerDis.next());
                  }

                  //Ask user to enter subject code
                  System.out.print("Enter a Subject Code:");

                  String subjectCodeInput = (keyboardInput.nextLine()).toUpperCase();
                  //If the code exists and is valid - call each function to check this - then
                  if(aSubject.isValidCode(subjectCodeInput) && !aSubject.codeExists(subjects, subjectCodeInput)){
                      //Ask user for the name of the subject
                      System.out.print("Enter Subject Name for the Code "+subjectCodeInput+": ");
                      String subjectNameInput = keyboardInput.nextLine();
                      //Invoke subject method by adding name and code to the Subject object
                      subjects.add(new Subject(subjectCodeInput,subjectNameInput));
                      //isAdded changed to true
                      isAdded = true;
                  }

                } else{
                    //Stop loop if user doesnt enter y or Y
                    repeat=false;
                }
        }// end of while(repeat)

        if(isAdded){
            try {
            //Open the file to update data
                PrintWriter writer = new PrintWriter("subjectLists.txt");
            Iterator<Subject> iterator = subjects.iterator();
                while(iterator.hasNext()){
                    //Write each line (name and code) to the file
                    writer.println(iterator.next().toSting());
                }
            writer.close();

            }catch(IOException e){
                e.printStackTrace();
            }

        }


    }// end of main function

}
