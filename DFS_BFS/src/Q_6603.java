import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q_6603 {
	static int[] arr;
	static boolean[] visited;
	static int n;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if(n==0)
				break;
			arr = new int[n];
			visited = new boolean[n];
			
			for(int i=0;i<n;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<arr.length;i++) {
				visited[i] = true;
				dfs(i,1);
				visited[i] = false;
			}
			System.out.println();
		}
	}
	
	public static void dfs(int i, int depth) {
		if(depth == 6) {
			for(int k=0; k<n; k++) {
				if(visited[k]==true)
					System.out.print(arr[k]+" ");
			}
			System.out.println();
		}else {
			for(int k=i+1; k<n; k++) {
				visited[k] = true;
				dfs(k,depth+1);
				visited[k] = false;
			}
		}	
	}

}
