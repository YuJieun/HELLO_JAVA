import java.util.Scanner;

public class Q_13458 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] people = new int[n];
		
		for(int i=0; i<n; i++) {
			people[i] = sc.nextInt();
		}
		
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		long sum=0;
		for(int i=0; i<n; i++) {
			if(people[i]<=b)
				sum += 1;
			else {
				sum++;
				int tmp = people[i]-b;
				if(tmp%c !=0)
					sum+= (tmp/c)+1;
				else
					sum += tmp/c;
			}
		}
		
		System.out.print(sum);
	}
}
