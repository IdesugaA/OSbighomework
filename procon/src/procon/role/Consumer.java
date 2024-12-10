package procon.role;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import procon.ui.myframe;

public class Consumer {
	
	private int id;
	
	private final Buffer bf = new Buffer();
	
	private static Set<Integer> set = Collections.synchronizedSet(new HashSet<>());
	
	public Consumer(int id) {
		this.id = id;
		if (set == null) {
			synchronized (Consumer.class) {
				if (set == null) {
					set = Collections.synchronizedSet(new HashSet<>());
				}
			}
		}
	}
	
	public void consume() {
		System.out.println("正在消费...");
		set.add(id);
		myframe.addWorkingConsumer();
		bf.take();
		System.out.println("消费完毕，目前容器内数量："+bf.size());
		DataModel.removeLast();
		set.remove(id);
		myframe.minusWorkingConsumer();
		myframe.addWaitingConsumer(set.toString());
	}

}
