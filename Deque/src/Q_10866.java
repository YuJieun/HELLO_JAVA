import java.util.*;

public class Q_10866 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String order;
		int c = 0;
		Deque<Integer> dq = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			order = sc.next();			
			if(order.equals("push_front")) {
				c = sc.nextInt();
				dq.addFirst(c);
			}else if(order.contentEquals("push_back")) {
				c = sc.nextInt();
				dq.addLast(c);
			}else if(order.contentEquals("pop_front")) {
				if(dq.isEmpty())
					System.out.println(-1);
				else
					System.out.println(dq.removeFirst());
			}else if(order.contentEquals("pop_back")) {
				if(dq.isEmpty())
					System.out.println(-1);
				else
					System.out.println(dq.removeLast());
			}else if(order.contentEquals("size")) {
				System.out.println(dq.size());
			}else if(order.contentEquals("front")) {
				if(dq.isEmpty())
					System.out.println(-1);
				else
					System.out.println(dq.peekFirst());
			}else if(order.contentEquals("back")) {
				if(dq.isEmpty())
					System.out.println(-1);
				else
					System.out.println(dq.peekLast());
			}else if(order.contentEquals("empty")) {
				if(dq.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
			}
		}
	}

}
