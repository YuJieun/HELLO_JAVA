import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* BFS 버전임. 시간초과가 나지 않음! */
public class Q_2178_BFS {
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
		
		Queue<MiroPoint> q =new LinkedList<>();
		q.add(new MiroPoint(0,0));
		
		while(true) {
			boolean flag = false;
			MiroPoint tmp = q.poll();
			if(tmp.i == n-1 && tmp.j==m-1) {
				break;
			}
			
			visited[tmp.i][tmp.j] = true;
			for (int k = 0; k < 4; k++) {
				int tmp_i = di[k] + tmp.i;
				int tmp_j = dj[k] + tmp.j;
				if (tmp_i >= 0 && tmp_i < n && tmp_j >= 0 && tmp_j < m) {
					if(map[tmp_i][tmp_j] !=0 && visited[tmp_i][tmp_j]==false) {
						visited[tmp_i][tmp_j] = true;
						q.add(new MiroPoint(tmp_i,tmp_j));
						map[tmp_i][tmp_j] = map[tmp.i][tmp.j]+1;
					}
				}
			}
		}
		System.out.println(map[n-1][m-1]);
	}
}

class MiroPoint{
	int i,j;
	MiroPoint(int i,int j){
		this.i = i;
		this.j = j;
	}
}
