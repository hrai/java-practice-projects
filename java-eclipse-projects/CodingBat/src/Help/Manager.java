package Help;

import java.util.LinkedList;

//Manager is subclass of Person
public class Manager extends Person
{
    private static int autoId = 1;
    private LinkedList<Worker> team = new LinkedList<Worker>();
    
    public Manager(String name)
    {
        super(name); //
    }
    
    protected int autoId() {
        if (autoId >= 1 && autoId <= 99)
            return autoId++;
        else
            return -1;
    }
    
    public LinkedList<Worker> getTeam() {
        return team;
    }
    
    public void setTeam(LinkedList<Worker> team) {
        this.team = team;
    }
    
    public void addWorker(Worker worker) {
        team.add(worker);
    }
    
    public void removeWorker(Worker worker) {
    	
    }
    
    public void switchTeams(Manager manager) {
    	
    }
    
    public void display() {}
}