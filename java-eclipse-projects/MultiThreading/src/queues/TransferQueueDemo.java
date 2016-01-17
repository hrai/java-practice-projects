package queues;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

import lists.Author;
import lists.Update;

public class TransferQueueDemo {

	public static void main(String[] args) {

		final Update.Builder ub = new Update.Builder();
		final TransferQueue<Update> updates = new LinkedTransferQueue<>();
		
		MicroBlogExampleThread t1 = new MicroBlogExampleThread(updates, 10) {
			
			@Override
			public void doAction() {
				text = text + "X";

				Update update = ub.author(new Author("Greg")).updateText(text).build();
				boolean handed = false;
				
				try {
					handed = updates.tryTransfer(update, 100, TimeUnit.MILLISECONDS);
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
				
				if(!handed) {
					System.out.println("Unable to handoff Update to Queue due to timeout.");
				}
			}
		};
		
		MicroBlogExampleThread t2 = new MicroBlogExampleThread(updates, 1000) {
			
			@Override
			public void doAction() {
				Update u = null;
				
				try {
					u = updates.take();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		t1.start();
		t2.start();
	}
	
}
