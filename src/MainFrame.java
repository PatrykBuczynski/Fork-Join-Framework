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
	
	JTextArea leftMatrix;
	JTextArea rightMatrix;
	
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
		

		String inicialArea = new String();
		/*Wypelniamy macierz 10x10 do wyswietlenia wypelniona zerami */
		for(int i = 0; i < 5; i++) {  					
			for(int j = 0; j < 5; j++) {

				inicialArea =  inicialArea.concat("| 0 ");
				
				
			}
			inicialArea = inicialArea.concat(" |\n");
		}

		leftTitle = new JLabel("Input Matrices");
		leftPanel.add(leftTitle);
		leftMatrix = new JTextArea(inicialArea);
		leftMatrix.setLineWrap(true);
		leftPanel.add(leftMatrix);
		runButton = new JButton("Run");
		leftPanel.add(runButton);
		
		rightTitle = new JLabel("Output Matrices");
		rightPanel.add(rightTitle);
		rightMatrix = new JTextArea(inicialArea);
		rightMatrix.setLineWrap(true);
		rightPanel.add(rightMatrix);
		multiplyInfo = new JLabel("Na razie nic tu nie ma"); // Prawdopodobnie trzeba to bedzie zmienic - obecnie robi jako placeholder
		rightPanel.add(multiplyInfo);

		
		
		
		setVisible(true);
	
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MainFrame frame = new MainFrame();
		
	}

}
