package threads;

public class Tut3 {
    
    private static int count = 0;
    
    //synchronized keyword helps to lock the method 
    //until the thread manipulating it, is done with it
    public static synchronized void increment() {
        count++;
    }
    
    public static void main(String[] args) {
        
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for(int i=0; i<10000; i++) {
                    increment();
                }
            }
        });
        
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for(int i=0; i<10000; i++) {
                    increment();
                }
            }
        });
        
    
        //starting threads
        t1.start();
        t2.start();
        
        //waiting until the threads terminate
        try {
            t1.join();
            t2.join();                    
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("The count is: " + count);
            
}
    
}