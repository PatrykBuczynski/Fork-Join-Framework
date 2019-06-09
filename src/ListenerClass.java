import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



//Ta klasa zawiera Listenery dla suwaka i przycisku w g��wnym okienku
public class ListenerClass implements ActionListener, ChangeListener{

	MainFrame frame;
	Thread computeThread = new Thread(new Runnable() {

		@Override
		public void run() {
			frame.runButton.setEnabled(false);//wy��cza przycisk na czas liczenia
			frame.result.copyValues(ForkJoinMultiply.startForkJoinMultiply(frame.matrices));
			frame.runButton.setEnabled(true);
			frame.result.printMatrix();

			
		}
		
	});
	
	@Override
	public void stateChanged(ChangeEvent e) {
		
		CardLayout cl = (CardLayout)(frame.cardPanel.getLayout());
	    cl.show(frame.cardPanel, Integer.toString(frame.leftSlider.getValue()));//Tutaj wybieramy co ma pokaza� CardLayout podaj�c name kt�ry przypisali�my wcze�niej
		
		frame.sliderValue.setText(Integer.toString(frame.leftSlider.getValue()+1));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//w�a�nie tutaj objawia si� metoda copyValues, nie mo�emy przypisa� macierzy wynikowej jako 
		//result=ForkJoinMultiply.startForkJoinMultiply(frame.matrices), bo wtedy w MainFrame zostanie stary obiekt result na kt�ry nie b�dziemy dzia�ali 
		//wywo�uj�� np metod� result.printMatrix() bo result b�dzie ju� innym obiektem
		//Thread jest po to aby mo�na by�o ogl�da� wej�ciowe macierze podczas liczenia
		

		computeThread.start();
		
		
	}
	
	
	ListenerClass(MainFrame frame){//przekazujemy nasze g��wne okienko w konstruktorze
		this.frame = frame;
	}

}
