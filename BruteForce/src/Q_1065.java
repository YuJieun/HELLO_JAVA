import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q_1065 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		for (int i = 1; i <= n; i++) {
			int len = (int)Math.log10(i)+1;
			if(len <=2)
				cnt++;
			else {
				int j=0;
				int dif = 10;
				int tmp = i;
				for(j=0;j<len-1;j++) {
					int val = (tmp%10) - ((tmp/10)%10);
					if(val !=dif && dif!=10)
						break;
					dif = val;
					tmp = tmp/10;
				}
				if(j == len-1)
					cnt++;
			}
		}
		System.out.print(cnt);
	}
}
