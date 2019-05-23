import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q_1504 {
	static int[][] dis;
	static ArrayList<Point3>[] arr;
	static int n,e;
	static final int INF = 800*1000;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[n+1];
		//다익스트라 세번호출
		dis = new int[3][n+1];
		
		for(int i=0;i<3;i++) {
			Arrays.fill(dis[i], INF);
		}
		
		for(int i=1;i<=n;i++) {
			arr[i] = new ArrayList<>();
		}
			
		for(int i=0;i<e;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[a].add(new Point3(b,c));
			arr[b].add(new Point3(a,c));
		}
		st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken());
		int second = Integer.parseInt(st.nextToken());
		
		//시작경로, 몇번째 다익스트라호출인지
		dijkstra(1,0);
		dijkstra(first,1);
		dijkstra(second,2);
		
		int minCost = Math.min(dis[0][first]+dis[1][second]+dis[2][n], dis[0][second]+dis[2][first]+dis[1][n]);
		System.out.println(minCost>=INF?-1:minCost);
	}
	
	public static void dijkstra(int src, int idx) {
		PriorityQueue<Point3> pq = new PriorityQueue<Point3>();
		
		pq.add(new Point3(src,0));
		dis[idx][src] = 0;
		
		while(!pq.isEmpty()) {
			Point3 tmp = pq.poll();
			
			if(dis[idx][tmp.to]<tmp.cost)
				continue;
			
			for(int j=0; j<arr[tmp.to].size(); j++) {
				Point3 next = arr[tmp.to].get(j);
				if(dis[idx][next.to] > dis[idx][tmp.to]+next.cost) {
					dis[idx][next.to] = dis[idx][tmp.to]+next.cost;
					pq.add(new Point3(next.to,dis[idx][next.to]));
				}
			}
		}
	}

}

class Point3 implements Comparable<Point3>{
	int to, cost;
	
	Point3(int to, int cost){
		this.to = to;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Point3 p) {
		return this.cost - p.cost;
	}
}
