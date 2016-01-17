package threads;

/* Implement Runnable interface */
class Runner1 implements Runnable {
    
    public void run() {
        for(int i=0; i<5; i++){
            System.out.println("Hello: " + i);
            
            try {
                Thread.sleep(100);
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/* Implement threads class */
class Runner1_1 extends Thread {
    
    //overriding run() method
    public void run() {
        for(int i=0; i<5; i++) {
            System.out.println("Hello: " + i);
        
        try {
            Thread.sleep(100);
        }
        catch(InterruptedException e) { 
            e.printStackTrace();
        }
    }
        
}
    
}

/* Main class with main thread */
public class Tut1 {
    
    public static void main(String[] args) {
        
        //running thread class
        Runner1_1 run1 = new Runner1_1();        
        run1.start();
        
        Runner1_1 run2 = new Runner1_1();
        run2.start();
        
        //running class which implements Runnable interface
        Thread t1 = new Thread(new Runner2());
        t1.start();
        
        
    }
}
