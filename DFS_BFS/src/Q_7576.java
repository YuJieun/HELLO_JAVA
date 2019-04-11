import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_7576 {
	static int n, m;
	static int[][] tomatos;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		/* map 만들기 */
		tomatos = new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				tomatos[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
	}
	
	public static void bfs() {
		Queue<Point> q = new LinkedList<Point>();
		
		
		/* 익지 않은 토마토 좌표 담아줌*/
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(tomatos[i][j]==1)
					q.offer(new Point(i,j));
			}
		}
		
		while(!q.isEmpty()) {
			Point tomato = q.poll();
			for(int i=0;i<4;i++) {
				int tmp_i = di[i]+tomato.x;
				int tmp_j = dj[i]+tomato.y;
				
				if(tmp_i<0||tmp_i>=n||tmp_j<0||tmp_j>=m)
					continue;
				
				if(tomatos[tmp_i][tmp_j]!=0)
					continue;
				
				//**최대 일수를 구해야하기 때문에 1이 아니라 현재 위치 값의 +1을 해준다.(나중에 최댓값 구하면 -> 일수)
				tomatos[tmp_i][tmp_j] = tomatos[tomato.x][tomato.y]+1;
				q.add(new Point(tmp_i,tmp_j));
			}
		}
		int max = -100;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(tomatos[i][j]==0) {
					System.out.println(-1);
					return;
				}
				max = Math.max(max, tomatos[i][j]);
				
			}
		}
		System.out.println(max-1);
	}
}

/* 토마토 좌표 클래스 (큐에 넣기 위함)*/
class Point{
	int x;
	int y;
	Point(int x, int y){
		this.x= x;
		this.y = y;
	}
}
