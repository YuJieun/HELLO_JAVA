import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_1865 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    int tc = Integer.parseInt(br.readLine());
	    while(tc-->0) {
	    	st = new StringTokenizer(br.readLine());
	    	int n = Integer.parseInt(st.nextToken());
	    	int m = Integer.parseInt(st.nextToken());
	    	int w = Integer.parseInt(st.nextToken());
	    	
	    	
	    	ArrayList<Point2>[] road_arr = new ArrayList[n+1];	
	        
	        for(int j=1; j<=n; j++) {
	           road_arr[j] = new ArrayList<Point2>();
	        }
	        
	    	for(int j=0; j<m; j++) {
	    		st = new StringTokenizer(br.readLine());
	    		int a = Integer.parseInt(st.nextToken());
	    		int b = Integer.parseInt(st.nextToken());
	    		int time = Integer.parseInt(st.nextToken());
	    		
	    		road_arr[a].add(new Point2(b,time));
	    		road_arr[b].add(new Point2(a,time));
	    	}
	    	
	    	for(int j=0; j<w; j++) {
	    		st = new StringTokenizer(br.readLine());
	    		int a = Integer.parseInt(st.nextToken());
	    		int b = Integer.parseInt(st.nextToken());
	    		int time = Integer.parseInt(st.nextToken());
	    		
	    		road_arr[a].add(new Point2(b,-time));
	    	}
	    	
	    	boolean flag = false;
	    	int[] dis = new int[n+1];

	    	
	    	//dis[1]은 0으로 나머지는 max로
	    	for(int i=2; i<=n;i++)
	    		dis[i] = Integer.MAX_VALUE;
	    	for(int i=1;i<=n; i++) {
	    		for(int j=1; j<=n;j++) {
	    			for(Point2 tmp : road_arr[j]) {
	    				int there = tmp.to;
	    				int d = tmp.time;
	    				if(dis[j]!= Integer.MAX_VALUE && (dis[there]>dis[j]+d)) {
	    					dis[there] = dis[j] + d;
	    					if(i == n)
	    						flag = true;
	    				}
	    			}
	    		}
	    	}
 	    	System.out.println(flag?"YES":"NO"); 	
	    }
	}
}

class Point2{
	int to, time;
	
	Point2(int to, int time){
		this.to = to;
		this.time = time;
	}
}

