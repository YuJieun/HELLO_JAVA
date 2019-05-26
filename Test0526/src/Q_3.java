import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_3 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] arr = new int[3][2];	
		
		int max_x = -1;
		int max_y = -1;
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			int tmp_x = Integer.parseInt(st.nextToken());
			int tmp_y = Integer.parseInt(st.nextToken());
			
			if(tmp_x>max_x)
				max_x = tmp_x;
			if(tmp_y>max_y)
				max_y = tmp_y;
			arr[i][0] = tmp_x;
			arr[i][1] = tmp_y;		
		}
		
		int[] count_x = new int[max_x+1];
		int[] count_y = new int[max_y+1];
		
		for(int i=0;i<3;i++) {
			count_x[arr[i][0]]++;
			count_y[arr[i][1]]++;
		}
		
		int x=0, y=0;
		for(int i=1; i< count_x.length;i++) {
			if(count_x[i]==1)
				x = i;
		}
		for(int i=1; i< count_y.length;i++) {
			if(count_y[i]==1)
				y = i;
		}
		
		System.out.println(x+" "+y);
	}

}
