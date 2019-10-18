import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_17142 {
	static int[][] map;
	static boolean[][] live;
	static ArrayList<Virus> arr;
	static int min = Integer.MAX_VALUE;
	static int n,m;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList<>();
		map = new int[n][n];
		live = new boolean[n][n];
		for(int i=0; i<n; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2)
					arr.add(new Virus(i,j));
			}
		}
		
		for(int i=0; i<=arr.size()-m; i++) {
			live[arr.get(i).i][arr.get(i).j] = true;
			add_virus(i,1,m);
			live[arr.get(i).i][arr.get(i).j] = false;
		}
		
		System.out.print(min==Integer.MAX_VALUE?-1:min);
	}
	
	public static void add_virus(int index, int count, int m) {
		if(count == m) {
			spread();
			return;
		}
		
		for(int i=index+1; i<arr.size(); i++) {
			live[arr.get(i).i][arr.get(i).j] = true;
			add_virus(i,count+1,m);
			live[arr.get(i).i][arr.get(i).j] = false;
		}
	}
	
	public static void spread() {
		Queue<Virus> q = new LinkedList<>();
		int[][] map2 = new int[n][n];
		boolean[][] visited = new boolean[n][n];
		int blank = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map2[i][j] = map[i][j];
				if(map2[i][j]==1)
					map2[i][j] = -1;
				else if(map2[i][j]==2 && live[i][j] == true) {
					map2[i][j] = 0;
					visited[i][j] = true;
					q.offer(new Virus(i,j));
				}else if(map2[i][j]==0){
					blank++;
				}
			}
		}
			
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		int max = 0;
		int cnt = 0;
		while(!q.isEmpty()) {
			Virus tmp = q.poll();
			for(int i=0; i<4; i++) {
				int new_i = tmp.i+di[i];
				int new_j = tmp.j+dj[i];
				
				if(new_i<0|| new_i>=n ||new_j<0 || new_j>=n)
					continue;
				if(map2[new_i][new_j]==-1 || visited[new_i][new_j]==true)
					continue;
				
				int val = map2[new_i][new_j];
				visited[new_i][new_j] = true;
				map2[new_i][new_j] = map2[tmp.i][tmp.j]+1;
				if(val==0) {
					max = map2[new_i][new_j];
					cnt++;
				}
				q.offer(new Virus(new_i,new_j));
			}
		}
		
		if(cnt==blank)
			min = Math.min(max, min);
	}
}

class Virus{
	int i,j;
	
	public Virus(int i, int j) {
		this.i = i;
		this.j = j;
	}
}
