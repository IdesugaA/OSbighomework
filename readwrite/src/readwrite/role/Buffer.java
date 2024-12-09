package readwrite.role;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Buffer {
	
	
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
	
	public void take() throws InterruptedException{
		cnt_mutex.acquire();
		if (count == 0) {
			mutex.acquire();
		}
		cnt_mutex.release();
		System.out.println("开始读+1");
		// 读文件
		Thread.sleep(2000);
		cnt_mutex.acquire();
		count--;
		if (count == 0) mutex.release();
		cnt_mutex.release();
		
	}
	


}
