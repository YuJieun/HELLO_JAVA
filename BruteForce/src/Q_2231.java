import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q_2231 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int min = Integer.MAX_VALUE;
		for(int i=1;i<=1000000;i++) {
			//자리수 구하기
			int len = (int)(Math.log10(i)+1);
			int sum = i;
			int tmp = i;
			for(int j=1;j<=len;j++) {
				sum += tmp%10;
				tmp = tmp/10;
			}
			if(sum == n && i<min) {
				min = i;
			}
		}
		
		if(min == Integer.MAX_VALUE)
			System.out.print(0);
		else
			System.out.print(min);

	}

}
