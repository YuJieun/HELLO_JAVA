import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Q_1504 {
    static ArrayList<Point3>[] arrayLists;
    static int N;
    static int INF = 100000000;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] NE = bufferedReader.readLine().split(" ");
        N = Integer.parseInt(NE[0]);
        int E = Integer.parseInt(NE[1]);

        arrayLists = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            int point1 = Integer.parseInt(input[0]);
            int point2 = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);
            arrayLists[point1].add(new Point3(point2, cost));
            arrayLists[point2].add(new Point3(point1, cost));
        }
        String[] must = bufferedReader.readLine().split(" ");
        int must1 = Integer.parseInt(must[0]);
        int must2 = Integer.parseInt(must[1]);

        int[] distance1 = new int[N + 1]; //1에서 must1,must2
        int[] distance2 = new int[N + 1]; //must1에서 must2
        int[] distance3 = new int[N + 1]; //n에서 must1,must2
        distance1 = dijkstra(1);
        distance2 = dijkstra(must1);
        distance3 = dijkstra(N);

        int min = Math.min(distance1[must1] + distance2[must2] + distance3[must2], distance1[must2] + distance2[must2] + distance3[must1]);
        System.out.println(min >= INF ? -1 : min);
    }

    public static int[] dijkstra(int start) {
        int[] distance = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(distance, INF);
        distance[start] = 0;

        PriorityQueue<Point3> queue = new PriorityQueue<>();
        queue.offer(new Point3(start, 0));
        while (!queue.isEmpty()) {
            Point3 point = queue.poll();
            if (visited[point.dest] == true) {
                continue;
            }
            visited[point.dest] = true;

            for (Point3 next : arrayLists[point.dest]) {
                if (visited[next.dest] == false) {
                    distance[next.dest] = Math.min(distance[next.dest], distance[point.dest] + next.cost);
                    queue.offer(new Point3(next.dest, distance[next.dest]));
                }
            }
        }
        return distance;
    }
}

class Point3 implements Comparable<Point3> {
    int dest;
    int cost;

    Point3(int dest, int cost) {
        this.dest = dest;
        this.cost = cost;
    }

    @Override
    public int compareTo(Point3 o) {
        return this.cost > o.cost ? 1 : -1;
    }
}