package task2;

public class Worker extends Person{
    
    private Manager manager = new Manager(null);
    
    /* Construct a Worker object */
    public Worker(String wrkName) {
        
        name = wrkName;
        IDnum = wkrID();
    }
    
    /* Return a random integer value used as worker ID */
    public int wkrID() {        
        int result;
        
        //Assign random number to result between 100 to 999
        result = (int)(Math.random()*1000);
        
        return result;
    }
    
    /* Return the manager of this worker */
    public Manager getManager() {
        
        return manager;
    }
    
    /* Set the worker's manager */
    public void setManager(Manager manager) {
        
        this.manager = manager;
    }
    
    /* Move the worker's team */
    @SuppressWarnings("null")
	public void moveToTeamOf(Manager manager) {
        
        if(manager != null || !manager.equals(this.manager)) {
            
            //Remove worker from old team
            this.manager.removeWorker(this);

            //Change current manager of the worker 
            setManager(manager);

            //Move worker to new manager
            manager.addWorker(this);
        }
    }
    
    /* Return a string representation of object states */
    public String toString() {
        
        String result = "";
        String managerName = this.getManager().name;
        
        if(managerName == null) {   //if worker doesn't have a manager, return following string
            result = String.format("Worker \"%s\" is not assigned to any manager.", name);
        }        
        else {  //if worker has a manager, return following string
            result = String.format("Worker \"%s\" is assigned to \"%s\".", name, managerName);
        }
        
        return result;
    }
    
}
