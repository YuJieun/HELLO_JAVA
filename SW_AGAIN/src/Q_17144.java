import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//4시 55분 시작
public class Q_17144 {
	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		map = new int[r][c];
		
		int cleaner_i=0, cleaner_j=0;
		Queue<Dirt> q =new LinkedList<Dirt>();
		
		for(int i=0; i<r; i++ ) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					cleaner_i = i;
					cleaner_j = j;
				}else if(map[i][j]!=0) {
//					q.offer(new Dirt(i,j));
				}
			}
		}
		
		int cleaner_up = cleaner_i-1;
		int cleaner_down = cleaner_i;
//		int cleaner_col = cleaner_j;
		
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		
		//t초시행
		for(int i=0; i<t; i++) {
			//먼저 미세먼지의 확산		
//			int size = q.size();
			int[][] dirty = new int[r][c];
//			boolean[][] visited = new boolean[r][c];
			
			for(int j=0; j<r; j++) {
				for(int k=0; k<c; k++) {
					if(map[j][k]!=0 && map[j][k]!=-1) {
						int cnt = 0;
						
						for(int l=0; l<4; l++) {
							if(j+di[l]<0 || j+di[l]>=r || k+dj[l]<0 || k+dj[l]>=c || (k+dj[l]==0 && j+di[l]==cleaner_up)|| (k+dj[l]==0 && j+di[l]==cleaner_down) )
								continue;
							dirty[j+di[l]][k+dj[l]] += map[j][k]/5;
							cnt++;
						}
						map[j][k] = map[j][k]- cnt*(map[j][k]/5);		

					}
				}
			}
//			for(int j=0; j<size; j++) {
//				Dirt tmp = q.poll();
//				if(map[tmp.i][tmp.j]/5==0)
//					continue;
//				
//				int cnt = 0;
//				for(int k=0; k<4; k++) {
//					if(tmp.i+di[k]<0 || tmp.i+di[k]>=r || tmp.j+dj[k]<0 || tmp.j+dj[k]>=c || (tmp.j+dj[k]==0 && tmp.i+di[k]==cleaner_up)|| (tmp.j+dj[k]==0 && tmp.i+di[k]==cleaner_down) )
//						continue;
//					cnt++;
//				}
//				
//				for(int k=0; k<4; k++) {
//					if(tmp.i+di[k]<0 || tmp.i+di[k]>=r || tmp.j+dj[k]<0 || tmp.j+dj[k]>=c || (tmp.j+dj[k]==0 && tmp.i+di[k]==cleaner_up)|| (tmp.j+dj[k]==0 && tmp.i+di[k]==cleaner_down) )
//						continue;
//					dirty[tmp.i+di[k]][tmp.j+dj[k]] += map[tmp.i][tmp.j]/5;
//					if(visited[tmp.i+di[k]][tmp.j+dj[k]] == false) {
//						q.offer(new Dirt(tmp.i+di[k],tmp.j+dj[k]));
//						visited[tmp.i+di[k]][tmp.j+dj[k]] = true;
//					}
//				}
//				map[tmp.i][tmp.j] = map[tmp.i][tmp.j]- cnt*(map[tmp.i][tmp.j]/5);		
//			}
			
			for(int j=0; j<r; j++) {
				for(int k=0; k<c; k++) {
					map[j][k] += dirty[j][k];
				}
			}
			
			System.out.print("dd");
			
			//여기까지 확산
			//공기청정기 작동
			
			//윗부분 공기 반시계방향
			for(int j=cleaner_up-2; j>=0; j--) {
				map[j+1][0] = map[j][0];
			}
			for(int j=0; j<c-1; j++) {
				map[0][j] = map[0][j+1];
			}
			for(int j=0; j<cleaner_up; j++) {
				map[j][c-1] = map[j+1][c-1];
			}
			for(int j=c-2; j>=1; j--) {
				map[cleaner_up][j+1] = map[cleaner_up][j];
			}
			map[cleaner_up][1] = 0;
			
			//아랫부분 공기 시계방향
			for(int j=cleaner_down+1; j<r-1; j++) {
				map[j][0] = map[j+1][0];
			}
			for(int j=0; j<c-1; j++) {
				map[r-1][j] = map[r-1][j+1];
			}
			for(int j=r-2; j>=cleaner_down; j--) {
				map[j+1][c-1] = map[j][c-1];
			}
			for(int j=c-2; j>=1; j--) {
				map[cleaner_down][j+1] = map[cleaner_down][j];
			}
			map[cleaner_down][1] = 0;
			
			System.out.print("dd");

		}

		int sum = 0;
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				sum += map[i][j];
			}
		}
		System.out.print(sum+2);
	}
}

class Dirt{
	int i,j;
	public Dirt(int i, int j){
		this.i = i;
		this.j = j;
	}
}
