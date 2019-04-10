import java.util.Scanner;

public class QP14499 {
	static int[] dice = new int[7];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int k = sc.nextInt();
		
		int[][] map = new int[n+1][m+1];
		for(int i = 0; i<n;i++) {
			for(int j=0; j<m;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		
				
		for(int i=0; i<k;i++) {
			int order = sc.nextInt();
			if((order==1&&y==m-1)||(order==2&&y==0)||(order==3&&x==0)||(order==4&&x==n-1)) {
				continue;
			}
			changedice(order);
			if(order ==1)
				y++;
			else if(order==2)
				y--;
			else if(order ==3)
				x--;
			else if(order==4)
				x++;
			
			if(map[x][y]==0) {
				map[x][y] = dice[6];
			}else {
				dice[6] = map[x][y];
				map[x][y] = 0;
			}
			System.out.println(dice[1]);
			
		}
		
		
	}
	
	public static void changedice(int d) {
		int[] tmp = dice.clone();
		if(d==1) {
			dice[1] = tmp[4];
			dice[3] = tmp[1];
			dice[6] = tmp[3];
			dice[4] = tmp[6];
		}
		else if(d==2) {
			dice[4] = tmp[1];
			dice[1] = tmp[3];
			dice[3] = tmp[6];
			dice[6] = tmp[4];
		}
		else if(d==3) {
			dice[1] = tmp[5];
			dice[2] = tmp[1];
			dice[5] = tmp[6];
			dice[6] = tmp[2];
		}else {
			dice[1] = tmp[2];
			dice[2] = tmp[6];
			dice[5] = tmp[1];
			dice[6] = tmp[5];
		}
	}
}
