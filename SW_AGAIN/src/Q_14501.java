import java.util.Scanner;

public class Q_14501 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n+10][2];
		int[] money = new int[n+10];
		
		for(int i=0; i<n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		
		int max = 0;
		for(int i=0; i<=n; i++) {
			
			money[i] = Math.max(max, money[i]);
			money[i+arr[i][0]] = Math.max(money[i+arr[i][0]] , money[i]+arr[i][1]);
			max = Math.max(max, money[i]);
		}	
		System.out.println(max);	
	}

}
