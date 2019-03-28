import java.util.*;

public class Queue1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		String order;
		int c=0;
		
		for(int i=0;i<num;i++) {
			order = sc.next();
			if(order.equals("push")) {
				c= sc.nextInt();
				q.offer(c);
			}else if(order.equals("pop")) {
				System.out.println(q.isEmpty()?-1:q.poll());
			}else if(order.equals("size")) {
				System.out.println(q.size());
			}else if(order.equals("empty")) {
				System.out.println(q.isEmpty()?1:0);
			}else if(order.contentEquals("front")) {
				System.out.println(q.isEmpty()?-1:q.peek());
			}else if(order.contentEquals("back")) {
				System.out.println(q.isEmpty()?-1:c);
			}
		}

	}

}
