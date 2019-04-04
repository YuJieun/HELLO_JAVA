import java.util.*;

public class Q_1766 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		ArrayList<Integer>[] arr = new ArrayList[n+1];
		int[] nodes = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<m;i++) {
			int before = sc.nextInt();
			int after = sc.nextInt();
			arr[before].add(after);
			nodes[after]++;
		}
		
		PriorityQueue<Integer> search = new PriorityQueue<Integer>();
		Queue<Integer> result = new LinkedList<>();
		
		for (int i = 1; i < nodes.length; i++) {
			if (nodes[i] == 0) {
				search.offer(i);
			}
		}
		
		while(!search.isEmpty()) {
			int tmp = search.poll();
			result.offer(tmp);
			for(int element:arr[tmp]) {
				nodes[element]--;
				if(nodes[element]==0)
					search.offer(element);
			}
		}
		
		for(int tmp:result) {
			System.out.print(tmp+" ");
		}

	}
}

