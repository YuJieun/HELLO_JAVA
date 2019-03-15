package Recursive1;
import java.util.*;

public class Pil_4811 {	
	
	public static long eat (int f, int h, long [][]arr) {
		//f는 full, h는 half
		
		//해당 경우는 무조건 한가지 경우만
		if((f==1&&h==0)||f==0) {
			arr[f][h] = 1;
			return 1;
			
		//해당 경우는 있을 수 없음
		}else if(h<0) {
			return 0;
		}
		
		//해당 경우는 다음과 같이 나눠짐
		if(arr[f][h]==0) {
			arr[f][h]=eat(f-1,h+1,arr)+eat(f,h-1,arr);
		}
		return arr[f][h];

	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int num = sc.nextInt();
			if(num==0)
				break;
			else {
				long arr[][] = new long[num+1][num+1];
				System.out.println(eat(num,0,arr));
			}
				
		}
		
	}
}
