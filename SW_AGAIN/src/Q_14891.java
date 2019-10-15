import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_14891{
//	static int[][] topni;
	static ArrayList<Integer>[] topni;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		topni = new ArrayList[4];
		for(int i=0;i<4;i++) {
			topni[i] = new ArrayList<Integer>();
		}
				
		for(int i=0;i<4;i++) {
			String s = br.readLine();
			for(int j=0;j<8;j++) {
				topni[i].add(s.charAt(j)-'0');
			}	
		}	
		
		visited = new boolean[4];
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int what = Integer.parseInt(st.nextToken())-1;
			
			//dir이 1 : 시계  , -1:반시계
			int dir = Integer.parseInt(st.nextToken());		
//			int left = topni[what-1][6];
//			int right = topni[what-1][2];
			rotate(what,dir);
			Arrays.fill(visited, false);
		}
		
		int[] score = {1,2,4,8};
		int sum = 0;
		for(int i=0;i<4;i++) {
			sum+= topni[i].get(0)*score[i];
		}
		System.out.println(sum);
	}
	
	public static void rotate(int what, int dir) {
		if(visited[what]==true) {
			return;
		}else {
			visited[what] = true;
		}
		if(what==0) {
			int right = topni[what].get(2);
			if(right != topni[what+1].get(6)) {
				rotate(what+1,dir*(-1));
			}
			rotatewhatdir(dir,what);

		}else if(what==3) {
			int left = topni[what].get(6);
			if(left != topni[what-1].get(2)) {
				rotate(what-1,dir*(-1));
			}
			rotatewhatdir(dir,what);


		}else {
			int left = topni[what].get(6);
			int right = topni[what].get(2);
			
			if(left != topni[what-1].get(2)) {
				rotate(what-1,dir*(-1));
			}
			if(right != topni[what+1].get(6)) {
				rotate(what+1,dir*(-1));
			}
			
			rotatewhatdir(dir,what);
		}
	}
	
	public static void rotatewhatdir(int dir, int what) {
		if(dir==1) {
			int tmp = topni[what].get(7);
			topni[what].remove(7);
			topni[what].add(0, tmp);
		}
		
		if(dir==-1) {
			int tmp = topni[what].get(0);
			topni[what].remove(0);
			topni[what].add(tmp);
		}
	}
}
