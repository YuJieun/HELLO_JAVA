import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_4 {
	static int[][] arr;
	static int r,c;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr =  new int[r][c];
		
		for(int i=0;i<r;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<c;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int len = Math.min(r, c);
		for(int n=len;n>=1;n--) {			
			for(int i=0;i<r;i++) {
				for(int j=0;j<c;j++) {
					boolean flag = check(i,j,n);
					if(flag == true) {
						System.out.println(n*n);
						return;
					}
				}
			}	
		}	
 	}
	public static boolean check(int y, int x, int len) {
		if(y+len>r || x+len>c)
			return false;
		for(int i=y;i<y+len;i++)
			for(int j=x;j<x+len;j++) {
				if(arr[i][j]==0)
					return false;
			}
		
		return true;	
	}

}
