import java.awt.BorderLayout;
import java.awt.CardLayout;
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

/*
 * Ta klasa to g³ówne okienko z komponentami, ma wyœwietlaæ macierze
 * Funkcje main w pozosta³ych klasach s¹ nie wa¿ne, zosta³y stworzone po to ¿eby 
 * obserwowaæ surowe wyniki ich dzia³ania
 */
public class MainFrame extends JFrame {
	
	JButton runButton;
	
	JPanel leftPanel;
	JPanel rightPanel;
	JPanel cardPanel;
	
	JLabel leftTitle;
	JLabel rightTitle;
	JLabel sliderValue;
	
	JSlider leftSlider;
	
	Matrix result;//macierz wynikowa
	Matrix[] matrices;//macierze pocz¹tkowe
	String[] names;/*imiona macierzy, s¹ to zapisane ich indeksy w tablicy String
	imiona s¹ potrzebne aby ustawiaæ któr¹ z nich ma wyœwietliæ CardLayout w cardPanel-u
	*/	
	
	public MainFrame() {
		result = new Matrix(false);
		matrices = new Matrix[100];//100 macierzy do przemno¿enia
		
		cardPanel = new JPanel(new CardLayout());
		names = new String[matrices.length];
		

		for(int i=0;i<matrices.length;i++) {
			matrices[i] = new Matrix(true);//tworzymy macierz w tablicy
			
			names[i] = Integer.toString(i);//ustawiamy jej imie
			cardPanel.add(matrices[i].scroll, names[i]);//dodajemy macierz(scrolla) do panelu, razem z imieniem
		}
	
		
		
		
		
		
		setSize(800,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Fork-Join Framework Example");
		this.setLayout(new GridLayout(1,2));
		
		
		

		leftPanel = new JPanel(new BorderLayout());
		leftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(leftPanel);
		
		rightPanel = new JPanel(new BorderLayout());
		rightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(rightPanel);
		


		leftTitle = new JLabel("Input Matrices", SwingConstants.CENTER);
		leftPanel.add(leftTitle, BorderLayout.NORTH);
		
		leftPanel.add(cardPanel, BorderLayout.CENTER);
		
		
		leftSlider = new JSlider(JSlider.VERTICAL, 0, matrices.length-1, 0);
		leftSlider.addChangeListener(new ListenerClass(this));
		leftPanel.add(leftSlider, BorderLayout.WEST);
		
		sliderValue = new JLabel("1");
		leftPanel.add(sliderValue, BorderLayout.SOUTH);

		
		
		rightTitle = new JLabel("Output Matrix", SwingConstants.CENTER);
		rightPanel.add(rightTitle, BorderLayout.NORTH);
		
		rightPanel.add(result.scroll, BorderLayout.CENTER);
		runButton = new JButton("Run");
		runButton.addActionListener(new ListenerClass(this));
		rightPanel.add(runButton, BorderLayout.SOUTH);

		
		
		
		setVisible(true);
		
	}

	
	public static void main(String[] args) {		
		MainFrame frame = new MainFrame();
		
	}


}
