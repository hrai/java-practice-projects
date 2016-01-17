package queues;

import java.util.concurrent.BlockingQueue;

public class Veterinarian extends Thread {

	protected final BlockingQueue<Appointment<Pet>> appts;
	protected String text = "";
	protected final int restTime;
	private boolean shutDown;
	
	public Veterinarian(BlockingQueue<Appointment<Pet>> appointments, int pause) {
		this.appts = appointments;
		this.restTime = pause;
	}
	
	public synchronized void shutdown() {
		shutDown = true;
	}
	
	@Override
	public void run() {
		while(!shutDown) {
			seePatient();
			
			try {
				Thread.sleep(restTime);
			}
			catch(InterruptedException e) {
				shutDown = true;
			}
		}
	}
	
	public void seePatient() {
		try {
			Appointment<Pet> appointment = appts.take();
			Pet patient = appointment.getPatient();
			patient.examine();
		}
		catch(InterruptedException ex) {
			shutDown = true;
		}
	}
}
