import java.util.*;
import java.io.*;
public class StackSequence {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		int num = Integer.parseInt(br.readLine());
		int max = 0;
		int top = 0;
		int stack[] = new int[num];
		
		while(num-->0) {
			int temp = Integer.parseInt(br.readLine());
			if(temp>max) {
				for(int j=max+1;j<=temp;j++) {
					stack[top++] = j;
					str.append("+\n");
				}
				max = temp;
			}
			else if(stack[top-1]!=temp) {
				System.out.print("No");
				return;
			}
			
			top--;
			str.append("-\n");
		}
		System.out.println(str);	
	}
}
