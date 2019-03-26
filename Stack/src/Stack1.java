import java.util.*;
public class Stack1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];
		int top = -1;
		String order;
		
		for(int i=0;i<num;i++) {
			order = sc.next();
			
			if(order.equals("push")) {
				top++;
				arr[top] = sc.nextInt();
			}
			else if(order.equals("pop")) {
				if(top==-1)
					System.out.println("-1");
				else {
					System.out.println(arr[top]);
					top--;
				}
			}else if(order.equals("size")) {
				System.out.println(top+1);
			}else if(order.contentEquals("empty")) {
				if(top==-1)
					System.out.println(1);
				else {
					System.out.println(0);
				}
			}else if(order.equals("top")) {
				if(top==-1)
					System.out.println(-1);
				else {
					System.out.println(arr[top]);
				}
			}
		}
	}
}
