package procon.role;

import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.table.DefaultTableModel;

public class DataModel {
	
	private static final String INFO_STRING = "PRODUCT";
	
	private static String[] columns = {"product"};
	
	private static String[][] data = {};
	
	private static int count = 0;
	
	public static final DefaultTableModel model = new DefaultTableModel(data, columns);
	
	public synchronized static void add() {
		model.addRow(new String[] {INFO_STRING});
		count++;
		DataModel.class.notifyAll();
	}
	
	public synchronized static void removeLast() {
		if (count == 0) {
			try {
				DataModel.class.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		model.removeRow(count-1);
		count--;
	}

}
