package weeklyContest.WC_67;

public class PrimeNumberofBits {

	public static void main(String[] args) {
		PrimeNumberofBits p = new PrimeNumberofBits();
		int res = p.countPrimeSetBits(10, 15);
		System.out.println(res);
	}

	public int countPrimeSetBits(int L, int R) {
		int n = L;
		int count = 0;
		while (n <= R) {
			int bit_count = 0;
			int t = n;
			while (t > 0) {
				int bit = t & 1;
				if (bit == 1)
					bit_count++;
				t = t >> 1;
			}
			if (isPrime(bit_count))
				count++;
			n++;
		}
		return count;
	}

	boolean isPrime(int n) {
		// check if n is a multiple of 2
		if (n == 0 || n == 1)
			return false;
		if (n == 2)
			return true;
		if (n % 2 == 0)
			return false;
		// if not, then just check the odds
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
