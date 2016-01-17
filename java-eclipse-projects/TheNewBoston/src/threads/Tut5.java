package threads;

import java.util.concurrent.*;


public class Tut5 {
    
    public static void main(String[] args) {
        
        ExecutorService exe = Executors.newFixedThreadPool(2);
        
        for(int i=0; i<5; i++) {
            exe.submit(new Runner5(i));
        }
        
        exe.shutdown();
        
        System.out.println("All tasks submitted.");
        
        try {
            exe.awaitTermination(1, TimeUnit.DAYS);
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("All tasks completed.");
    }

}

class Runner5 implements Runnable {
    
    private int id;
    
    public Runner5(int id) {
        this.id = id;
    }
    
    public void run() {
        
        System.out.println("Starting thread: " + id);
            
        try{
            Thread.sleep(3000);
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Ending thread: " + id);
    }
    
}
