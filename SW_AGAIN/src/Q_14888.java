import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_14888 {
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int[] op = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++)
			op[i] = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<4; i++) {
			int[] ops = {op[0],op[1],op[2],op[3]};
			if(op[i]!=0) {
				switch(i) {
					case 0:
						ops[0] -=1;
						dfs(arr[0]+arr[1],1,arr.length-1,ops);
						break;
					case 1:
						ops[1] -=1;
						dfs(arr[0]-arr[1],1,arr.length-1,ops);
						break;
					case 2:
						ops[2] -=1;
						dfs(arr[0]*arr[1],1,arr.length-1,ops);
						break;
					case 3:
						ops[3] -=1;
						dfs(arr[0]/arr[1],1,arr.length-1,ops);
						break;
				}
			}
		}
		
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void dfs(int val, int idx, int len, int[] ops) {
		if(idx == len) {
			if(val >max)
				max = val;
			if(val<min)
				min = val;
			return;
		}
		
		for(int i=0; i<4; i++) {
			int[] ops2 = {ops[0],ops[1],ops[2],ops[3]};
			if(ops[i]!=0) {
				switch(i) {
					case 0:
						ops2[0] -=1;
						dfs(val+arr[idx+1],idx+1,arr.length-1,ops2);
						break;
					case 1:
						ops2[1] -=1;
						dfs(val-arr[idx+1],idx+1,arr.length-1,ops2);
						break;
					case 2:
						ops2[2] -=1;
						dfs(val*arr[idx+1],idx+1,arr.length-1,ops2);
						break;
					case 3:
						ops2[3] -=1;
						dfs(val/arr[idx+1],idx+1,arr.length-1,ops2);
						break;
				}
			}
		}
		
		
	}
}
