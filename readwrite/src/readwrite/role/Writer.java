package readwrite.role;

import readwrite.ui.myframe;

public class Writer {
	
	private final Buffer bf = new Buffer();
	
	public void write() {
		System.out.println("正在写文件...");
		myframe.addWorkingProducer();
		bf.put(new Content());
		System.out.println("写完毕，目前容器内数量："+bf.size());
		DataModel.add();
		myframe.minusWorkingProducer();
	}
	
}
