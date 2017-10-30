package dynamicProgramming;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		System.out.println(LCS("aebiocud","gluieydtikjbcd"));
	}
	static int LCS(String s1,String s2){
		int m = s1.length();
		int n = s2.length();
		int d[][] = new int[m+1][n+1];
		for(int i=0;i<=m;i++)
			for(int j=0;j<=n;j++){
				if(i==0||j==0)
					d[i][j] = 0;
				else if(s1.charAt(i-1) == s2.charAt(j-1))
					d[i][j] = d[i-1][j-1] + 1;
				else
					d[i][j] = Math.max(d[i-1][j], d[i][j-1]);
			}
		return d[m][n];
	}
}