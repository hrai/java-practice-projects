package lists;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;


public class MicroBlogTimeline {

	private final CopyOnWriteArrayList<Update> updates;
	private final ReentrantLock lock;
	private final String name;
	private Iterator<Update> it; 
	
	public MicroBlogTimeline(String name, CopyOnWriteArrayList<Update> updates,
			ReentrantLock lock) {
		this.name = name;
		this.updates = updates;
		this.lock = lock;
	}

	public void addUpdate(Update update_)
	{
		updates.add(update_);
	}
	
	public void prep() 
	{
		it = updates.iterator();
	}
	
	public void printTimeline() 
	{
		lock.lock();
		try {
			if(it != null)
			{
				System.out.println(name + ": ");
				while(it.hasNext())
				{
					Update update = it.next();
					System.out.println(update.toString() + ",");
				}
				System.out.println();
			}
		}
		finally {
			lock.unlock();
		}
	}
}
