import java.util.*;
public class Q_14501 {

	/* 이게 DP이다. 
	 * 공부 많이하기
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = 0;
		int[] t = new int[n+1];
		int[] p = new int[n+1];
		int[] dp = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		
		for(int i=1;i<=n;i++) {
			//이전보다 적으면 안되니까 max값으로 변경. 그런데 이미 max보다 큰 값으로 채워져 있는경우,
			//그값 유지.
			dp[i] = Math.max(dp[i],max);
			//일이 끝난 시점의 보상 변경해주기. 그런데 이미 더 큰 보상으로 채워져 있는 경우에는 그대로 놔두기
			dp[t[i]+i] = Math.max(dp[t[i]+i],p[i]+dp[i]);
			//최댓값 갱신해주기. 기존의 max와 현재 dp중에...
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
		
		
	}

}
