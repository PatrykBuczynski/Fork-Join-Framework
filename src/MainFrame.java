import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class MainFrame extends JFrame {
	
	JButton runButton;
	
	JPanel leftPanel;
	JPanel rightPanel;
	
	JLabel leftTitle;
	JLabel rightTitle;
	JLabel multiplyInfo;
	
	
	
	
	public MainFrame() {
		setSize(800,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Fork-Join Framework Example");
		this.setLayout(new GridLayout(1,2));
		
		leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(3,1));
		leftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(leftPanel);
		
		rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout(3,1));
		rightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(rightPanel);
		


		leftTitle = new JLabel("Input Matrices");
		leftPanel.add(leftTitle);
		leftPanel.add(new Matrix(true).scroll);
		runButton = new JButton("Run");
		leftPanel.add(runButton);
		
		rightTitle = new JLabel("Output Matrices");
		rightPanel.add(rightTitle);
		rightPanel.add(new Matrix(false).scroll);
		multiplyInfo = new JLabel("Na razie nic tu nie ma"); // Prawdopodobnie trzeba to bedzie zmienic - obecnie robi 

		
		
		
		setVisible(true);
	
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MainFrame frame = new MainFrame();
		
	}

}
