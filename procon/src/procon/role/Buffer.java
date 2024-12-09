package procon.role;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Buffer {
	
	public static final BlockingQueue<Product> ctner = new ArrayBlockingQueue<>(10);
	
	public void put(Product product) {
		try {
			Thread.sleep(2000);
			ctner.put(product);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void take() {
		try {
			Thread.sleep(2000);
			ctner.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int size() {
		return ctner.size();
	}

}
