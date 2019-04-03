import java.util.*;

public class Line2252 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int students = sc.nextInt();
		int cnt = sc.nextInt();
//		int map[][] = new int[students+1][students+1];
		ArrayList<Integer>[] arr = new ArrayList[students+1];
		int[] nodes = new int[students + 1];

		for(int i=1;i<=students;i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < cnt; i++) {
			int tall = sc.nextInt();
			int small = sc.nextInt();
			arr[tall].add(small);
//			map[tall][small] = 1;
			nodes[small]++;
		}

		Queue<Integer> search = new LinkedList<>();
		Queue<Integer> result = new LinkedList<>();

		for (int i = 1; i < nodes.length; i++) {
			if (nodes[i] == 0)
				search.offer(i);
		}

		while(!search.isEmpty()){
			int tmp = search.poll();
			result.offer(tmp);
			for(int i=0;i<arr[tmp].size();i++) {
				int element = arr[tmp].get(i);
				nodes[element] -=1;
				if(nodes[element]==0)
					search.offer(element);
			}
			
		}
		
		for(int tmp:result) {
			System.out.print(tmp+" ");
		}

	}
}
