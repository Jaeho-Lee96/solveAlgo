package date0817.bj15683;

import java.io.*;
import java.util.*;

public class Main1 {
	static int[] dx = {-1, 0, 1, 0}; // 상, 우, 하, 좌
	static int[] dy = {0, 1, 0, -1};
	
	static int N, M, MIN;
	static int[][] graph;
	static ArrayList<int[] > camera_pos;	
	static int[][][] dir = {{}, {{0}, {1}, {2}, {3}}, {{0, 2},{1, 3}}, {{0, 1}, {1, 2}, {2, 3}, {3, 0}}, {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}}, {{0, 1, 2, 3}}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		camera_pos = new ArrayList<>(); 
		MIN = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if (0 < graph[i][j] && graph[i][j] <= 5) camera_pos.add(new int[]{graph[i][j], i, j});
			}
		}

		dfs(0);
		System.out.println(MIN);
	}
	
	
	public static void dfs(int depth) {
		if (depth == camera_pos.size()) {
			int temp = check();
			MIN = Math.min(MIN, temp);
			return;
		}

		int[][] temp_graph = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp_graph[i][j] = graph[i][j];
			}
		} // 배열 복사본 만들기
		
		int[] now = camera_pos.get(depth);
		int d = now[0]; int x = now[1]; int y = now[2];
			
		for (int[] idx : dir[d]) {
			for (int k = 0; k < idx.length; k++) {
				search(idx[k], x, y);		
			}
			dfs(depth + 1);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					graph[i][j] = temp_graph[i][j];
				}
			} // 배열 원위치
			
		}
	}
	
	public static void search(int d, int x, int y) {
		while (true) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (0 <= nx && nx < N && 0 <= ny && ny < M && graph[nx][ny] != 6) {
				graph[nx][ny] = '#';
				x = nx; y = ny;
			} else {
				break;
			}
		}
	}
	
	public static int check() {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] == 0) count++; // 사각지대면 카운트
			}
		}
		return count;
	}
	
}