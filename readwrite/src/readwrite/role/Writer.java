package readwrite.role;

import readwrite.ui.myframe;

public class Writer {
	
	private final Buffer bf = new Buffer();
	
	public void write() {
		System.out.println("正在尝试写文件...");
		myframe.addWorkingWriter();
		try {
			bf.put(new Content());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		DataModel.add();
		myframe.minusWorkingWriter();
		System.out.println("写文件成功");
	}
	
}
