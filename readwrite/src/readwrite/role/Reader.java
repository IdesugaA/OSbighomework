package readwrite.role;

import readwrite.ui.myframe;

public class Reader {
	
	private final Buffer bf = new Buffer();
	
	public void read() {
		System.out.println("正在读...");
		myframe.addWorkingConsumer();
		bf.take();
		System.out.println("读完毕，目前容器内数量："+bf.size());
		myframe.minusWorkingConsumer();
	}

}
