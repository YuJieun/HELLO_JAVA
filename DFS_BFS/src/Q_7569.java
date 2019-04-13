import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_7569 {
	static int[][][] tomatos;
	static int n,m,h;
	//상하좌우위아래
	static int[] di = {-1,1,0,0,0,0};
	static int[] dj = {0,0,-1,1,0,0};
	static int[] dh = {0,0,0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		/* 맵 만들기  */
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		Queue<TomatoPoint> q =new LinkedList<TomatoPoint>();
		tomatos = new int[h][n][m];
		
		/* 맵 만들고 익은 토마토 큐에 넣기*/
		for(int height=0;height<h;height++) {
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<m;j++) {
					int tmp = Integer.parseInt(st.nextToken());
					tomatos[height][i][j] = tmp;
					if(tmp == 1) {
						q.add(new TomatoPoint(i,j,height));
					}
				}
			}
		}
		
		while(!q.isEmpty()) {
			TomatoPoint tomato = q.poll();
			for(int k=0;k<6;k++) {
				int tmp_i = tomato.i+di[k];
				int tmp_j = tomato.j+dj[k];
				int tmp_h = tomato.h+dh[k];
				
				if(tmp_i>=0 && tmp_i<n && tmp_j>=0 && tmp_j<m && tmp_h>=0&& tmp_h<h) {
					if(tomatos[tmp_h][tmp_i][tmp_j]==0) {
						tomatos[tmp_h][tmp_i][tmp_j]=tomatos[tomato.h][tomato.i][tomato.j]+1;
						q.add(new TomatoPoint(tmp_i,tmp_j,tmp_h));
					}
				}
			}
		}	
		count();
	}
	
	public static void count() {
		int max = Integer.MIN_VALUE;
		for(int height=0;height<h;height++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(tomatos[height][i][j]==0) {
						System.out.println(-1);
						return;
					}
					max = Math.max(max, tomatos[height][i][j]);
				}
			}
		}
		System.out.println(max-1);
	}
}

/* 위치 저장 위한 클래스 */
class TomatoPoint{
	int i,j,h;
	TomatoPoint(int i, int j, int h){
		this.i = i;
		this.j = j;
		this.h = h;
	}
}