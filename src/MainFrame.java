import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;


public class MainFrame extends JFrame {
	
	JButton runButton;
	
	JPanel leftPanel;
	JPanel rightPanel;
	
	JLabel leftTitle;
	JLabel rightTitle;
	JLabel multiplyInfo;
	
	JSlider leftSlider;
	JSlider rightSlider;
	
	
	
	
	public MainFrame() {
		
		setSize(800,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Fork-Join Framework Example");
		this.setLayout(new GridLayout(1,2));
		

		leftPanel = new JPanel(new BorderLayout());

		leftPanel = new JPanel(new BorderLayout());

		leftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(leftPanel);
		

		rightPanel = new JPanel(new BorderLayout());

		rightPanel = new JPanel(new BorderLayout());

		rightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(rightPanel);
		


		leftTitle = new JLabel("Input Matrices", SwingConstants.CENTER);
		leftPanel.add(leftTitle, BorderLayout.NORTH);
		leftPanel.add(new Matrix(true).scroll, BorderLayout.CENTER);
		runButton = new JButton("Run");

		leftPanel.add(runButton, BorderLayout.SOUTH);
		leftSlider = new JSlider(JSlider.VERTICAL, 0, 99, 0);
		leftPanel.add(leftSlider, BorderLayout.WEST);

		leftPanel.add(runButton, BorderLayout.SOUTH);
		leftSlider = new JSlider(JSlider.VERTICAL, 0, 99, 0);
		leftPanel.add(leftSlider, BorderLayout.WEST);

		
		rightTitle = new JLabel("Output Matrices", SwingConstants.CENTER);
		rightPanel.add(rightTitle, BorderLayout.NORTH);
		rightPanel.add(new Matrix(false).scroll, BorderLayout.CENTER);
		multiplyInfo = new JLabel("Na razie nic tu nie ma"); // Prawdopodobnie trzeba to bedzie zmienic - obecnie robi 
		rightPanel.add(multiplyInfo, BorderLayout.SOUTH);
		rightSlider = new JSlider(JSlider.VERTICAL, 0, 99, 0);

		rightPanel.add(rightSlider, BorderLayout.WEST);
		rightPanel.add(rightSlider, BorderLayout.WEST);

		
		
		
		setVisible(true);
	
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MainFrame frame = new MainFrame();
		
	}

}
