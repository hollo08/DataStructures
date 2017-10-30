package weeklyContest.WC_53;

public class AlternatingBits {

	public static void main(String[] args) {
		AB_Solution sol = new AB_Solution();
		System.out.println(sol.hasAlternatingBits(10));
	}
}

class AB_Solution {
    public boolean hasAlternatingBits(int n) {
    	if(n == 0)
    		return true;
    	int lsb = (n & 1);
    	int target = lsb == 0? 1:0;
    	n = n>>1;
    	while(n>0){
    		lsb = n & 1;
    		if(lsb != target)
    			return false;
    		target = target == 0? 1:0;
    		n = n>>1;
    	}
        return true;
    }
}