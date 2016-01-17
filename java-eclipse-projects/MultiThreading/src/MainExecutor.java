
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

import lists.Author;
import lists.MicroBlogTimeline;
import lists.Update;


public class MainExecutor {


	public static void main(String[] args) 
	{
		final CountDownLatch firstLatch = new CountDownLatch(1);
		final CountDownLatch secondLatch = new CountDownLatch(1);

		final Update.Builder ub = new Update.Builder();

		final CopyOnWriteArrayList<Update> list = new CopyOnWriteArrayList<>();
		list.add(ub.author(new Author("Ben")).updateText("I like egg.").build());
		list.add(ub.author(new Author("Arthur")).updateText("I like milk and bread.").build());

		ReentrantLock lock = new ReentrantLock();
		final MicroBlogTimeline tl1 = new MicroBlogTimeline("TL1", list, lock); 
		final MicroBlogTimeline tl2 = new MicroBlogTimeline("TL2", list, lock);

		Thread firstThread = new Thread(new Runnable() {

			@Override
			public void run() {
				list.add(ub.author(new Author("Jeffery")).updateText("I like to play games.").build());

				tl1.prep();
				firstLatch.countDown();
				//System.out.println("test");
				
				try {
					secondLatch.await();
				}
				catch(InterruptedException ex) {}
				
				tl1.printTimeline();
			}
		});

		Thread secondThread = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					firstLatch.await();
					list.add(ub.author(new Author("Gavin")).updateText("I like watching TV").build());

					tl2.prep();
					secondLatch.countDown();
				}
				catch(InterruptedException ex) { }
				
				tl2.printTimeline();
			}
		});

		firstThread.start();
		secondThread.start();

		//Update update = ub.author(new Author("James Bond")).updateText("This is a new builder.").build();

	}

}
