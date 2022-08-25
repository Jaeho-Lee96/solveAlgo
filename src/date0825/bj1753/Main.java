package date0825.bj1753;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int V, E;
    static int start;
    static int[] dist;
    static boolean[] visited;
    static ArrayList<Integer[]>[] vertex;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine())-1;
        dist = new int[V];
        visited = new boolean[V];
        vertex = new ArrayList[V];
        for(int i=0; i<V; i++) {
            dist[i] = Integer.MAX_VALUE;
            vertex[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());

            vertex[Integer.parseInt(st.nextToken())-1].
                    add(new Integer[] { Integer.parseInt(st.nextToken())-1,
                            Integer.parseInt(st.nextToken())});
        }

        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1] );
        pq.add(new Integer[] {start, 0});
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Integer[] curNode = pq.poll();
            int to = curNode[0];

            if(visited[to]) continue;
            visited[to] = true;

            for(Integer[] node : vertex[to]) {
                if(dist[node[0]] > dist[to] + node[1]) {
                    dist[node[0]] = dist[to] + node[1];
                    pq.add(new Integer[] {node[0], dist[node[0]]});
                }
            }
        }

        for(int i=0; i< V; i++) {
            if(dist[i] == Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(dist[i] + "\n");
        }
        System.out.println(sb);





    }
}
