package threads;

import java.util.concurrent.*;
import java.util.Random;

public class Tut7 {
    
    public static void main(String[] args) {
        
        final Runner7 run = new Runner7();
        
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                run.producer();
            }
        });
        
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                run.consumer();
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

class Runner7 {
    
    private BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
    
    public void producer() {
        Random rand = new Random();
        
        while(true) {
            try {
                queue.put(rand.nextInt(100));
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void consumer(){
        Random rand = new Random();
        
        while(true) {
            try {
                Thread.sleep(50);

                if(rand.nextInt(10)==0) {
                    int value = queue.take();
                    System.out.println("The removed number is: " + value + "; The queue size is: " + queue.size());
                }
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
            
        }
    }
}
