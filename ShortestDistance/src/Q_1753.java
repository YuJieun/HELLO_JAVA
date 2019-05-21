import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_1753 {

   public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      
      st = new StringTokenizer(br.readLine());
      int v = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      
      int start = Integer.parseInt(br.readLine());
      ArrayList<Point>[] arr = new ArrayList[v+1];
      
      for(int i=1; i<=v; i++) {
         arr[i] = new ArrayList<Point>();
      }
      
      for(int i=0;i<e;i++) {
         st = new StringTokenizer(br.readLine());
         int from = Integer.parseInt(st.nextToken());
         int to = Integer.parseInt(st.nextToken());
         int weight = Integer.parseInt(st.nextToken());         
         arr[from].add(new Point(to,weight));
      }
      
      int[] dis = new int[v+1];
      
      for(int i=1;i<=v;i++) {
         if(i==start)
            dis[i] = 0;
         else
            dis[i] = -1;
      }
      
      PriorityQueue<Point> q= new PriorityQueue<>();
      q.add(new Point(start,0));
      
      while(!q.isEmpty()) {
         Point current = q.poll();
         for(int i=0;i<arr[current.to].size();i++) {
            Point tmp = arr[current.to].get(i);
            int next_node = tmp.to;
            int next_val = tmp.weight + dis[current.to];
            
            if(dis[next_node]==-1) {
               dis[next_node] = next_val;
               q.add(new Point(next_node,next_val));
            }
            if(dis[next_node]>next_val) {
               dis[next_node] = next_val;
               q.add(new Point(next_node,next_val));
            }
         }
      }
      for(int i=1;i<=v;i++) {
         if(dis[i]==-1) {
            System.out.println("INF");
         }else {
            System.out.println(dis[i]);
         }
      }   
   }
}

class Point implements Comparable<Point>{
   int to, weight;
   
   Point(int to, int weight){
      this.to = to;
      this.weight = weight;
   }
   
   @Override
   public int compareTo(Point p) {
	   return this.weight - p.weight;
   }
}