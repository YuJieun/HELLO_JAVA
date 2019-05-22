import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_11657 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		//map 정보. 0: from , 1: to, 2: time
		int[][] map = new int[m][3];
		int[] dis = new int[n+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		
		//시작지점
		dis[1] = 0;
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
			map[i][2] = Integer.parseInt(st.nextToken());
			
			//dis 초기화
			if(map[i][0] == 1) {
				if(dis[map[i][1]] > map[i][2])
					dis[map[i][1]] = map[i][2];
			}
		}
		
		boolean flag = false;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				int from = map[j][0];
				int to = map[j][1];
				int time = map[j][2];
				
				if(dis[from] != Integer.MAX_VALUE) {
					int cost = dis[from] + time;
					if(dis[to] > cost) {
						dis[to] = cost;
						
						//마지막 루프
						if(i==n-1)
							flag = true;
					}
					
				}
			}
		}
		
		if(flag)
			System.out.println(-1);
		else {
			for(int i=2;i<=n;i++) {
				System.out.println(dis[i]==Integer.MAX_VALUE? -1 : dis[i]);
			}
		}
		
		
	}

}
