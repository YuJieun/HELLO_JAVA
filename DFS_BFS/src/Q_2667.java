import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q_2667 {
	public static int n;
	public static int[][] map;
	public static boolean[][] visited;
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int count;
	    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		for(int i=0;i<n;i++) {
			String st = br.readLine();
			for(int j=0;j<n;j++) {
				map[i][j] = st.charAt(j)-'0';
			}
		}
		
		ArrayList<Integer> arr = new ArrayList<>();
		int total = 0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]==1) {
					count = 0;
					total +=1;
					find(i,j);
					arr.add(count);
				}
			}
		}
		System.out.println(total);
		Collections.sort(arr);
		for(int tmp : arr) {
			System.out.println(tmp);
		}
	}
	
	public static void find(int i, int j) {
		map[i][j] = 0;
		count++;
		
		for(int k=0;k<4;k++) {
			int tmp_i = i+dx[k];
			int tmp_j = j+dy[k];
			
			if(0<=tmp_i&&tmp_i<n&&0<=tmp_j&&tmp_j<n) {
				if(map[tmp_i][tmp_j]==1)
				find(tmp_i,tmp_j);
			}
		}
		
	}
}
