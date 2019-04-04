import java.util.*;

public class Q_1516 {
	/* 이 문제를 풀 때는 주의사항이 있다. 건물은 '동시에'지을 수 있다는 것을 가정하고 풀어야 한다
	 * 그래야 답이 나온다 ㅠㅠ
	 * 입력예시로는
	 *  5
		10 -1
		10 1 -1
		4 1 -1
		4 3 1 -1
		3 3 2 -1 
	 * 가 있는데
	 * 이때 5번째 원소의 답은 23이다. 
	 * 2번 소요 시간 20이고, 3번 소요 시간 14이므로
	 * 5번은 20 + 3이 된다.
	 * 이해하기 어려웠음.
	 * */ 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] time = new int[n + 1];
		int[] nodes = new int[n + 1];
		int[] result = new int[n + 1];
		ArrayList<Integer>[] arr = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i <= n; i++) {
			time[i] = sc.nextInt();
			while (true) {
				int building = sc.nextInt();
				if (building == -1)
					break;
				arr[building].add(i);
				nodes[i]++;
			}
		}

		Queue<Integer> search = new LinkedList<>();

		for (int i = 1; i < nodes.length; i++) {
			if (nodes[i] == 0) {
				search.offer(i);
				result[i] = time[i];
			}
		}

		while (!search.isEmpty()) {
			int tmp = search.poll();
			int tmp_time = result[tmp];
			for (int element : arr[tmp]) {
				nodes[element]--;
				result[element] = Math.max(result[element],tmp_time+time[element]);
				if (nodes[element] == 0) {
					search.offer(element);
				}
			}
		}

		for (int i = 1; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

}
