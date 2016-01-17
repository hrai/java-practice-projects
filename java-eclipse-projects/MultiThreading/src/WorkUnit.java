

public class WorkUnit<T> {
	private final T workingClass;
	
	public T getWork() {
		return workingClass;
	}
	
	public WorkUnit(T workUnit_) {
		this.workingClass = workUnit_;
	}
	
}
