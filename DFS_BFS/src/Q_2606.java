import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 어려웠던 점 : 양방향 그래프라는 것을 인식을 못함! 만약 2 3이 들어오면 3 2도 쌍으로 생각해줘야함.*/
public class Q_2606 {
	public static ArrayList<Integer>[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int pair = Integer.parseInt(br.readLine());
		
		arr = new ArrayList[n+1];
		
		
		for(int i=1;i<=n;i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < pair; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		boolean[] visited = new boolean[n+1];
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int virus = q.poll();
			visited[virus] = true;
			for(int tmp : arr[virus]){
				/* contains로 중복체크를 해준다.*/
				if(visited[tmp]==false && !q.contains(tmp)) {
					q.add(tmp);
					cnt++;
				}
			}
		}
		
		System.out.print(cnt);
		

	}

}
