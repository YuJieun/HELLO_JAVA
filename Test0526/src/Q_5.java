import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_5 {
	static int max = -1;
	static int[][] arr;
	static int r,c;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new int[r+1][c];
		
		for(int i=0;i<r;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<c;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<4;i++)
			go(0,i,arr[0][i]);	
		
		System.out.println(max);
	}
	
	public static void go(int i, int j, int score) {
		if(i==r) {
			if(max<score)
				max = score;
			return;
		}
		
		for(int k=0;k<4;k++) {
			if(k==j)
				continue;
			go(i+1,k,score+arr[i+1][k]);
		}
	}

}
