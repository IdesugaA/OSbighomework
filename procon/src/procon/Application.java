package procon;

import javax.swing.JOptionPane;

import procon.ui.myframe;

public class Application {
	
	public static void main(String[] args) {
		int bufferSize = Integer.parseInt(JOptionPane.showInputDialog(null, "请输入缓冲区大小", "输入", JOptionPane.QUESTION_MESSAGE));
		int proNum = Integer.parseInt(JOptionPane.showInputDialog(null, "请输入生产者数量", "输入", JOptionPane.QUESTION_MESSAGE));
		int conNum = Integer.parseInt(JOptionPane.showInputDialog(null, "请输入消费者数量", "输入", JOptionPane.QUESTION_MESSAGE));
		myframe mf = new myframe(bufferSize, proNum, conNum);
	}

}
