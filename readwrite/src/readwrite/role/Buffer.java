package readwrite.role;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Buffer {
	
	
	private static ArrayList<Content> file = new ArrayList<>();
	
	private static final AtomicInteger reader_amnt = new AtomicInteger(0);
	
	private 
	
	
	public void put(Content content) {
		file.add(content);
	}
	
	public void take() {

	}
	


}
