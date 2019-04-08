import java.util.*;

public class Q_1021 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		int n = sc.nextInt();
		int m = sc.nextInt();
		LinkedList<Integer> dq = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			dq.offer(i);	
		}
		
		for (int i=0;i<m;i++) {
			int tmp = sc.nextInt();
			while(true) {
				int pos = dq.indexOf(tmp);
				int left = pos;
				int right = dq.size()-pos-1;
				if(left == 0) {
					dq.pop();
					break;
				}
				if(left<=right) {
					dq.addLast(dq.removeFirst());
					count++;
				}
				else {
					dq.addFirst(dq.removeLast());
					count++;
				}	
			}
		}
		System.out.println(count);
	}

}
