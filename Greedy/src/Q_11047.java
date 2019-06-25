import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q_11047 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k= Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=0;i<n;i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		
		int sum = 0;
		int len = arr.size();
		for(int i=len-1; i>=0; i--) {
			while(k>= arr.get(i)){
				k -= arr.get(i);
				sum+=1;
			}
		}
		
		System.out.println(sum);
	}
}
