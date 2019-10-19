import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q_16234 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		int r = sc.nextInt();
		
		int[][] map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		
		int move_cnt= 0;
		while(true) {
			ArrayList<Integer> people = new ArrayList<>();
			people.add(0);
			int[][] visited = new int[n][n];
			Queue<Country> q = new LinkedList<>();
			
			//몇번째 영역인지
			int union = 0;
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					//나라 개수
					int cnt = 0;
					//나라 합
					int sum = 0;
					if(visited[i][j]==0) {
						union++;
						cnt++;
						sum += map[i][j];
						q.offer(new Country(i,j));
						visited[i][j] = union;
					
						while(!q.isEmpty()) {
							Country tmp = q.poll();
							for(int k=0; k<4; k++) {
								int new_i = tmp.i +di[k];
								int new_j = tmp.j +dj[k];
								if(new_i<0 || new_i>=n || new_j<0 ||new_j>=n || visited[new_i][new_j]!=0)
									continue;
								if(Math.abs(map[new_i][new_j]-map[tmp.i][tmp.j])>=l &&Math.abs(map[new_i][new_j]-map[tmp.i][tmp.j])<=r ) {
									cnt++;
									sum += map[new_i][new_j];
									visited[new_i][new_j] = union;
									q.offer(new Country(new_i, new_j));
								}
							}
						}
						int val = sum/cnt;
						people.add(val);
					}
				}
			}
			
			if(union == n*n)
				break;
			move_cnt++;
			
			for(int i=0; i<n; i++) {
				for(int j=0 ;j<n; j++) {
					map[i][j] = people.get(visited[i][j]);
				}
			}
		}
		
		System.out.print(move_cnt);
		
		
		
	}
}

class Country{
	int i,j;
	public Country(int i, int j) {
		this.i =i;
		this.j = j;
	}
}
