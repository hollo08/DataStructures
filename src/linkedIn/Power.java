package linkedIn;

public class Power {

	int p;
	int num;
	Integer[] powerValues;

	public Power(int num, int p) {
		this.num = num;
		this.p = p;
		powerValues = new Integer[p+1];
		powerValues[0] = 1;
		if(p>0)
			powerValues[1] = this.num;
	}

	public static void main(String[] args) {
		Power p = new Power(3, 19);
		System.out.println(p.pow(p.num, p.p));
	}

	int pow(int num, int p) {
		if(p == 0)
			return 1;
		else if (p == 1)
			return num;
		if (p % 2 == 0) {
			if (powerValues[p / 2] != null) {
				return powerValues[p / 2] * powerValues[p / 2];
			} else {
				powerValues[p / 2] = pow(num, p / 2);
				return powerValues[p / 2] * powerValues[p / 2];
			}
		} else {
			if (powerValues[(p - 1) / 2] != null) {
				return num * powerValues[(p - 1) / 2] * powerValues[(p - 1) / 2];
			} else {
				powerValues[(p - 1) / 2] = pow(num, (p - 1) / 2);
				return num * powerValues[(p - 1) / 2] * powerValues[(p - 1) / 2];
			}
		}
	}
}
