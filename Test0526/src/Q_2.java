import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q_2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = br.readLine();
		String[] arr = tmp.split(" ");
		
		int max = -1;
		for(int i=0;i<arr.length;i++) {
			if(Integer.parseInt(arr[i])>max)
				max = Integer.parseInt(arr[i]);
		}
		
		int[] count = new int[max+1];
		
		for(int i=0; i<arr.length;i++) {
			count[Integer.parseInt(arr[i])]++;
		}
		
		boolean flag = true;
		for(int i=1;i<=count.length;i++) {
			if(count[i]!=1) {
				System.out.println("false");
				flag = false;
				return;
			}
		}
		
		System.out.println("true");
	}

}
