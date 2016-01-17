package Help;

//Worker is subclass of Person
public class Worker extends Person
{
    private static int autoId = 100;
    private Manager teamLeader;
    
    public Worker(String name)
    {
        super(name);
        teamLeader = null;
    }
    
    protected int autoId() {
        if (autoId >= 100 && autoId <= 999)
            return autoId++;
        else
            return -1;
    }
    
//return teamleader of Manager   
 public Manager getTeamLeader() {
        return teamLeader;
    }

// adding teamleader to Manager
    public void setTeamLeader(Manager teamLeader) {
        this.teamLeader = teamLeader;
        teamLeader.addWorker(this);
    }
    
// return the value of teamleader
public boolean movetoTeamOf(Manager manager) {
        if (manager == null || manager == teamLeader)
            return false;
        teamLeader.removeWorker(this);
        manager.addWorker(this);
        teamLeader = manager;
        return true;
    }

//Showing the manager of the worker
    public void display() {
        System.out.println("\n-------- WORKER ------------");
        System.out.println("Worker " + name + " has " + teamLeader.getName() + " as his manager.");
    }
    
//return worker and id to string type  
  public String toString() {
        return "Worker" +
                "\n\tName: " + name +
                "\n\tId: " + id;
    }
}
