package readwrite.ui;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import readwrite.role.Reader;
import readwrite.role.DataModel;
import readwrite.role.Writer;

@SuppressWarnings("serial")
public class myframe extends JFrame{
	
	private ArrayList<Writer> writers = new ArrayList<>();
	
	private ArrayList<Reader> readers = new ArrayList<>();
	
	private Random random = new Random();
	
	private static final String WORKING_WRITER = "正在排队的写者数量：";
	
	private static final String WORKING_READER = "正在工作的读者数量：";
	
	private static final String TITLE = "读者写者程序";
	
	private static final JLabel jLabel_writer = new JLabel(WORKING_WRITER);
	
	private static final JLabel jLabel_reader = new JLabel(WORKING_READER);
	
	private static final AtomicInteger count_writer = new AtomicInteger(0); 
	
	private static final AtomicInteger count_reader = new AtomicInteger(0); 
	
	
	private void initRole(int wriNum, int reaNum) {
		for (int i = 0 ; i < wriNum ; i++) {
			writers.add(new Writer(i));
		}
		for (int i = 0 ; i < reaNum ; i++) {
			readers.add(new Reader(i));
		}
	}
	
	private void initWindow() {
		setTitle(TITLE);
		setSize(500, 500);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width/2;
		int screenHeight = screenSize.height/2;
		int height = this.getHeight();
		int width = this.getWidth();
		setLocation(screenWidth-width/2, screenHeight-height/2);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		initAttachment();
		
		setVisible(true);
	}
	
	private void initAttachment() {
		JButton writer = new JButton("写文件");
		writer.addActionListener((e)->{
			int randomInt = random.nextInt(10);
			new Thread(){
				@Override
				public void run() {
					writers.get(randomInt).write();
				}
			}.start();
		});
		JButton reader = new JButton("读文件");
		reader.addActionListener((e)->{
			int randomInt = random.nextInt(10);
			new Thread(){
				@Override
				public void run() {
					readers.get(randomInt).read();
				}
			}.start();
		});
		JTable table = new JTable(DataModel.model);
		writer.setBounds(10, 230, 70, 40);
		reader.setBounds(405, 230, 70, 40);
		table.setBounds(90, 200, 300, 100);
		jLabel_writer.setBounds(10, 300, 200, 100);
		jLabel_reader.setBounds(310, 300, 200, 100);
		add(writer);
		add(reader);
		add(table);
		add(jLabel_writer);
		add(jLabel_reader);
	}
	
	public myframe(int wriNum, int reaNum) {
		initRole(wriNum, reaNum);
		initWindow();
	}
	
	public static void addWorkingWriter() {
		jLabel_writer.setText(WORKING_WRITER + count_writer.incrementAndGet());
		
	}
	
	public static void minusWorkingWriter() {
		
		jLabel_writer.setText(WORKING_WRITER + count_writer.decrementAndGet());
		
	}
	
	public static void addWorkingReader() {
		
		jLabel_reader.setText(WORKING_READER + count_reader.incrementAndGet());
		
	}
	
	public static void minusWorkingReader() {
		
		jLabel_reader.setText(WORKING_READER + count_reader.decrementAndGet());
		
	}
	
	
}
