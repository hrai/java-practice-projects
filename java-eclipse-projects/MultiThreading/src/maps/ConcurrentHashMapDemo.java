package maps;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import lists.Update;

public class ConcurrentHashMapDemo {
	
	private final ConcurrentMap<Update, Long> arrivalTime = new ConcurrentHashMap<>();
	
	private void propagateUpdate(Update upd_)
	{
		arrivalTime.putIfAbsent(upd_, System.currentTimeMillis());
	}
	
	public boolean confirmUpdateReceived(Update upd_)
	{
		return arrivalTime.get(upd_) != null;
	}

}
