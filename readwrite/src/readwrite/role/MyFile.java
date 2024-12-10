package readwrite.role;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class MyFile {
	
	
	private static ArrayList<Content> file = new ArrayList<>();
	
	private static final Semaphore cnt_mutex = new Semaphore(1);
	
	private static final Semaphore mutex = new Semaphore(1);
	
	private static int count = 0;
	
	
	public void put(Content content) throws InterruptedException{
		mutex.acquire();
		// 写文件
		Thread.sleep(2000);
		file.add(content);
		mutex.release();
	}
	
	public boolean take() throws InterruptedException{
		cnt_mutex.acquire();
		if (count == 0) {
			mutex.acquire();
		}
		count++;
		cnt_mutex.release();
		sleep(800);
		if (file.isEmpty()) {
			return false;
		}
		cnt_mutex.acquire();
		count--;
		if (count == 0) mutex.release();
		cnt_mutex.release();
		return true;
	}
	
	private void sleep(int time) {
		long start = System.currentTimeMillis();
		while(true) {
			long end = System.currentTimeMillis();
			if (end - start >= time) break;
		}
	}


}
