package threads;

import java.util.*;

public class Tut9 {
    
    public static void main(String[] args) {
        
        final Runner9 run = new Runner9();
        
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try { 
                    run.adder();
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    run.remover();
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

class Runner9 {
    
    LinkedList<Integer> list = new LinkedList<Integer>();
    private final int LIMIT = 10;
    Object lock = new Object();
    
    public void adder() throws InterruptedException{
        int value = 0;
        
        while(true) {   //infinite loop
            
            synchronized(lock){
                
                while(list.size() == LIMIT) {  //wait if the list is full
                    lock.wait();    
                }
                
                list.add(value++);  // add the number to list and then increase its value
                lock.notify();  //notify the lock in remover method
            }
        }
    }
    
    public void remover() throws InterruptedException {
        
        while(true) {   //infinite loop
            
            Thread.sleep(1000); //sleep for a second before removing integer
            
            synchronized(lock) {
                while(list.size() == 0) {
                    lock.wait();
                }
                
                System.out.print("The size of the list is " + list.size());     //calculate size before removing otherwise the size will be '9'
                
                int removed = list.removeFirst(); //remove the first item from the list
                                
                System.out.println(" The removed integer is " + removed);
                
                lock.notify();  //notify the lock in adder() method
            }
        }
    }
}
