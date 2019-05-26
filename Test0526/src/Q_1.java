import java.util.Scanner;

public class Q_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num_s = sc.nextLine();
		int len = num_s.length();
		
		int sum = 0;
		int num = Integer.parseInt(num_s);
		for(int i=0; i<len;i++) {
			sum += num%10;
			num = num/10;
		}
		System.out.println(sum);
	}
}
