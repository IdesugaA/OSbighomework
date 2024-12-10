package procon.role;

import procon.ui.myframe;

public class Producer {
	
	private int id;
	
	private final Buffer bf = new Buffer();
	
	public Producer(int id) {
		this.id = id;
	}
	
	public void pruduce() {
		System.out.println("正在生产...");
		myframe.addWorkingProducer();
		bf.put(new Product());
		System.out.println("生产完毕，目前容器内数量："+bf.size());
		DataModel.add();
		myframe.minusWorkingProducer();
	}
	
}
