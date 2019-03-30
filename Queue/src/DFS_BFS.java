import java.util.*;

public class DFS_BFS {
	
	static int[][] graph;
	static boolean[] visited;
	static int N,M;
	static ArrayList<TreeMap<Integer,Integer>> arraylist;
	//treemap�� key���� �������� ���ĵ�.
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		graph = new int[1001][1001];
		M = sc.nextInt();
		visited = new boolean[10001];
		int start = sc.nextInt();
		
		/*�ι�° dfs�� ���� */
		arraylist = new ArrayList<>();
		for(int i=1;i<=M;i++) {
			arraylist.add(new TreeMap<Integer,Integer>());
		}
		
		for(int i=1;i<=M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = graph[b][a] = 1;
			
			/*�ι�° dfs�� ���� */
			arraylist.get(a).put(b,a);//b�� key�� �Ǿ�� ��. b�� ���ĵǾ�� ��.
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
		/*������� ��� -> ������ ���� �� ���*/
		visited[i] = true;
		/* int + str �̷��Ե� print���� */
		System.out.print(i+" ");
		for(int j=0;j<=N;j++) {
			if(graph[i][j]==1 && visited[j]==false)
				dfs(j);
		}
	}
	
	public static void dfs2(int i) {
		/*��������Ʈ ��� -> ������ ���� ��*/
		visited[i] = true;
		System.out.print(i+" ");
		TreeMap<Integer,Integer> tmp = arraylist.get(i);
		for(int j:tmp.keySet()) {
			/* treeMap�� keySet()���� Ű ������ Ű�� Set�� ������ ��, ���ĵ� ���·� �����´�. */
			if(visited[j]==false) {
				dfs2(j);
			}
		}

	}
	
	public static void bfs(int i) {
		Queue<Integer> q = new LinkedList<Integer>();
		/* start�� �ִ´� */
		q.offer(i);
		visited[i] = true;
		System.out.print(i+" ");
		
		while(!q.isEmpty()) {
			/*ť���� �ϳ� ���� */
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
