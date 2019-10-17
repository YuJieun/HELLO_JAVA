import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q_14499 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		int[] move = new int[k];
		int[] dice = new int[7];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<k; i++) {
			move[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<k; i++) {
			int tmp;
			switch(move[i]) {
			case 1:
				if(x+1>=m)
					continue;
				x++;
				tmp = dice[3];
				dice[3] = dice[1];
				dice[1] = dice[4];
				dice[4] = dice[6];
				dice[6] = tmp;			
				break;
			case 2:
				if(x-1<0)
					continue;
				x--;
				tmp = dice[4];
				dice[4] = dice[1];
				dice[1] = dice[3];
				dice[3] = dice[6];
				dice[6] = tmp;
				break;
			case 3:
				if(y-1<0)
					continue;
				y--;
				tmp = dice[2];
				dice[2] = dice[1];
				dice[1] = dice[5];
				dice[5] = dice[6];
				dice[6] = tmp;
				break;
			case 4:
				if(y+1>=n)
					continue;
				y++;
				tmp = dice[6];
				dice[6] = dice[5];
				dice[5] = dice[1];
				dice[1] = dice[2];
				dice[2] = tmp;
				break;
			default:
				break;
			}
			if(map[y][x] == 0)
				map[y][x] = dice[6];
			else {
				dice[6] = map[y][x];
				map[y][x] = 0;
			}
			System.out.println(dice[1]);
		}	
	}
}
