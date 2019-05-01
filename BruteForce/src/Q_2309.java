import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q_2309 {

	public static void main(String[] args) throws Exception{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int[] arr = new int[9];
		 int sum = 0;
		 for(int i=0;i<9;i++) {
			 arr[i] = Integer.parseInt(br.readLine());
			 sum += arr[i];
		 }
		 
		 Arrays.parallelSort(arr);
		 int tmp_i=0, tmp_j=0;
		 for(int i=0;i<8;i++) {
			 for(int j=i+1;j<9;j++) {
				 if(sum - arr[i] - arr[j] == 100) {
					 tmp_i = i; tmp_j=j;
				 }
			 }
		 }
		 
		 for(int i=0;i<9;i++) {
			 if(i!=tmp_i && i!=tmp_j)
				 System.out.println(arr[i]);
		 }
	}
}
