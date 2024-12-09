package procon.ui;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import procon.role.Consumer;
import procon.role.DataModel;
import procon.role.Producer;

@SuppressWarnings("serial")
public class myframe extends JFrame{
	
	private ArrayList<Producer> producers = new ArrayList<>();
	
	private ArrayList<Consumer> consumers = new ArrayList<>();
	
	private Random random = new Random();
	
	private static final String WORKING_PRODUCER = "正在工作的生产者数量：";
	
	private static final String WORKING_CONSUMER = "正在工作的消费者数量：";
	
	private static final String TITLE = "生产者消费者程序";
	
	private static final JLabel jLabel_producer = new JLabel(WORKING_PRODUCER);
	
	private static final JLabel jLabel_consumer = new JLabel(WORKING_CONSUMER);
	
	private static final AtomicInteger count_producer = new AtomicInteger(0); 
	
	private static final AtomicInteger count_consumer = new AtomicInteger(0); 
	
	
	private void initRole() {
		for (int i = 0 ; i < 10 ; i++) {
			producers.add(new Producer());
		}
		for (int i = 0 ; i < 10 ; i++) {
			consumers.add(new Consumer());
		}
	}
	
	private void initWindow() {
		setTitle(TITLE);
		setSize(500, 500);
		Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
		Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
		int screenWidth = screenSize.width/2; // 获取屏幕的宽
		int screenHeight = screenSize.height/2; // 获取屏幕的高
		int height = this.getHeight();
		int width = this.getWidth();
		setLocation(screenWidth-width/2, screenHeight-height/2);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		initAttachment();
		
		setVisible(true);
	}
	
	private void initAttachment() {
		JButton produce = new JButton("生产");
		produce.addActionListener((e)->{
			int randomInt = random.nextInt(10);
			new Thread(){
				@Override
				public void run() {
					producers.get(randomInt).pruduce();
				}
			}.start();
		});
		JButton consume = new JButton("消费");
		consume.addActionListener((e)->{
			int randomInt = random.nextInt(10);
			new Thread(){
				@Override
				public void run() {
					consumers.get(randomInt).consume();
				}
			}.start();
		});
		JTable table = new JTable(DataModel.model);
		produce.setBounds(10, 230, 70, 40);
		consume.setBounds(405, 230, 70, 40);
		table.setBounds(90, 200, 300, 100);
		jLabel_producer.setBounds(10, 300, 200, 100);
		jLabel_consumer.setBounds(310, 300, 200, 100);
		add(produce);
		add(consume);
		add(table);
		add(jLabel_producer);
		add(jLabel_consumer);
	}
	
	public myframe() {
		initRole();
		initWindow();
	}
	
	public static void addWorkingProducer() {
		
		jLabel_producer.setText(WORKING_PRODUCER + count_producer.incrementAndGet());
		
	}
	
	public static void minusWorkingProducer() {
		
		jLabel_producer.setText(WORKING_PRODUCER + count_producer.decrementAndGet());
		
	}
	
	public static void addWorkingConsumer() {
		
		jLabel_consumer.setText(WORKING_CONSUMER + count_consumer.incrementAndGet());
		
	}
	
	public static void minusWorkingConsumer() {
		
		jLabel_consumer.setText(WORKING_CONSUMER + count_consumer.decrementAndGet());
		
	}
	
	
}
