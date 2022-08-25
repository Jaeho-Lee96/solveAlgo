package date0825.bj4485;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4485_녹색옷입은애가젤다지 {

    static int N;
    static int[][] graph;
    static int[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = 0;
        while (true) {
            N = Integer.parseInt(br.readLine());

            if(N == 0) {
                break;
            }

            graph = new int[N][N];
            visited = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                    visited[i][j] = Integer.MAX_VALUE;
                }
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
            visited[0][0] = graph[0][0];
            pq.offer(new int[]{0, 0, graph[0][0]});

            while (!pq.isEmpty()) {

                int[] p = pq.poll();

                int x = p[0];
                int y = p[1];
                int weight = p[2];

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                        if ((visited[nx][ny] > visited[x][y] + graph[nx][ny])) {
                            visited[nx][ny] = visited[x][y] + graph[nx][ny];
                            pq.offer(new int[]{nx, ny, visited[nx][ny]});
                        }
                    }
                }
            }
            tc++;

            System.out.println("Problem " + tc + ": " + visited[N - 1][N - 1]);

        }


    }


}
