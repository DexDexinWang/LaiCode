
public class Solution14 {
	public static void main(String[] args) {
		double[][] input = {{1, -0.2, -1}, {1, -1.5 ,1}, {0, 0, 1}};
		System.out.println(largest(input));
	}
	
	public static double largest(double[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		double max = 0;
		for (int i = 0 ; i < rows; i++) {
			double[] cur = new double[cols];
			for (int j = i; j < rows; j++) {
				if (j == i) {
					for (int k = 0; k < cols; k++) {
						cur[k] = matrix[j][k];
					}
				} else {
					for (int k = 0; k < cols; k++) {
						cur[k] *= matrix[j][k];
					}
				}
				max = Math.max(max, getMax(cur));
			}
		}
		return max;
	}
	
	private static double getMax(double[] array) {
		double max = array[0];
		double min = array[0];
		double result = array[0];
		for(int i = 1 ; i < array.length ; i++) {
			double temp = max;
			max = Math.max(array[i], Math.max(max * array[i], min * array[i]));
			min = Math.min(array[i], Math.min(temp * array[i], min * array[i]));
			if (max > result) result = max; 
		}
		return result;
	}
	
}
