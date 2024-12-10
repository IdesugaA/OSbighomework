package procon.role;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

public class Buffer {
	
	private static ArrayList<Product> products = new ArrayList<>();
	
	private static Semaphore mutex = null;
	
	private static Semaphore empty = null;
	
	private static Semaphore full = null;
	
	public static void init(int amt) {
		mutex = new Semaphore(1);
		empty = new Semaphore(amt);
		full = new Semaphore(0);
	}
	
	public void put(Product product) {
		try {
			empty.acquire();
			mutex.acquire();
			// 生产
			sleep(800);
			products.add(product);
			mutex.release();
			full.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void take() {
		try {
			full.acquire();
			mutex.acquire();
			// 消费
			sleep(800);
			products.remove(products.size()-1);
			mutex.release();
			empty.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int size() {
		return products.size();
	}
	
	private void sleep(int time) {
		long start = System.currentTimeMillis();
		while(true) {
			long end = System.currentTimeMillis();
			if (end - start >= time) break;
		}
	}

}
