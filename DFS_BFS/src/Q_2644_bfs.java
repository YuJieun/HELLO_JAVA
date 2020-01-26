package src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q_2644 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] map = new int[n+1][n+1];
		boolean[][] visited = new boolean[n+1][n+1];
		
		int first = sc.nextInt();
		int second = sc.nextInt();
		int m = sc.nextInt();
		for(int i=0 ;i<m; i++) {
			int parent = sc.nextInt();
			int child = sc.nextInt();
			map[parent][child]=1;
			map[child][parent]=1;
		}
		
		Queue<Human> q = new LinkedList<>();
		q.offer(new Human(first,0));
		while(!q.isEmpty()) {
			Human tmp = q.poll();
			for(int i=1; i<=n; i++) {
				if(map[tmp.num][i]==1 && visited[tmp.num][i]==false) {
					if(i==second) {
						System.out.print(tmp.cnt+1);
						return;
					}
					visited[tmp.num][i] = true;
					q.offer(new Human(i,tmp.cnt+1));
				}
			}
		}
		System.out.print(-1);
	}

}

class Human{
	int num, cnt;
	
	public Human(int n, int c) {
		this.num = n;
		this.cnt = c;
	}
}
