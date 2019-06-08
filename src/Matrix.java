import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

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
		this.setText(this.getText()+"\n");
		
		
		
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
	
	
	Matrix(){
		super();
		Random rand = new Random();
		
		for(int row=0; row<50; row++) {		
					
			for(int col=0; col<50; col++) {
				values[row][col] = rand.nextInt()%10;
			}
		}
		this.setEditable(false);
		this.
		printMatrix();
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(new Dimension(500, 500));
		frame.add(new Matrix().scroll);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		
		frame.setVisible(true);
	}
}
