import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_10451 {
	static boolean[] visited;
	static int[] map;
	static int cnt = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			map = new int[n+1];
			st = new StringTokenizer(br.readLine());
			
			for(int j=1;j<=n;j++) {
				map[j] = Integer.parseInt(st.nextToken());
			}
			
			visited = new boolean[n+1];
			for(int j=1;j<=n;j++) {
				if(visited[j]==false)
					go(j);
			}
			System.out.println(cnt);
			cnt=0;
		}
	}
	public static void go(int index) {
		visited[index]= true;
		if(visited[map[index]] == true)
			cnt++;
		else
			dfs(map[index]);
	}
}
