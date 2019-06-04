import java.util.Scanner;

public class Q_11066 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int test=0; test<t; test++) {
			int k = sc.nextInt();
			int[] arr = new int[k];
			for(int i=0; i<k; i++)
				arr[i] = sc.nextInt();
			System.out.println(solution(arr));

		}
	}
	
	public static int sum(int[] a, int s, int e) {
		if(s==0)
			return a[e];
		else
			return a[e]-a[s-1];
	}
	
	public static int solution(int[] a) {
		int size = a.length;
		int[][] dp = new int[size][size]; //i~j까지 최소합 DP
		int[] s = new int[size]; //sum 저장
		
		s[0] = a[0];
		
		for(int i=1; i<size;i++)
			s[i] += s[i-1]+a[i];
		
		for(int i=0; i<size-1; i++)
			dp[i][i+1] = a[i] + a[i+1];
		
		for(int gap=2; gap<size; gap++) {
			for(int i=0; i+gap<size;i++) {
				int j = i+gap;
				dp[i][j] = Integer.MAX_VALUE;
				
				for(int k=i; k<j; k++) { //i~j 사이의 k값
					dp[i][j] = Math.min(dp[i][k] + dp[k+1][j] + sum(s,i,j), dp[i][j]);
				}
			}
		}
		return dp[0][a.length-1];
		
	}
}
