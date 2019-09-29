import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class habanki_14889 {
	static int n;
	static int[][] arr;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		arr = new int[n][n];
		visited = new boolean[n];
		
		for(int i=0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited[0] = true;
		go(0,1);
		System.out.print(min);
	}
	
	public static void go(int pos, int len) {
		if(len == n/2) {
			int start = calculate(true);
			int link = calculate(false);
			if(min>Math.abs(start-link)) {
				min = Math.abs(start-link);
			}
			return;
		}else {
			for(int i=pos+1; i<n;i++) {
				visited[i] = true;
				go(i,len+1);
				visited[i] = false;
			}
		}	
	}
	
	public static int calculate(boolean flag) {
		int sum=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==j)
					continue;
				if(visited[i]==flag && visited[j]==flag)
					sum += arr[i][j];
			}
		}
		return sum;
	}

}
