package queues;

public class Appointment<T> {

	private final T toBeSeen;
	
	public Appointment(T incoming) {
		this.toBeSeen = incoming;
	}
	
	public T getPatient() {
		return toBeSeen;
	}
}
