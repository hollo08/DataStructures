package miscellaneous;

public class MissingNumbers {

	public static void main(String[] args) {
		int[] nums = { 7, 9, 10, 8, 2, 6, 1, 5, 4 };
		int len = nums.length;
		int[] temp = new int[len + 1];
		for (int num : nums)
			temp[num - 1] = num;
		for (int i = 0; i < temp.length; i++) {
			if(temp[i] == 0){
				System.out.println(i+1);
				break;
			}
		}
	}

}
