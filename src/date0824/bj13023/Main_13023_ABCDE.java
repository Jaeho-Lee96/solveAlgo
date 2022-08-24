package date0824.bj13023;

import java.io.*;
import java.util.*;

public class Main_13023_ABCDE {

	static int N, M, answer = 0; // N 캠프 인원 M 친구 관계의 수
	static int[][] graph;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new int[N][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			graph[from][to] = 1;
			graph[to][from] = 1;

		}

		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			dfs(i, 0);
		}

		System.out.println(answer);

	}

	static void dfs(int x, int depth) {
		if (depth == 4) {
			answer = 1;
			return;
		}
		visited[x] = true;
		for (int j = 0; j < N; j++) {
			if (graph[x][j] == 1 && !visited[j]) {
				dfs(j, depth + 1);
			}
		}
		visited[x] = false;
	}

}
