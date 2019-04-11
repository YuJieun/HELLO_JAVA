import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_14502{
	static int[][] map;
	static int[][] copy;
	
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, -1, 0, 1 };

	static int max = -1;
	static boolean[][] visited;
	static int n;
	static int m;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		combination(0,0);
		
		System.out.println(max);
	}
	
	public static void combination(int start, int depth) {
		if(depth == 3) {
			max = Math.max(max, getsafezone());
			return;
		}
		for(int i=start;i<=n*m-1;i++) {
			int tmp_i = i/m;
			int tmp_j = i%m;
			
			if(map[tmp_i][tmp_j]==0&&visited[tmp_i][tmp_j]==false) {
				visited[tmp_i][tmp_j] = true;
				combination(start+1,depth+1);
				visited[tmp_i][tmp_j] = false;
			}
			
		}
	}
	
	public static int getsafezone() {
		
		/* copy맵 만들기 & 벽 세우기*/
		copy = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				copy[i][j] = map[i][j];
				if(visited[i][j]==true)
					copy[i][j] = 1;
			}
		}
		
		/* 바이러스 퍼지기 */
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==2) {
		 			spread(i,j);
				}
			}
		}
		
		
		/* 안전영역 구하기 */
		int cnt = 0;
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < m; j++) {
	            if (copy[i][j] == 0) {
	                ++cnt;
	            }
	        }
	    }
	    return cnt;	
	}
	
	public static void spread(int i, int j) {
		for(int k=0;k<4;k++) {
			int tmp_i = di[k]+i;
			int tmp_j = dj[k]+j;
			
			if(0<=tmp_i && tmp_i<n && 0<=tmp_j && tmp_j<m) {
				if(copy[tmp_i][tmp_j]==0) {
					copy[tmp_i][tmp_j]=2;
					spread(tmp_i,tmp_j);
				}
			}
		}
	}
}
