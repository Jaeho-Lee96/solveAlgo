package date0822.sw1238.date0823.bj7576;



import java.io.*;
import java.util.*;

public class Main_7576_토마토2 {
	static int N, M;
	static int[][] graph, days;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		days = new int[N][M];
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if (graph[i][j] == 1) {
					dq.add(new int[] {i, j});
					days[i][j] = 1;
				}
			}
		}
		
		
		while (!dq.isEmpty()) {
			int[] now = dq.poll();
			for (int d = 0; d < 4; d++) {
				int nx = now[0] + dx[d];
				int ny = now[1] + dy[d];
				
				if (0 <= nx && nx < N && 0 <= ny && ny < M && days[nx][ny] == 0 && graph[nx][ny] == 0) {
					days[nx][ny] = days[now[0]][now[1]] + 1;
					dq.add(new int[] {nx, ny});
				}
			}
		}
		
		int MAX = -1;
		out:
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] != -1 && days[i][j] == 0) {
					MAX = -1;
					break out;
				} else {
					MAX = Math.max(MAX, days[i][j] - 1);
				}
			}
		}
		System.out.println(MAX);
	}
}
// https://docs.google.com/presentation/d/1YMxugrIswE-VGMlf1uo1mahqrWQDQZQnlQzm-hWSbaM/edit#slide=id.g146bb18aaca_0_20