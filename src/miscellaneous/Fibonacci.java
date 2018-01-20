package miscellaneous;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	static Map<Integer, Long[][]> dp = new HashMap<Integer, Long[][]>();
	static int complexity = 0;

	public static void main(String[] args) {
		int n = 10;
		if (n == 0)
			System.out.println(0);
		else if (n == 1)
			System.out.println(1);
		else if (n == 2)
			System.out.println(1);
		else{
			Long[][] matrix = { { 1L, 1L }, { 1L, 0L } };
			Long[][] res = matrix_pow(matrix, n-1);
			System.out.println(res[0][0]);
		}
		System.out.println(complexity);
	}

	public static Long[][] matrix_pow(Long[][] matrix, int pow){
		if(dp.containsKey(pow))
			return dp.get(pow);
		complexity++;
		if(pow == 1){
			dp.put(1, matrix);
		}
		else {
			if(pow%2 == 1){
				Long[][] temp = matrix_multi(matrix_pow(matrix, (pow-1)/2),matrix_pow(matrix, (pow-1)/2));
				Long[][] result = matrix_multi(temp, matrix);
				dp.put(pow, result);
			} else {
				dp.put(pow, matrix_multi(matrix_pow(matrix, pow/2),matrix_pow(matrix, pow/2)));
			}
		}
		return dp.get(pow);
	}

	static public Long[][] matrix_multi(Long[][] mat1, Long[][] mat2){
		Long[][] product = new Long[2][2];
		product[0][0] = mat1[0][0]*mat2[0][0] + mat1[0][1]*mat2[1][0];
		product[0][1] = mat1[0][0]*mat2[0][1] + mat1[0][1]*mat2[1][1];
		product[1][0] = mat1[1][0]*mat2[0][0] + mat1[1][1]*mat2[1][0];
		product[1][1] = mat1[1][0]*mat2[0][1] + mat1[1][1]*mat2[1][1];
		return product;
	}
}
