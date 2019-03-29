import java.util.*;

public class Josepus {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			q.offer(i);
		}
		
		int cnt = 1;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		while(!q.isEmpty()) {
			int tmp = q.poll();
			if(cnt==m) {
				arr.add(tmp);
				cnt = 1;
			}
			else {
				q.offer(tmp);
				cnt++;
			}
		}
		
		System.out.print("<");
		for(int i=0; i<arr.size()-1;i++) {
			System.out.print(""+arr.get(i)+", ");
		}
		System.out.print(""+arr.get(arr.size()-1)+">");
	}

}
