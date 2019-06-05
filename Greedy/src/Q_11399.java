import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_11399 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int total_sum = 0;
		int current_time = 0;
		
		for(int i=0;i<n;i++) {
			current_time += arr[i];
			total_sum += current_time;
		}
		
		System.out.println(total_sum);
		
		
		
		
		
		
	}
}
