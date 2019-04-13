import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test2 {
	static int n;
	static int min = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			map = new int[n+1][n+1];
			ArrayList<String> res = new ArrayList<>();

			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				int vi = Integer.parseInt(st.nextToken());
				int ui = Integer.parseInt(st.nextToken());
				int di = Integer.parseInt(st.nextToken());
				map[vi][ui] = di;
			}
			
			for(int j=1;j<=n;j++) {
				visited = new boolean[n+1][n+1];
				search(j,j,0);
				res.add(String.valueOf(min));
				/*if(j!=n){
					System.out.print(min+" ");
				}else{
					System.out.print(min);
				}*/
				min = Integer.MAX_VALUE;
			}
			/*if(i<t-1){
				System.out.println();
			}*/
			System.out.println(String.join(" ", res));
			System.out.println();
		}
	}
	
	public static void search(int start, int city, int dis) {
		if(start == city && dis!=0) {
			min = Math.min(min, dis);
		}
			
		for(int i=1;i<=n;i++) {
			if(map[city][i]!=0&&visited[city][i]==false) {
				visited[city][i] = true;
				search(start,i,dis+map[city][i]);
				visited[city][i] = false;
			}
		}
	}

}
