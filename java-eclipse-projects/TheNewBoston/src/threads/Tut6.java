package threads;

import java.util.concurrent.*;

public class Tut6 {
    
    public static void main(String[] args) {
        
        CountDownLatch latch = new CountDownLatch(3);
        
        ExecutorService exe = Executors.newFixedThreadPool(3);
        
        for(int i=0; i<3; i++){
            exe.submit(new Runner6(latch));
        }
        
        try {
            latch.await();
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
        
        //shutdown the threadpool manager
        exe.shutdown();
                
        System.out.println("Completed.");
        
        
    }
}

class Runner6 implements Runnable {
    
    CountDownLatch latch;
    
    public Runner6(CountDownLatch latch) {
        this.latch = latch;
    }
    
    public void run() {
        System.out.println("threads started.");
        
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
        
        latch.countDown();
    }
}
