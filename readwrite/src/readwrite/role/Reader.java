package readwrite.role;

import javax.swing.JOptionPane;

import readwrite.ui.myframe;

public class Reader {
	
	private final MyFile bf = new MyFile();
	
	private int id;
	
	public Reader (int id) {
		this.id = id;
	}
	
	public void read() {
		System.out.println("正在尝试读文件...");
		boolean flag = false;
		myframe.addWorkingReader();
		try {
			flag = bf.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		myframe.minusWorkingReader();
		if (!flag) {
			JOptionPane.showMessageDialog(null, "消费者"+id+"读文件失败，文件为空！","提示", JOptionPane.INFORMATION_MESSAGE);
			System.out.println("读文件失败");
		} else {
			JOptionPane.showMessageDialog(null, "消费者"+id+"读文件成功","提示", JOptionPane.INFORMATION_MESSAGE);
			System.out.println("读文件成功");
		}
		
	}

}
