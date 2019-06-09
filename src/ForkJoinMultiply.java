import java.awt.Dimension;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/*
 * Ta klasa to najwa¿niejsza czêœæ programu
 * Zawiera metody rozdzielaj¹ce prace na czêœci i tak naprawdê to o to wszystko chodzi w tym projekcie
 * 
 * Metody:
 * 
 * protected Matrix compute() - Dzieli du¿y program na mniejsze, rozdzielaj¹c je do ró¿nych rdzeni do wykonania równolegle, sprawdzaj¹c czy d³ugoœæ pliku do obróbki jest mniejsza od zadanej granicy (threshold).
 * private Matrix multiplyMatrices(Matrix firstMatrix, Matrix secondMatrix) - metoda do mno¿enia dwóch macierzy, zwraca pojedyñcz¹ macierz. Wiêcej w linku ni¿ej.
 * private Matrix multiplyAll() - zaczyna mno¿yæ macierze z zadanego przedzia³u. Podobna do powy¿szej funkcji
 * public static Matrix startForkJoinMultiply(Matrix[] matrices) - funkcja rozpoczynaj¹ca ca³y proces opisanego frameworka.
 * 
 * Ogólnie polecam przeczytaæ: https://www.pluralsight.com/guides/introduction-to-the-fork-join-framework?fbclid=IwAR3wRjXhwjJhzmnA_GJWxCREzdIawHZl1JbD3fuywPfZvxZZyxoWSYjvqyo
 * St¹d wziêty jest przyk³ad.
 * 
 */
public class ForkJoinMultiply extends RecursiveTask<Matrix> {
	
	private final Matrix[] matrices;
	private final int start;
	private final int end;
	private static final int threshold = 10;
	
	public ForkJoinMultiply(Matrix[] matrices) {
		this(matrices, 0, matrices.length);
	}
	
	private ForkJoinMultiply(Matrix[] matrices, int start, int end) {
		this.matrices = matrices;
		this.start = start;
		this.end = end;
	}
	

	@Override
	protected Matrix compute() {

		int length = end - start;
		if(length <= threshold) {
			return multiplyAll();
		}
		
		ForkJoinMultiply firstTask = new ForkJoinMultiply(matrices, start, start + length/2);
		firstTask.fork();
		
		ForkJoinMultiply secondTask = new ForkJoinMultiply(matrices, start + length/2,  end);
		
		Matrix secondTastResult = secondTask.compute();
		Matrix firstTaskResult = firstTask.join();
		Matrix result = multiplyMatrices(firstTaskResult, secondTastResult);
		
		return result;
		
	}
	private Matrix multiplyMatrices(Matrix firstMatrix, Matrix secondMatrix) { // https://www.javatpoint.com/java-program-to-multiply-two-matrices bralem to z z tej strony
		Matrix result = new Matrix(false);
		
		for(int i = 0; i < 50; i++) {
			for(int j = 0; j < 50; j++) {
				for(int k = 0; k < 50; k++) {
					result.values[i][j] += firstMatrix.values[i][k] * secondMatrix.values[k][j];
				}
			}
		}

		return result;
	}
	private Matrix multiplyAll() {
		
		Matrix result = matrices[start];
		for(int i = start+1; i < end; i++) {
			result = multiplyMatrices(result, matrices[i]);
		}
		return result;
	}
	public static Matrix startForkJoinMultiply(Matrix[] matrices) {
		
		ForkJoinTask<Matrix> task = new ForkJoinMultiply(matrices);
		return new ForkJoinPool().invoke(task);
	}
	
	public static void main(String[] args) {

		Matrix[] matrices = new Matrix[2];
		
		for(int i = 0; i < matrices.length; i++) {
			matrices[i] = new Matrix(true);
		}
		
		Matrix result = ForkJoinMultiply.startForkJoinMultiply(matrices);
		result.printMatrix();
		
		JFrame frame = new JFrame();
		frame.setSize(new Dimension(500, 500));
		frame.add(result.scroll);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

}


