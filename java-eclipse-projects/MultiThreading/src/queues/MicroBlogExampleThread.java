package queues;

import java.util.concurrent.TransferQueue;

import lists.Update;

public abstract class MicroBlogExampleThread extends Thread {

	protected final TransferQueue<Update> updates;
	protected String text = "";
	protected final int pauseTime;
	private boolean shutdown;
	
	public MicroBlogExampleThread(TransferQueue<Update> updates, int pauseTime) {
		this.updates = updates;
		this.pauseTime = pauseTime;
	}
	
	public synchronized void shutdown() {
		shutdown = true;
	}
	
	@Override
	public void run() {
		while(!shutdown) {
			doAction();
			try {
				Thread.sleep(pauseTime);
			}
			catch(InterruptedException ex)
			{
				shutdown = true;
			}
		}
	}
	
	public abstract void doAction();
	
}
