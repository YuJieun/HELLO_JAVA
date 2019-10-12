package programmers_graph;

import java.util.*;

class Q_1 {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList[] arr = new ArrayList[n+1];
        int[] len = new int[n+1];
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        for(int i=0; i<edge.length; i++){
            arr[edge[i][0]].add(edge[i][1]);
            arr[edge[i][1]].add(edge[i][0]);
        }
        
        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(1,0));
        int max = 0;
        while(!q.isEmpty()){
            Node tmp = q.poll();
            for(int i=0; i<arr[tmp.num].size();i++){
                int tmp2 = (int)arr[tmp.num].get(i);
                if(visited[tmp2]==false){
                    visited[tmp2]= true;
                    q.offer(new Node(tmp2,tmp.cnt+1));
                    len[tmp2] = tmp.cnt+1;
                    max = tmp.cnt+1;
                }
            }
        }
        
        for(int i=1; i<len.length; i++){
            if(len[i]==max)
                answer++;
            System.out.println(len[i]);
        }
        return answer;
    }
}

class Node{
    int num;
    int cnt;
    
    public Node(int n, int c)
    {
        this.num=n;
        this.cnt=c;
    }
}