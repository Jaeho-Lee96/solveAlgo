package date0822.sw1238.date0823.bj7576;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_7576_토마토 {
	static int N, M, max = 0;
	static int[][] graph;
	static int[][] visited;

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static LinkedList<Integer[]> rotten = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		graph = new int[N][M];
		visited = new int[N][M];

		// 하루 지날 때 마다 익은 토마토 근처는 익게 된다. // 압 뒤 좌 우
		// 모두 익지 않는 상태는 -1

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());

				if (graph[i][j] == 1) {
					rotten.add(new Integer[] { i, j });
				}				
			}		
		}
		
		Deque<Integer[]> dq = new LinkedList<Integer[]>();

		for (Integer[] temp : rotten) {
			dq.add(new Integer[] { temp[0], temp[1] });
			visited[temp[0]][temp[1]] += 1;
		}
		
		while (!dq.isEmpty()) {
			Integer[] cur = dq.poll();

			int x = cur[0];
			int y = cur[1];

			for (int i = 0; i < dx.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					if (graph[nx][ny] == 0) {
						visited[nx][ny] += visited[x][y] + 1;
						graph[nx][ny] = 1;
						if (visited[nx][ny]-1 > max) {
							max = visited[nx][ny]-1;
						}
						dq.add(new Integer[] {nx,ny});
					}
				}
			}
		}
		
		
		boolean flag = false;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(graph[i][j] == 0) {
					flag = true;
					break;
				}
			}
			if(flag == true) break;
		}
		
		if(flag) System.out.println(-1);
//		else if(max == 0) System.out.println(0);
		else System.out.println(max);
	}

}
