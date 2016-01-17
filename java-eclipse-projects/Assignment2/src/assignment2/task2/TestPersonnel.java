package assignment2.task2;

import java.util.*;

public class TestPersonnel {
    
    /* Create list for storing the staff of the organisation */
    private static LinkedList<Person> staff;
    
    
    public static void main(String[] args) {

    	/* Create managers */
        Manager m1 = new Manager("mgr1");
        Manager m2 = new Manager("mgr2");
        Manager m3 = new Manager("mgr3");
        
        //Create workers
        Worker w1 = new Worker("wkr1");
        Worker w2 = new Worker("wkr2");
        Worker w3 = new Worker("wkr3");
        Worker w4 = new Worker("wkr4");
        Worker w5 = new Worker("wkr5");
        Worker w6 = new Worker("wkr6");
        Worker w7 = new Worker("wkr7");
        Worker w8 = new Worker("wkr8");
        Worker w9 = new Worker("wkr9");
        Worker w10 = new Worker("wkr10");
        Worker w11 = new Worker("wkr11");
        Worker w12 = new Worker("wkr12");
        
        //Array of all the staff in the organisation
        Person[] per = {m1, m2, m3, w1, w2, w3, w4, w5, w6, w7, w8, w9, w10, w11, w12};
        
        //Convert the array to list and assign it to 'staff'
        staff = new LinkedList<Person>(Arrays.asList(per));
       
        //Assign workers to managers
        m1.addWorker(w1);
        m2.addWorker(w2);
        m3.addWorker(w3);
        m1.addWorker(w4);
        m1.addWorker(w5);
        m2.addWorker(w6);
        m3.addWorker(w7);
        m1.addWorker(w8);
        m2.addWorker(w9);
        m3.addWorker(w10);
        m1.addWorker(w11);
        m2.addWorker(w12);
        
        //Print state of staff
        printState();
        
        
        //Create 3 new workers
        Worker w13 = new Worker("wkr13");
        Worker w14 = new Worker("wkr14");
        Worker w15 = new Worker("wkr15");
        
        //Add workers to staff list     
        staff.add(w13);
        staff.add(w14);
        staff.add(w15);
        
        //Assign workers to manager
        m1.addWorker(w13);
        m2.addWorker(w14);
        m3.addWorker(w15);
        
        //Print state of staff
        printState();
        
        //Remove first 2 workers from the list
        w1.getManager().removeWorker(w1);
        staff.remove(w1);
        w2.getManager().removeWorker(w2);
        staff.remove(w2);
       
        //Print state of staff
        printState();
        
        //Create new manager
        Manager m4 = new Manager("mgr4");
        
        //Add manager to the list in the 4th position
        staff.add(3, m4);
        
        //Add worker to manager
        w3.moveToTeamOf(m4);
       
        //Print state of staff
        printState();     
    }
    
    
    /* Printing states of staff members in the organisation */
    public static void printState() {
        
        for(Person p: staff) {
            if(p instanceof Manager) {
                p = (Manager)p;
                System.out.println(p.toString());
            }
            else if(p instanceof Worker) {
                p = (Worker)p;
                System.out.println(p.toString());
            }
        }
    }

}
