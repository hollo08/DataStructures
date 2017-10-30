package linkedIn;

public class MaxSubarray {

	public static void main(String[] args) {
		int[] a = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int[] b = new int[a.length];
		b[0] = a[0] > 0 ? a[0] : 0;
		for (int i = 1; i < a.length; i++)
			if (b[i - 1] + a[i] > 0)
				b[i] = b[i - 1] + a[i];
			else
				b[i] = 0;
		int max = -1;
		for(int i : b)
			if(max<i)
				max = i;
		System.out.println(max);
	}

}
