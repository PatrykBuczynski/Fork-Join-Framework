import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



//Ta klasa zawiera Listenery dla suwaka i przycisku w g³ównym okienku
public class ListenerClass implements ActionListener, ChangeListener{

	MainFrame frame;
	Thread computeThread = new Thread(new Runnable() {

		@Override
		public void run() {
			frame.runButton.setEnabled(false);//wy³¹cza przycisk na czas liczenia
			frame.result.copyValues(ForkJoinMultiply.startForkJoinMultiply(frame.matrices));
			frame.runButton.setEnabled(true);
			frame.result.printMatrix();

			
		}
		
	});
	
	@Override
	public void stateChanged(ChangeEvent e) {
		
		CardLayout cl = (CardLayout)(frame.cardPanel.getLayout());
	    cl.show(frame.cardPanel, Integer.toString(frame.leftSlider.getValue()));//Tutaj wybieramy co ma pokazaæ CardLayout podaj¹c name który przypisaliœmy wczeœniej
		
		frame.sliderValue.setText(Integer.toString(frame.leftSlider.getValue()+1));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//w³aœnie tutaj objawia siê metoda copyValues, nie mo¿emy przypisaæ macierzy wynikowej jako 
		//result=ForkJoinMultiply.startForkJoinMultiply(frame.matrices), bo wtedy w MainFrame zostanie stary obiekt result na który nie bêdziemy dzia³ali 
		//wywo³uj¹æ np metodê result.printMatrix() bo result bêdzie ju¿ innym obiektem
		//Thread jest po to aby mo¿na by³o ogl¹daæ wejœciowe macierze podczas liczenia
		

		computeThread.start();
		
		
	}
	
	
	ListenerClass(MainFrame frame){//przekazujemy nasze g³ówne okienko w konstruktorze
		this.frame = frame;
	}

}
