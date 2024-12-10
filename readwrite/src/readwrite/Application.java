package readwrite;

import javax.swing.JOptionPane;

import readwrite.ui.myframe;

public class Application {
	
	public static void main(String[] args) {
		int wriNum = Integer.parseInt(JOptionPane.showInputDialog(null, "请输入写者数量", "输入", JOptionPane.QUESTION_MESSAGE));
		int reaNum = Integer.parseInt(JOptionPane.showInputDialog(null, "请输入读者数量", "输入", JOptionPane.QUESTION_MESSAGE));
		myframe mf = new myframe(wriNum, reaNum);
	}

}
