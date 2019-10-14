import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] di = {0,-1,0,1};
	static int[] dj = {-1,0,1,0};
	
	static int[] back_di = {1,0,-1,0};
	static int[] back_dj = {0,-1,0,1};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		int flag = 0;
		while(true) {
			//현재 위치 청소
			if(flag ==0) {
				visited[r][c] = true;
				cnt++;
			}
			
			int i;
			for(i=0; i<4 ; i++) {
				if(flag == 1)
					flag = 0;
				
				if(r+di[dir]<0 || r+di[dir]>=n || c+dj[dir]<0 || c+dj[dir]>=m) {
					dir=(dir + 3) % 4;
					continue;
				}
				//a
				if(map[r+di[dir]][c+dj[dir]]!=1 && visited[r+di[dir]][c+dj[dir]]==false) {
					r = r+di[dir];
					c = c+dj[dir];
					dir=(dir + 3) % 4;
					break;
				}
				
				//b
				if(map[r+di[dir]][c+dj[dir]]==1 || visited[r+di[dir]][c+dj[dir]]==true) {
					dir=(dir + 3) % 4;
					continue;
				}
			}
			
			if(i<4)
				continue;
			else {
				if(r+back_di[dir]<0 || r+back_di[dir]>=n || c+back_dj[dir]<0 || c+back_dj[dir]>=m)
					break;
				if(map[r+back_di[dir]][c+back_dj[dir]]==1) {
					break;
				}else {
					r = r+back_di[dir];
					c = c+back_dj[dir];
					flag = 1;
				}
			}	
		}
		System.out.print(cnt);	
		
	}

}
