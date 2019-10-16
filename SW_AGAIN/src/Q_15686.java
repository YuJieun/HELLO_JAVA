import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_15686 {
	static int n,m;
	static int[][] map;
	static int min = Integer.MAX_VALUE;
	static boolean[][] remain;
	static ArrayList<Point> arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		
		int cnt = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][j] = tmp;
				if(tmp==2)
					cnt++;
			}
		}
		
		//가게 정하기
		for(int i=0; i<n*n; i++) {
			int a = i/n;
			int b = i%n;
			if(map[a][b]==2) {
				remain = new boolean[n][n];
				arr = new ArrayList<Point>();
				remain[a][b] = true;
				arr.add(new Point(a,b));
				dfs(1,i);
			}
		}
		
		System.out.print(min);
	}
	
	public static void dfs(int cnt, int idx) {
		if(cnt<=m) {
			int tmp = check();
			min = Math.min(min, tmp);
			if(cnt==m)
				return;
		}
		
		for(int j=idx+1; j<n*n; j++) {
			int a = j/n;
			int b = j%n;
			
			if(map[a][b]==2) {
				remain[a][b] = true;
				arr.add(new Point(a,b));
				dfs(cnt+1,j);
				remain[a][b] = false;
				arr.remove(arr.size()-1);
			}
		}	
	}
	
	public static int check() {
		int sum = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]==1) {
					int tmp = Integer.MAX_VALUE;
					for(int k=0; k<arr.size(); k++) {
						int tmp2 = Math.abs(i-arr.get(k).i) + Math.abs(j-arr.get(k).j);
						tmp = Math.min(tmp, tmp2);
					}
					
					sum+= tmp;
				}
			}
		}
		
		
		return sum;
	}
}

class Point{
	int i, j;
	
	public Point(int i, int j) {
		this.i = i;
		this.j = j;
	}
}
