
public class Threads {
	static int count = 0;
	
	public static void main(String[] args) {
		Thread t1, t2;
		
		try {

			t1 = new Thread(new Runnable() {
				public void run() {
					for(int i=0; i<100; i++)
					{
						System.out.println(i);
						count++;
					}
				}
			});
			
			t2 = new Thread(new Runnable() {
				public void run() {
					for(int i=100; i>=0; i--)
					{
						System.out.println(i);
						count++;
					}
				}
			});
			
			
			//If a join method is called upon a thread, the 
			//method tells currently executing thread to wait 
			//until the execution terminates
			t1.join();
			t2.join();
			
			//Starting threads
			t1.start();
			t2.start();
			
			//System.out.println("This is a test " + count);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
