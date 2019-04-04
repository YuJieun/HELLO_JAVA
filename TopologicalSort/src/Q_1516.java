import java.util.*;

public class Q_1516 {
	/* �� ������ Ǯ ���� ���ǻ����� �ִ�. �ǹ��� '���ÿ�'���� �� �ִٴ� ���� �����ϰ� Ǯ��� �Ѵ�
	 * �׷��� ���� ���´� �Ф�
	 * �Է¿��÷δ�
	 *  5
		10 -1
		10 1 -1
		4 1 -1
		4 3 1 -1
		3 3 2 -1 
	 * �� �ִµ�
	 * �̶� 5��° ������ ���� 23�̴�. 
	 * 2�� �ҿ� �ð� 20�̰�, 3�� �ҿ� �ð� 14�̹Ƿ�
	 * 5���� 20 + 3�� �ȴ�.
	 * �����ϱ� �������.
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
