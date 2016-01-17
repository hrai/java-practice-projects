package Help;

public abstract class Person
{
    protected String name;
    protected int id; 
    
//construct a person with a specified name ans id
    public Person(String name) {
        this.name = name;
        id = autoId();
    }
    
// return the name of the person; access method
    public String getName() {
        return name;
    }

// return the id of the person; access method    
    public int getId() {
        return id;
    }
    
    abstract protected int autoId(); // autoID() is a subclass of this class
}
