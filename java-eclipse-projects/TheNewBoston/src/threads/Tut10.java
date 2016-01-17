package threads;

import java.util.concurrent.locks.*;
import java.util.*;

public class Tut10 {

    static final Runner processor = new Runner();
    
    public static void main(String[] args) throws InterruptedException{
        
        //creating thread
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    processor.firstThread();
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        //creating thread
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    processor.secondThread();
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        //starting threads
        t1.start();
        t2.start();
        
        try{
            //terminating threads
            t1.join();
            t2.join();
            processor.finished();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    
    
}

class Runner {
    
    private int count = 0;
    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();
    
    private void increment() {
        for(int i=0; i<10000; i++){
            count++;
        }
    }
    
    public void firstThread() throws InterruptedException {        
        lock.lock();        
        
        System.out.println("Waiting.....");
        cond.await();
        
        System.out.println("Woken up!");
        try{
            increment();
        }
        finally{
            lock.unlock();
        }
    }
    
    public void secondThread() throws InterruptedException {        
        Thread.sleep(1000);
        lock.lock();
        
        System.out.println("Press the return key");
        
        new Scanner(System.in).nextLine(); //asks for input
        System.out.println("Got return key");
        
        cond.signal();
        try{
            increment();
        }
        finally{
            lock.unlock();
        }
    }
    
    public void finished() {
        
        System.out.println("Count is: " + count);
    }
}
