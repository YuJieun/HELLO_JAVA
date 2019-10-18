import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_16235 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] meal = new int[n][n];
		int[][] add = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				add[i][j] = Integer.parseInt(st.nextToken());
				meal[i][j] = 5;
			}
		}

		PriorityQueue<Tree> pq = new PriorityQueue<Tree>();
		PriorityQueue<Tree> pq2 = new PriorityQueue<Tree>();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());
			pq.offer(new Tree(x,y,z));
		}
		
		for(int i=0; i<k; i++) {
			Queue<Tree> die = new LinkedList<Tree>();
			//봄
			int len = pq.size();
			for(int j=0; j<len; j++) {
				Tree tmp = pq.poll();
				if(meal[tmp.i][tmp.j]<tmp.age) {
					die.offer(tmp);
					continue;
				}
				else {
					meal[tmp.i][tmp.j]-= tmp.age;
					pq2.offer(new Tree(tmp.i, tmp.j, tmp.age+1));
				}
			}
			
			//여름
			while(!die.isEmpty()) {
				Tree tmp = die.poll();
				meal[tmp.i][tmp.j] += tmp.age/2;
			}
			
			//가을
			len = pq2.size();
			for(int j=0; j<len; j++) {
				Tree tmp = pq2.poll();
				pq.offer(tmp);
				if(tmp.age%5==0) {
					for(int r=-1; r<=1; r++) {
						for(int c=-1; c<=1; c++) {
							if(r==0 &&c==0)
								continue;
							if(tmp.i+r<0 || tmp.i+r>=n || tmp.j+c<0 || tmp.j+c >=n)
								continue;
							pq.offer(new Tree(tmp.i+r,tmp.j+c,1));
						}
					}
				}
			}
			

			
			//겨울
			for(int j=0; j<n; j++) {
				for(int l=0; l<n; l++) {
					meal[j][l] += add[j][l];
				}
			}	
		}
		
		System.out.print(pq.size());
	}
}

class Tree implements Comparable<Tree>{
	int i,j;
	int age;
	public Tree(int i, int j, int a) {
		this.i = i;
		this.j=j;
		this.age = a;
	}
	
	@Override
	public int compareTo(Tree o) {
		return this.age - o.age;
	}
}
