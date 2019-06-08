import java.awt.Dimension;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

import javax.swing.JFrame;

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
				result.inicialValues[i][j] = 0;
				for(int k = 0; k < 50; k++) {
					result.inicialValues[i][j] += firstMatrix.randomValues[i][k] * secondMatrix.randomValues[k][j];
				}
			}
		}

		return result;
	}
	private Matrix multiplyAll() {
		
		Matrix result = new Matrix(false);
		for(int i = start; i < end; i++) {
			result = multiplyMatrices(result, matrices[i]);
		}
		return result;
	}
	public static Matrix startForkJoinMultiply(Matrix[] matrices) {
		
		ForkJoinTask<Matrix> task = new ForkJoinMultiply(matrices);
		return new ForkJoinPool().invoke(task);
	}
	
	public static void main(String[] args) {

		Matrix[] matrices = new Matrix[100];
		
		for(int i = 0; i < 100; i++) {
			matrices[i] = new Matrix(true);
		}
		
		Matrix result = ForkJoinMultiply.startForkJoinMultiply(matrices);
		for(int i = 0; i < 50; i++) {
			for(int j = 0; j < 50; j++) {
				System.out.println(" " + result.inicialValues[i][j] + " ");
			}
			System.out.println("--------------------\n");
		}

	}

}


