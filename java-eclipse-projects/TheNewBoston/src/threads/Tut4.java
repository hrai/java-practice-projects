package threads;

public class Tut4 {
    
    
    public static void main(String[] args) {
        
        final Runner4 processing = new Runner4();
        long startTime = System.currentTimeMillis();
    
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                processing.process();
            }
        });
        
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                processing.process();
            }
        });
        
        t1.start();
        t2.start();
        
        try {
            t1.join();
            t2.join();
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
        
        
        System.out.println("Time taken to complete the threads is: " + (System.currentTimeMillis()-startTime));
   
    }
    
        
}

/* Runnable interface is implemented */
class Runner4{
    
    
    //creating locks
    Object lock1 = new Object();
    Object lock2 = new Object();
    
    public void sleep() {
        try{
            Thread.sleep(5);
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
        
    public void firstWorker() {
        synchronized(lock1) {
            sleep();
        }
    }
    
    public void secondWorker() {
        synchronized(lock2) {
            sleep();
        }
    }
    
    public void process() {
        for(int i=0; i<100; i++) {
            firstWorker();
            secondWorker();
        }
     }
    
}
