
package threads;

import java.util.*;

class Runner2 extends Thread {
    
    //volatile modifier means the variable can't be cast
    private volatile boolean running = true;
    
    public void run() {
    
        while(running) {
            System.out.println("Running");
            
            try {
                Thread.sleep(50);
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void shutdown() {
        running = false;
    }
}
    
public class Tut2 {
    
    public static void main(String[] args) {
        Runner2 t1 = new Runner2();
        t1.start();
        
        new Scanner(System.in).nextLine();
        
        t1.shutdown();
        
    }
}
