import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_11724 {
	ArrayList[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] arr = new ArrayList[n + 1];
		
		for (int i = 1; i <= n; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		
		boolean[] visited = new boolean[n+1];
		int cnt = 0;
		for(int i=1;i<=n;i++) {
			if(visited[i]==false) {
				cnt++;
				Queue<Integer> q = new LinkedList<>();
				q.offer(i);
				visited[i] = true;
				
				while(!q.isEmpty()) {
					int tmp = q.poll();
					for(int j=0; j<arr[tmp].size();j++) {
						if(visited[arr[tmp].get(j)]==false) {
							q.offer(arr[tmp].get(j));
							visited[arr[tmp].get(j)] = true;
						}
					}
				}	
			}
		}		
		System.out.println(cnt);		
	}
}
