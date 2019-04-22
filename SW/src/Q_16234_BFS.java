import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_16234_BFS {
	public static int n,l,r;
	public static int[][] map;
	public static int[][] union;
	public static boolean[][] visited;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static int cnt=0;
	public static int move_count = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		go();
		System.out.println(move_count);
	}
	public static void go(){
		while(true) {
			union = new int[n][n];
			visited = new boolean[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(visited[i][j]==false) {
						cnt++;
						move(i,j);
					}
				}
			}
			if(cnt == n*n)
				return;
			move_count++;
//			real_move();
			cnt =  0;
		}
	}
	
	public static void real_move() {
		for(int num=1;num<=cnt;num++) {
			int sum = 0;
			int count = 0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(union[i][j]==num) {
						sum += map[i][j];
						count++;
					}
				}
			}
			int people = sum/count;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(union[i][j]==num) {
						map[i][j] = people;
					}
				}
			}
		}
	}
	
	public static void move(int i, int j) {
		
		Queue<CountryPoint> q =new LinkedList<CountryPoint>();
//		ArrayList<CountryPoint> arr = new ArrayList<CountryPoint>();
		
		q.add(new CountryPoint(i,j));
		visited[i][j] = true;
		union[i][j] = cnt;
		int sum = map[i][j];
		int c = 1;
		
		while(!q.isEmpty()) {
			CountryPoint tmp = q.poll();
			
			for(int k=0;k<4;k++) {
				int tmp_i = tmp.i+di[k];
				int tmp_j = tmp.j+dj[k];
				
				if(tmp_i>=0 && tmp_i<n && tmp_j>=0 && tmp_j<n) {
					int dif = Math.abs(map[tmp.i][tmp.j]- map[tmp_i][tmp_j]);
					if(dif>=l && dif<=r && visited[tmp_i][tmp_j]==false) {
						visited[tmp_i][tmp_j] = true;
						union[tmp_i][tmp_j] = cnt;
						sum += map[tmp_i][tmp_j];
						c++;
						q.add(new CountryPoint(tmp_i,tmp_j));
					}
				}
			}
		}
		int people = sum/c;
		for(int row=0;row<n;row++) {
			for(int col=0;col<n;col++) {
				if(union[row][col]==cnt) {
					map[row][col] = people;
				}
			}
		}
	}
}

class CountryPoint{
	int i,j;
	CountryPoint(int i, int j){
		this.i = i;
		this.j = j;
	}
}
