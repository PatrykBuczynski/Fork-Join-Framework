import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	
	JButton runButton;
	JPanel leftPanel;
	JPanel rightPanel;
	JLabel leftMatrix;
	JLabel rightMatrix;
	
	
	
	
	public MainFrame() {
		setSize(800,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Fork-Join Framework Example");
		
		
		leftPanel = new JPanel();
		add(leftPanel, BorderLayout.LINE_START);
		rightPanel = new JPanel();
		add(rightPanel, BorderLayout.LINE_END);
		
		runButton = new JButton("Run");
		leftPanel.add(runButton, BorderLayout.PAGE_END);
		
		
		
		
		
		setVisible(true);
	
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MainFrame frame = new MainFrame();
		
	}

}
