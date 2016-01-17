package task2;

import java.util.*;

public class TestPersonnel {
    
    /* Create list for storing the staff of the organisation */
    public static LinkedList<Person> staff = new LinkedList<Person>();
    
    public static void main(String[] args) {
                
        /* Create managers */
        Manager m1 = new Manager("mgr1");
        Manager m2 = new Manager("mgr2");
        Manager m3 = new Manager("mgr3");
        
        /* Create workers */
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
        
        /* Print state of staff */
        printState();
        
        /* Assign workers to managers */
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
        
        /* Create 3 new workers */
        Worker w13 = new Worker("wkr13");
        Worker w14 = new Worker("wkr14");
        Worker w15 = new Worker("wkr15");
        
        /* Add workers to staff list */        
        staff.add(w13);
        staff.add(w14);
        staff.add(w15);
        
        /* Assign workers to manager */
        m1.addWorker(w13);
        m2.addWorker(w14);
        m3.addWorker(w15);
        
        /* Print state of staff */
        printState();
        
        
        
        /*
         * •	Create a single list for the people in the organisation, which is a list containing Person references for managers and workers.
•	Provide code to create some managers (3 will do) and some workers (12 will do) and add them to the list. Assign the workers in turn to the different managers.
•	Display the state of all the people in the organisation.
•	Add 3 new workers to the organisation, assigning them in turn to the different managers.
•	Display the state of all the people in the organisation.
•	Remove from the organisation the first 2 workers in the list of people.
•	Display the state of all the people in the organisation.
•	Add a new manager to the organisation, reassigning the first worker in the list of people to this new manager.
•	Display the state of all the people in the organisation.

         */
        
        
        //System.out.println(m1.getWorkersNames());
        
        
        
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
