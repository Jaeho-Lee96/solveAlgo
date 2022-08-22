package date0822.sw1238;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
    static final int T = 10;
    static final int MAX = 101;
    static int N, S; // S는 시작점
    static int[][] graph;

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("src/date0822/sw1238/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());

            graph = new int[MAX][MAX];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N/2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from][to] = 1;
            }
            System.out.println("#" + t +  " " + bfs(S));
        }

    }

    static int bfs(int start) {
        int[] visited = new int[101];
        int maxCnt = 0, ans = 0;
        Deque<Integer> dq = new LinkedList<>();
        dq.offer(S);
        visited[S] = 1;
        while(!dq.isEmpty()) {
            int cur = dq.poll();

            for(int i=1; i<101; i++) {
                if(graph[cur][i] != 1 || visited[i] != 0) continue;
                visited[i] = visited[cur]+1;
                dq.offer(i);
            }
            maxCnt = visited[cur];
        }

        for(int i=1; i<101; i++) {
            if(maxCnt != visited[i]) continue;
            ans = Math.max(ans, i);
        }
        return ans;
    }
}
