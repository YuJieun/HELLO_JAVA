import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_6 {
	static int max = -1;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		arr = new int[tmp.length];
		
		for(int i=0; i<tmp.length;i++) {
			arr[i] = Integer.parseInt(tmp[i]);
		}
		
		if(arr.length==1) {
			System.out.println(arr[0]);
			return;
		}
		if(arr.length==2) {
			System.out.println(Math.max(arr[0], arr[1]));
			return;
		}
		
		int[][] dp = new int[arr.length][2];
		
		//len이 2이상인 경우
		// dp 정의 : dp[N] -> N번째 스티커까지 진행했을 때 얻을 수 있는 최대 값
        // dp[N][0] -> N번째 스티커까지 진행했을 때 얻을 수 있는 최대 값(0번째 스티커를 뜯는 경우)
        // dp[N][1] -> N번째 스티커까지 진행했을 때 얻을 수 있는 최대 값(0번째 스티커를 뜯지 않는 경우)
		
		//1. 0번 스티커 뜯는 경우... 마지막 원소는 뜯지 못함...0번과 인접하므로
		dp[0][0] = arr[0];
		dp[1][0] = dp[0][0];
		
		for(int i=2;i<arr.length-1;i++) {
			dp[i][0] = Math.max(dp[i-2][0]+arr[i], dp[i-1][0]);
		}
		
		dp[arr.length-1][0] = dp[arr.length-2][0]; 
		
		
		//2. 0번 스티커 뜯지 않는 경우 ... 마지막원소 뜯어도됨
		dp[0][1] = 0;
		dp[1][1] = arr[1];
		
		for(int i=2;i<arr.length;i++) {
			dp[i][1] = Math.max(dp[i-2][1]+arr[i], dp[i-1][1]);
		}
		
		System.out.println(Math.max(dp[arr.length-1][0],dp[arr.length-1][1]));
	}	
}
