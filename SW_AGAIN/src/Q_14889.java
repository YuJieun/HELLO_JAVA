import java.util.Scanner;

public class Q_14889 {
	static int[][] arr;
	static boolean[] start;
	static int min = Integer.MAX_VALUE;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		arr = new int[n][n];
		start = new boolean[n];
		
		for(int i=0; i<n;i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		start[0] = true;
		make_team(0,1,n/2);
		
		System.out.print(min);
	}
	public static void make_team(int index, int cnt, int total) {
		if(cnt == total) {
			int steam = 0;
			int lteam = 0;
			for(int i=0; i<n; i++) {
				if(start[i]==true) {
					for(int j=0; j<n; j++) {
						if(start[j]==true)
							steam += arr[i][j];
					}
				}else {
					for(int j=0; j<n; j++) {
						if(start[j]==false)
							lteam += arr[i][j];
					}
				}
			}
			min = Math.min(min, Math.abs(steam-lteam));
			return;
		}
		
		for(int j=index+1; j<n; j++) {
			start[j] = true;
			make_team(j,cnt+1,n/2);
			start[j] = false;
		}
	}

}

