import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_14502 {
	static int max = -1;
	static int[][] map;
	static boolean[][] wall;
	static int n,m;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n*m; i++) {
			int a = i/m;
			int b = i%m;
			
			if(map[a][b]!=0)
				continue;
			else{
				wall = new boolean[n][m];
				wall[a][b] = true;
				add(i,1);
			}
		}
	
		System.out.print(max);
	}
	
	public static void add(int i, int cnt) {
		if(cnt==3) {
			int tmp = check();
			max = Math.max(max, tmp);
			return;
		}
		
		for(int j=i+1; j<n*m; j++) {
			int a = j/m;
			int b = j%m;
			
			if(map[a][b]!=0)
				continue;
			else{
				wall[a][b] = true;
				add(j,cnt+1);
				wall[a][b] = false;
			}
		}
	}
	
	public static int check() {
		Queue<Node> q = new LinkedList<Node>();
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,1,-1};
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m;j++) {
				if(map[i][j]==2)
					q.offer(new Node(i,j));
			}
		}
		boolean[][] spread = new boolean[n][m];
		
		while(!q.isEmpty()) {
			Node tmp = q.poll();
			
			for(int i=0; i<4; i++) {
				if(tmp.i+dy[i]<0 || tmp.i+dy[i]>=n || tmp.j+dx[i]<0 || tmp.j+dx[i]>=m)
					continue;
				if(map[tmp.i+dy[i]][tmp.j+dx[i]]==0 && spread[tmp.i+dy[i]][tmp.j+dx[i]]==false &&wall[tmp.i+dy[i]][tmp.j+dx[i]]==false) {
					spread[tmp.i+dy[i]][tmp.j+dx[i]] = true;
					q.offer(new Node(tmp.i+dy[i], tmp.j+dx[i]));
				}
			}
		}
		
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m;j++) {
				if(map[i][j]==0 && spread[i][j]==false && wall[i][j]==false)
					cnt++;
			}
		}
		return cnt;	
	}
}

class Node{
	int i,j;
	
	public Node(int i, int j){
		this.i = i;
		this.j = j;
	}
}
