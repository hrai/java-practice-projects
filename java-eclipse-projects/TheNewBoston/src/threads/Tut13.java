package threads;

import java.util.concurrent.*;
import java.util.*;

public class Tut13 { 
    
    public static void main(String[] args) throws InterruptedException {
        
        ExecutorService executor = Executors.newCachedThreadPool();
        
        Future<Integer> future = executor.submit(new Callable<Integer>() {     //Callable replaces the Runnable interface      
            public Integer call() { //call() method has to be overridden
                
                Random rand = new Random();
                int duration = rand.nextInt(4000);
                
                if(duration > 2000) {
                        throw new RuntimeException("The duration is too long");
                    }
                    
                System.out.println("threads starting.... ");
                
                //sleep() simulates some work done by the program
                try {
                    Thread.sleep(duration); //thread sleeps for random time
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }
                
                System.out.println("threads stopped.");
                
                return duration;
            }
        });
        
        executor.shutdown();    //shuts down the executor manager
        
        executor.awaitTermination(1, TimeUnit.DAYS);    //waits for the manager to terminate all the threads
        
        //Future class throws 2 exceptions namely InterruptedException & ExecutionException
        try {
            System.out.println(future.get());
        }
        catch(InterruptedException ex) {
            ex.printStackTrace();
        }
        catch(ExecutionException ex) {
            RuntimeException e = (RuntimeException)ex.getCause();
            System.out.println(e.getMessage());
            /*
             * can also have the following code
             * catch(ExecutionException ex){
             *      System.out.println(ex.getMessage());
             * }
             */
        }
}
    
    
}
