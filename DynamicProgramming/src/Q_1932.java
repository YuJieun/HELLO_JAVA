import java.util.Scanner;

public class Q_1932 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int i, j, n = sc.nextInt(), max=0;
		int[][] d= new int[n+1][n+1];
		
		for(i=1; i<=n; i++) {
			for(j=1;j<=i;j++) {
				d[i][j] = sc.nextInt();
				if(j==1)
					d[i][j] = d[i-1][j] + d[i][j];
				else if(j==i)
					d[i][j] = d[i-1][j-1] + d[i][j];
				else
					d[i][j] = Math.max(d[i-1][j-1], d[i-1][j]) + d[i][j];
				
				if(max <d[i][j])
					max = d[i][j];
			}
		}
		
		System.out.println(max);
		sc.close();
	}
}
