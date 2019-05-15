import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q_2583 {
	static ArrayList<Integer> arr;
	static boolean[][] map;
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,-1,0,1};
	static int n,m;
	static int count;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		map = new boolean[m][n];
		
		for(int c=0;c<k;c++) {
			st = new StringTokenizer(br.readLine());
			int x_1 = Integer.parseInt(st.nextToken());
			int y_1 = Integer.parseInt(st.nextToken());
			int x_2 = Integer.parseInt(st.nextToken());
			int y_2 = Integer.parseInt(st.nextToken());
			
			for(int i=y_1;i<y_2; i++) {
				for(int j=x_1; j<x_2;j++) {
					map[i][j] = true;
				}
			}			
		}
		
		arr = new ArrayList<>();
		
		int total=0;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]==false) {
					total++;
					count = 0;
					dfs(i,j);
					arr.add(count);
				}
			}
		}
		
		Collections.sort(arr);
		System.out.println(total);
		for(int i=0;i<arr.size();i++) {
			System.out.print(arr.get(i)+" ");
		}
	}
	
	public static void dfs(int i, int j) {
		map[i][j] = true;
		count++;
		
		for(int k=0;k<4;k++) {
			int tmp_i = i+di[k];
			int tmp_j = j+dj[k];
		
			if(tmp_i>=0 &&tmp_i<m&& tmp_j>=0&& tmp_j<n) {
				if(map[tmp_i][tmp_j]==false) {
					dfs(tmp_i,tmp_j);
				}
			}
		}	
	}
}
