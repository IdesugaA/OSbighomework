package readwrite.role;

import readwrite.ui.myframe;

public class Reader {
	
	private final Buffer bf = new Buffer();
	
	public void read() {
		System.out.println("正在尝试读文件...");
		myframe.addWorkingReader();
		try {
			bf.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		myframe.minusWorkingReader();
		System.out.println("读文件成功");
	}

}
