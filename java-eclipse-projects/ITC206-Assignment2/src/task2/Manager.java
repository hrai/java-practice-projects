package task2;

import java.util.*;

public class Manager extends Person{
    
    //Creating a list of workers who work under the manager
    LinkedList<Worker> workers = new LinkedList<Worker>();
    
    /* Constructor to construct an object of Manager class */
    public Manager(String mgrName) {
        
        name = mgrName;
        IDnum = mgrID();
    }
    
    /* Return a random integer value used as manager ID*/
    public int mgrID() {
        
        Random rand = new Random();
        int result = rand.nextInt(100);
        
        while(result==0) {  //loops until result's value is not '0'
            result = rand.nextInt(100);
        }
        
        return result;
    }
    
    /* Return a list of workers for the manager */
    public String getWorkersNames() {
        
        String wrkrs = "";
        
        for(Worker wrkr: workers) {
            wrkrs+= wrkr.name + " ";  //Adding worker's name to the string
        }
        
        return wrkrs;
        
    }
    
    /* Add worker to the manager's team */
    public void addWorker(Worker worker) {
        
        //Check if the worker already exists in the list
        if(workers.contains(worker)) {
            System.out.println("The worker already exists.");
        }
        else 
            worker.setManager(this);    //setting the current manager as the worker's manager
            workers.add(worker);    //add the worker to the list
    }
    
    /* Remove worker from the team */
    public void removeWorker(Worker worker) {
        
        //Check if the worker exists in the list
        if(!workers.contains(worker)) {
            System.out.println("The worker doesn't exist in this team.");
        }
        else 
            worker.setManager(null);    // setting the worker's manager to null
            workers.remove(worker);
    }
    
    /* Switch manager's team */
    public void switchTeams(Manager manager) {
        
        //Change reference of every worker in the team of 
        //old manager to new manager
        for(Worker worker: workers) {
            worker.moveToTeamOf(manager);
        }
    }
    
    /* Returns a string representing the object state */
    public String toString() {
        
        String result = String.format("The manager is \"%s\" & the workers are %s. \n", name, getWorkersNames());
        
        return result;
    }
    
}
