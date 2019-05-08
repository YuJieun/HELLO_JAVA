import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_7568 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		int[] len = new int[n];
		Arrays.fill(len, 1);
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==j)
					continue;
				if(arr[j][0]>arr[i][0] && arr[j][1]>arr[i][1])
					len[i]++;
			}
		}
		for(int i=0;i<n;i++) {
			System.out.print(len[i]+" ");
		}
	}
}
