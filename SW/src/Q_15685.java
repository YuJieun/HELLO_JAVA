import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_15685{
	static int[][] map = new int[101][101];
	static int [][]arrow = {{1,0},{0,-1},{-1,0},{0,1}};
			
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int point[] = new int[2];
		int dir,gen;
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			point[0] = Integer.parseInt(st.nextToken());
			point[1] = Integer.parseInt(st.nextToken());
			dir = Integer.parseInt(st.nextToken());
			gen = Integer.parseInt(st.nextToken());
			
			map[point[0]][point[1]] = 1;
			
			int []directions = new int[(int)Math.pow(2, gen)];
			directions[0] = dir;
			
			make(directions,1,gen);
			draw(point,directions,gen);
			
		}
		System.out.println(countmap());
	}
	
	public static void make(int[] directions,int n, int gen) {
		if(n==(int)Math.pow(2, gen))
			return;
		for (int i=0; i<n; i++)
            directions[n+i] = (directions[n-i-1]+1) % 4;
		make(directions,n*2,gen);
	}
	
	public static void draw(int[] point,int[] directions, int generation) {
		int x,y;
		for (int i = 0; i <(int)Math.pow(2,generation) ; i++) {
			x = point[0] +arrow[directions[i]][0];
			y = point[1] +arrow[directions[i]][1];
			
			map[x][y] = 1;
			
			point[0] = x;
			point[1] = y;
		}
	}
	
	private static int countmap() {
        int cnt=0;
        for (int i=0;i<100;i++){
            for (int j = 0; j <100 ; j++) {
                if(map[i][j]==1 && map[i][j+1]==1 && map[i+1][j]==1 && map[i+1][j+1]==1)
                    cnt++;
            }
        }
        return cnt;
    }
}
