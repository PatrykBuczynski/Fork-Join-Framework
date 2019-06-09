import java.awt.Dimension;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


/*Ta klasa to macierz, a konkretnie pole tekstowe zawieraj¹ce watoœci macierzy w values
 *
 *Metody:
 *printMatrix() - pozwala ³adnie wpisaæ wartoœci values na pole textowe
 *copyValues() - pozwala nam skopiowaæ wartoœci innego Matrix do tego, zosta³a stworzona po to, ¿eby po wstawieniu Matrix-u w MainFrame-a, 
 *mo¿na by³o zmieniæ jego wartoœci na te obliczone oraz je wyœwietliæ
 *
 *Konstruktor przyjmuje Boolean który odpowiada na pytanie czy chcemy wype³niæ values liczbami losowymi czy nie(wtedy wstawia 0)
 *
 *
 *Komponent Matrix dodajemy dodaj¹c jego scroll (np. frame.add(matrix.scroll))
 *JScrollPane to jakby okienko przez które patrzymy na pole tekstowe, czytaj: dodaje suwaki, które pozwalaj¹ nam zmieniaæ wycinek pola na które patrzymy
 */
public class Matrix extends JTextArea{

	int[][] values = new int[50][50];
	JScrollPane scroll = new JScrollPane (this, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	
	
	void printMatrix() {
		this.setText("\t");
		for(int i=1;i<=50;i++) {
			this.setText(this.getText()+i+"\t");
		}
		this.setText(this.getText()+"\n  ||==========");
		for(int i=1;i<=50;i++) {
			this.setText(this.getText()+"===========\t");
		}
		this.setText(this.getText()+"\t\n");
		
		
		
		for(int row=0; row<50; row++) {
			this.setText(this.getText()+(row+1)+"||\t");
			for(int col=0; col<50; col++) {
				this.setText(this.getText()+values[row][col]+"\t");

			}
			this.setText(this.getText()+"||"+row+"\n");
		}
		
		
		this.setText(this.getText()+"     ||========");
		for(int i=1;i<=50;i++) {
			this.setText(this.getText()+"===========\t");
		}
		this.setText(this.getText()+"\n\t");
		for(int i=1;i<=50;i++) {
			this.setText(this.getText()+i+"\t");
		}
		
	}
	
	void copyValues(Matrix newMatrix){
		for(int row=0; row<50; row++) {
			for(int col=0; col<50; col++) {
				values[row][col] = newMatrix.values[row][col];
			}
		}
	}

	Matrix(boolean isRand){
		
		super();
		Random rand = new Random();
		
		if(isRand) {
			for(int row=0; row<50; row++) {		
				
				for(int col=0; col<50; col++) {
					values[row][col] = rand.nextInt()%10;//losuje wartoœci od -10 do 10
				}
			}
		}
		else {
			for(int row=0; row<50; row++) {		
				
				for(int col=0; col<50; col++) {
					values[row][col] = 0;
				}
			}
		}

		printMatrix();
		this.setEditable(false);

	}
	

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(new Dimension(500, 500));
		frame.add(new Matrix(true).scroll);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		
		frame.setVisible(true);
	}
}

