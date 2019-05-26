import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q_10217 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    int t = Integer.parseInt(br.readLine());
	    while(t-->0) {
	    	st = new StringTokenizer(br.readLine());
	    	int n = Integer.parseInt(st.nextToken());
	    	int m = Integer.parseInt(st.nextToken());
	    	int k = Integer.parseInt(st.nextToken());
	    	
	    	ArrayList<Point4>[] arr = new ArrayList[n+1];
	        
	        for(int i=1; i<=n; i++) {
	           arr[i] = new ArrayList<Point4>();
	        }
	    	
	    	for(int i = 0; i<k; i++) {
	    		st = new StringTokenizer(br.readLine());
	            int from = Integer.parseInt(st.nextToken());
	            int to = Integer.parseInt(st.nextToken());
	            int cost = Integer.parseInt(st.nextToken()); 
	            int time = Integer.parseInt(st.nextToken());
	            arr[from].add(new Point4(to,cost,time));
	    	}
	    	
	    	int[] dis = new int[n+1];
	    	int[] cost = new int[n+1];
	        Arrays.fill(dis, -1);
	        Arrays.fill(cost, -1);
	        dis[1] = 0;
	        cost[1] = 0;
	        
	        PriorityQueue<Point4> q= new PriorityQueue<>();
	        q.add(new Point4(1,0,0));
	        
	        while(!q.isEmpty()) {
	           Point4 current = q.poll();
	           for(int i=0;i<arr[current.to].size();i++) {
	              Point4 tmp = arr[current.to].get(i);
	              int next_node = tmp.to;
	              int next_val = tmp.time + dis[current.to];
	              
	              if(dis[next_node]==-1) {
	            	 cost[next_node] = tmp.cost + cost[current.to];
	                 dis[next_node] = next_val;
	                 q.add(new Point4(next_node,tmp.cost+ cost[current.to],next_val));
	              }
	              if(dis[next_node]>next_val) {
	            	 cost[next_node] = tmp.cost + cost[current.to];
	                 dis[next_node] = next_val;
	                 q.add(new Point4(next_node,tmp.cost+ cost[current.to],next_val));
	              }
	           }
	        }
	        
            if(dis[n]==-1) {
               System.out.println("Poor KCM");
            }else if(cost[n]>m) {
            	System.out.println("Poor KCM");
            }
            else {
               System.out.println(dis[n]);
            }
	         
	    	
	    }
	}
}

class Point4 implements Comparable<Point4>{
	int to, time, cost;   
	Point4(int to, int cost,int time){
		this.to = to;
		this.time = time;
		this.cost = cost;
	}
   
   @Override
   public int compareTo(Point4 p) {
	   return this.time - p.time;
   }
}
