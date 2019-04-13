import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/* 답은 맞지만 시간초과 남 */
public class Q_2178_DFS {
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static int min = Integer.MAX_VALUE;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}
		visited[0][0] = true;
		go(0, 0, 0);
		
		
		System.out.println(min+1);
	}

	public static void go(int i, int j, int dis) {
		// 목적지에 도달했으면,
		if (i == (n - 1) && j == (m - 1)) {
			min = Math.min(min, dis);
		}
		

		for (int k = 0; k < 4; k++) {
			int tmp_i = di[k] + i;
			int tmp_j = dj[k] + j;
			if (tmp_i >= 0 && tmp_i < n && tmp_j >= 0 && tmp_j < m) {
				if(map[tmp_i][tmp_j]==1 && visited[tmp_i][tmp_j]==false) {
					visited[tmp_i][tmp_j] = true;
					go(tmp_i,tmp_j,dis+1);
					visited[tmp_i][tmp_j] = false;
				}
			}
		}
	}
}
