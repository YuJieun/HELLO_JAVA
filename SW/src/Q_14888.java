import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_14888 {
	static int n;
	static int[] arr;
	static int max = -1000000000;
	static int min = 1000000000;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		int[] op = new int[4];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(op[0],op[1],op[2],op[3], 0, arr[0]);
		
		System.out.println(max);
		System.out.print(min);
		
	}
	
	public static void dfs(int a, int b, int c, int d, int index, int val) {
		if(index==n-1) {
			if(val <min)
				min = val;
			if(val>max)
				max = val;
		}
		if(a>0)
			dfs(a-1,b,c,d,index+1,val+arr[index+1]);
		if(b>0)
			dfs(a,b-1,c,d,index+1,val-arr[index+1]);
		if(c>0)
			dfs(a,b,c-1,d,index+1,val*arr[index+1]);
		if(d>0)
			dfs(a,b,c,d-1,index+1,val/arr[index+1]);

	}

}
