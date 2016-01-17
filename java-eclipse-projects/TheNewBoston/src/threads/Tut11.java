package threads;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

public class Tut11 {
    
    private static final Runner11 run = new Runner11();
    
    public static void main(String[] args) {
        
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    run.firstThread();
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    run.secondThread();
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
        
        //printing the resulting balances and total balance
        run.finished();
    }
    
}


class Runner11 {
    
    Account acc1 = new Account();
    Account acc2 = new Account();
    Random rand = new Random();
    
    //creating locks
    Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();
    
    private void acquireLock(Lock firstLock, Lock secondLock) throws InterruptedException {
        
        while(true) {
            //acquire lock
            
            boolean gotFirstLock = false;
            boolean gotSecondLock = false;
            
            try {
                gotFirstLock = firstLock.tryLock();
                gotSecondLock = secondLock.tryLock();
            }
            finally {
                
                if(gotFirstLock && gotSecondLock) {
                    return; //return helps to skip out of finally block
                }
                
                if(gotFirstLock) {
                    firstLock.unlock();
                }
                
                if(gotSecondLock) {
                    secondLock.unlock();
                }                
            }
            
            //locks not acquired
            Thread.sleep(1);
        }
        
    }
    
    public void firstThread() throws InterruptedException {
        
        for(int i=0; i<10000; i++) {
            
            acquireLock(lock1, lock2);
            
            try {
                Account.transfer(acc1, acc2, rand.nextInt(100));
            }
            finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
        
    }
    
    public void secondThread() throws InterruptedException {
        
        for(int i=0; i<10000; i++) {
            
            acquireLock(lock2, lock1);
            
            try {
                Account.transfer(acc2, acc1, rand.nextInt(100));
            }
            finally {
                lock2.unlock();
                lock1.unlock();
            }
        }
    }
    
    public void finished() {
        System.out.printf("Account 1 has a balance of %s \n", acc1.getBalance());
        System.out.printf("Account 2 has a balance of %s \n", acc2.getBalance());
        System.out.printf("Total balance is %d \n", (acc1.getBalance() + acc2.getBalance()));
    }
}

/* Account class for creating account objects */
class Account {
    
    private int balance = 10000;
    
    public void deposit(int amt) {
        balance+= amt;
    }
    
    public void withdraw(int amt) {
        balance-= amt;
    }
    
    public static void transfer(Account acc1, Account acc2, int amt) {
        acc1.withdraw(amt);
        acc2.deposit(amt);
    }
    
    public int getBalance() {
        return balance;
    }
    
}
