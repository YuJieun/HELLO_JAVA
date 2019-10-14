import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_15684 {
	static int min = Integer.MAX_VALUE;
	static int line,n,m;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		line = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map = new int[m+2][n+2];
		for(int i=0; i<line; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
		}	
		dfs(1,1,0);
		System.out.println(min==4?-1:min);
        	}
	
	public static void dfs(int x, int y, int cnt) {
		if(y==m+1) {
			x +=1;
			y=1;
		}
		if(cnt == 3 || (x==n&&y==m)) {
			if(check())
				min = Math.min(min,cnt);
				return;
		}
		
		dfs(x,y+1,cnt);
		if(y==m || map[x][y]==1 || (y!=1 && map[x][y-1]==1 || map[x][y+1] ==1))
			return;
		
		map[x][y]=1;
		dfs(x,y+1,cnt+1);
		map[x][y] = 0;
	}
	
	public static boolean check() {
		for(int i=1; i<=m; i++) {
            int start = i, end = i;
            for(int j=1; j<=n; j++) {
                if(map[j][end]==1) {
                    ++end;
                    continue;
                }
                if(end==1) continue;
                if(map[j][end]==0) {
                    if(map[j][end-1]==1) --end;
                }
            }
            if(start!=end) return false;
        }
        return true;
	}
}
