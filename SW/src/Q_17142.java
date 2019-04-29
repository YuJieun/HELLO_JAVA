import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_17142 {
   static int [][] map;
   static boolean[][] visited;
   static int n,m;
   static int[] di = {-1,1,0,0};
   static int[] dj = {0,0,-1,1};
   static int max = Integer.MAX_VALUE;
   static int cnt=0;
   public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      
      st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      
      map = new int[n][n];
      visited = new boolean[n][n];
      for(int i=0;i<n;i++) {
         st = new StringTokenizer(br.readLine());
         for(int j=0;j<n;j++) {
            int val = Integer.parseInt(st.nextToken());
            map[i][j] = val;
            /* 벽이면 -1 */
            if(val == 1) {
               map[i][j] = -1;
            }
            if(val == 0)
               cnt+=1;
         }
      }
      dfs(-1,0);
      
      if(max == Integer.MAX_VALUE)
         System.out.println(-1);
      else
         System.out.println(max);
            
   }
   public static void dfs(int i, int depth) {
      if(depth==m) {
         spread();
      }else {
         for(int k=i+1; k<n*n; k++){
            if(map[k/n][k%n]==2) {
               visited[k/n][k%n] = true;
               dfs(k,depth+1);
               visited[k/n][k%n] = false;
            }
         }
      }
   }
   
   public static void spread(){
	  int[][] clone = new int[n][n];
	  boolean[][] visited2 = new boolean[n][n];
      Queue<Po> q = new LinkedList<Po>();
      for(int i=0;i<n;i++) {
         for(int j=0;j<n;j++) {
        	clone[i][j] = map[i][j];
        	visited2[i][j] = visited[i][j]; 
            if(clone[i][j]==2 && visited2[i][j]==true) {
            	clone[i][j] = 0;
            	q.add(new Po(i,j));
            }
         }
      }
      
      int time=0;
      int check_zero=0;
      while(!q.isEmpty()) {
         Po tmp = q.poll();
         for(int k=0;k<4;k++) {
            int tmp_i = tmp.i+di[k];
            int tmp_j = tmp.j+dj[k];
            
            if(tmp_i>=0&& tmp_i<n && tmp_j>=0 && tmp_j<n) {
               if(visited2[tmp_i][tmp_j]==false && clone[tmp_i][tmp_j]!=-1) {
            	   int val = clone[tmp_i][tmp_j];
            	   clone[tmp_i][tmp_j]=clone[tmp.i][tmp.j]+1;
            	   visited2[tmp_i][tmp_j] = true;
                   if(val==0) {
                      check_zero+=1;
                      time = clone[tmp_i][tmp_j];
                   }
                   q.add(new Po(tmp_i,tmp_j));
               }
            }
         }
      }
      if(check_zero==cnt && max>time)
         max = time;
   }
}

class Po{
   int i;
   int j;
   
   Po(int i,int j) {
      this.i = i;
      this.j=j;
   }
}