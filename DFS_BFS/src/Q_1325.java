import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_1325 {
	static boolean[] visited;
	static int[] computers;
	static ArrayList<Integer>[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new ArrayList[n + 1];
		computers = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a].add(b);
		}

		for (int i = 1; i <= n; i++) {
			visited = new boolean[n + 1];
			dfs(i);
		}
		
		int max = 0;
		for(int i=1 ; i<=n;i++) {
			max = Math.max(max, computers[i]);
		}
		
		for(int i=1 ; i<=n;i++) {
			if(max == computers[i])
				System.out.print(i+" ");
		}
	}

	public static void dfs(int i) {
		visited[i] = true;

		for (int tmp : arr[i]) {
			if (visited[tmp] == false) {
				computers[tmp]++;
				dfs(tmp);
			}
		}
	}

}
