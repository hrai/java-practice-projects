package threads;

import java.util.*;

public class Tut8 {
    
    public static void main(String[] args) {
        
        final Runner8 run = new Runner8();
        
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    run.producer();
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    run.consumer();
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }
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
    }
}

class Runner8 {
    
    public void producer() throws InterruptedException {
        
        synchronized(this) {
            System.out.println("Producer method is started.");
            System.out.println("The method is waiting.....");
            
            wait();
            
            System.out.println("The producer method is resumed.");
            
        }
    }
    
    public void consumer() throws InterruptedException {
        
        synchronized(this) {
            Thread.sleep(1000); //sleep the thread for a second
            
            System.out.println("Consumer method is started.");
            System.out.println("Waiting for 'ENTER' key.");
            
            new Scanner(System.in).nextLine();//read 'ENTER' key
            System.out.println("The producer method will be resumed now.");
            
            /* notify the producer() method but it doesn't relinquish the lock; 
             * lock is relinquished when the synchronized() method terminates 
             * so better not have any codes after notify()
             */
            notify();
            
        }
    }
    
}
