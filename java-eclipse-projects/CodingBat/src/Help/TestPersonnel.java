package Help;

import java.util.LinkedList;

public class TestPersonnel
{
    LinkedList<Person> personel = new LinkedList<Person>();
    
    public TestPersonnel()
    {
        //Create managers
        Manager m1 = new Manager("Manager A");
        Manager m2 = new Manager("Manager B");
        Manager m3 = new Manager("Manager C");
        
        //Create workers
        Worker w1 = new Worker("Worker A");
        Worker w2 = new Worker("Worker B");
        Worker w3 = new Worker("Worker C");
        Worker w4 = new Worker("Worker D");
        Worker w5 = new Worker("Worker E");
        
        //Add managers to a list
        personel.add(m1);
        personel.add(m2);
        personel.add(m3);
        
        //Add workers to a list
        personel.add(w1);
        personel.add(w2);
        personel.add(w3);
        personel.add(w4);
        personel.add(w5);
        
        //Set team leader for workers
        w1.setTeamLeader(m1);
        w2.setTeamLeader(m1);
        w3.setTeamLeader(m2);
        w4.setTeamLeader(m2);
        w5.setTeamLeader(m3);
        
        //Test
        display("Testcase 1: The whole company");
        
        //Remove worker w1
        m1.removeWorker(w1);
        personel.remove(w1);
        
        //Test again
        display("Testcase 2: After removing a worker");
        
        //Create another manager m4 & add to a list
        Manager m4 = new Manager("Manager D");
        personel.add(m4);
        
        //Manager m4 switchs team with manager m1
        m4.switchTeams(m1);
        
        //Test again
        display("Testcase 3: Switching mamangers");
    }
    
    private void display(String label) {
        System.out.println("\n--- Start " + label + " ---\n");
        for (Person person : personel) {
            System.out.println(person.toString());
            if (person instanceof Manager) {
                Manager manager = (Manager)person;
                manager.display();
            }
            else if (person instanceof Worker) {
                Worker worker = (Worker)person;
                worker.display();
            }
        }
        System.out.println("\n--- End " + label + " ---\n");
    }
}
