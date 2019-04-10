import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q_14889 {
	static int n;
	static int[][] arr;
	static boolean[] visited;
	static int min = 987654321;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1][n + 1];
		visited = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			String[] tmp = new String[n];
			tmp = br.readLine().split(" ");
			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(tmp[j-1]);
			}
		}

		/* 조합. 1부터 시작. 깊이 0 */
		combination(1, 0);
		System.out.println(min);
	}

	public static void combination(int start, int depth) {
		if (depth == n / 2) {
			min = Math.min(min, getDifference());
		}
		for (int i = start; i <= n; i++) {
			if (visited[i] == false) {
				visited[i] = true;
				combination(i + 1, depth + 1);
				/* 차이 구하고 나면 false로 변경해줌 */
				visited[i] = false;
			}
		}
	}

	public static int getDifference() {
		int start = 0;
		int link = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (visited[i] && visited[j])
					start += arr[i][j];
				if (visited[i] == false && visited[j] == false)
					link += arr[i][j];
			}
		}
		return Math.abs(start - link);
	}

}
