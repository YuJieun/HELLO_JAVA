import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_14890 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][n];
		boolean[][] visited = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		
		for(int i=0; i<n; i++) {
			int pre= map[i][0];
			int pre_count = 1;
			int j;
			for(j=1; j<n; j++) {
				if(map[i][j] == pre) {
					pre_count++;
					continue;
				}
				else if(map[i][j]>pre){
					if(map[i][j]== pre+1 && pre_count>=l) {
						for(int k=1; k<=l; k++) {
							 visited[i][j-k] = true;
						}
						pre = map[i][j];
						pre_count =1;
					}else {
						break;
					}
				}else {
					if(j+l > n)
						break;
					if(pre != map[i][j]+1)
						break;
					pre = map[i][j];
					int k;
					for(k=0; k<l; k++) {
						if(map[i][j+k]==pre) {
							visited[i][j+k] = true;
						}else {
							break;
						}
					}
					if(k!=l)
						break;
					j = j+l-1;
					pre_count=0;
				}
			}
			if(j!=n) {
				Arrays.fill(visited[i], false);
			}else {
				cnt++;
			}
		}
		
		
		for(int j=0; j<n; j++) {
			int pre = map[0][j];
			int pre_count =1;
			int i;
			for(i=1; i<n; i++) {
				if(map[i][j] == pre) {
					pre_count++;
					continue;
				}
				else if(map[i][j]>pre){
					if(map[i][j]== pre+1 && pre_count>=l) {
						for(int k=1; k<=l; k++) {
							 visited[i-k][j] = true;
						}
						pre = map[i][j];
						pre_count =1;
					}else {
						break;
					}
				}else {
					if(i+l >n)
						break;
					if(pre != map[i][j]+1)
						break;
					pre = map[i][j];
					int k;
					for(k=0; k<l; k++) {
						if(map[i+k][j]==pre) {
							visited[i+k][j] = true;
						}else {
							break;
						}
					}
					if(k!=l)
						break;
					i = i+l-1;
					pre_count=0;
				}
			}
			if(i!=n) {
				Arrays.fill(visited[i], false);
			}else {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
