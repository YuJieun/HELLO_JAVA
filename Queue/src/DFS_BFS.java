import java.util.*;

public class DFS_BFS {
	
	static int[][] graph;
	static boolean[] visited;
	static int N,M;
	static ArrayList<TreeMap<Integer,Integer>> arraylist;
	//treemap은 key값을 기준으로 정렬됨.
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		graph = new int[1001][1001];
		M = sc.nextInt();
		visited = new boolean[10001];
		int start = sc.nextInt();
		
		/*두번째 dfs를 위함 */
		arraylist = new ArrayList<>();
		for(int i=1;i<=M;i++) {
			arraylist.add(new TreeMap<Integer,Integer>());
		}
		
		for(int i=1;i<=M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = graph[b][a] = 1;
			
			/*두번째 dfs를 위함 */
			arraylist.get(a).put(b,a);//b가 key가 되어야 함. b가 정렬되어야 함.
			arraylist.get(b).put(a, b);
			
		}
		Arrays.fill(visited, false);
		
		dfs2(start);
		
		for(int i=1;i<=N;i++) {
			visited[i] = false;
		}
		
		System.out.println();
		bfs(start);
		
	}
	
	public static void dfs(int i) {
		/*인접행렬 사용 -> 정점이 적을 때 사용*/
		visited[i] = true;
		/* int + str 이렇게도 print가능 */
		System.out.print(i+" ");
		for(int j=0;j<=N;j++) {
			if(graph[i][j]==1 && visited[j]==false)
				dfs(j);
		}
	}
	
	public static void dfs2(int i) {
		/*인접리스트 사용 -> 정점이 많을 때*/
		visited[i] = true;
		System.out.print(i+" ");
		TreeMap<Integer,Integer> tmp = arraylist.get(i);
		for(int j:tmp.keySet()) {
			/* treeMap은 keySet()으로 키 데이터 키의 Set을 가져올 때, 정렬된 상태로 가져온다. */
			if(visited[j]==false) {
				dfs2(j);
			}
		}

	}
	
	public static void bfs(int i) {
		Queue<Integer> q = new LinkedList<Integer>();
		/* start를 넣는다 */
		q.offer(i);
		visited[i] = true;
		System.out.print(i+" ");
		
		while(!q.isEmpty()) {
			/*큐에서 하나 꺼냄 */
			int tmp = q.poll();
			for(int j=0;j<=N;j++) {
				if(graph[tmp][j]==1&&visited[j]==false) {
					q.offer(j);
					visited[j] = true;
					System.out.print(j+" ");
				}
			}
		}
	}

}
