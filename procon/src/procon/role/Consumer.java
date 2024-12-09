package procon.role;

import procon.ui.myframe;

public class Consumer {
	
	private final Buffer bf = new Buffer();
	
	public void consume() {
		System.out.println("正在消费...");
		myframe.addWorkingConsumer();
		bf.take();
		System.out.println("消费完毕，目前容器内数量："+bf.size());
		DataModel.removeLast();
		myframe.minusWorkingConsumer();
	}

}
