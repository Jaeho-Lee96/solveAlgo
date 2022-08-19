package date0819.bj17135;

import java.io.*;
import java.util.*;

public class Main_17135_캐슬디펜스 {
	static int N, M, D, MAX;
	static int[][] graph, new_graph;
	static int[] archers;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		graph = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		archers = new int[3];
		MAX = -1;

		placeArcher(0, 0);
		System.out.println(MAX);
	}

	public static void placeArcher(int depth, int cnt) {
		if (depth == 3) { // 세명의 궁수를 골랐으면

			int count = 0; // 몇명을 죽였는지 카운트 해주는 변수

			new_graph = new int[N][M]; // 캐슬 디펜스 시뮬레이션 돌리기 위해 배열 복사
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					new_graph[i][j] = graph[i][j];
				}
			} // 그래프 복사

			for (int i = 0; i < N; i++) { // 적이 전진 (N번 공격할 수 있음)
				if (i != 0)
					new_graph = move(new_graph); // 적 앞으로 이동 -> 적은 (N - 1)회 이동함.

				HashSet<int[]> enemyLocSet = new HashSet<>();
				for (int idx = 0; idx < 3; idx++) {
					int archerX = N;
					int archerY = archers[idx]; // 현재 궁수의 위치
					int[] enemy_pos = find(archerX, archerY);
					enemyLocSet.add(enemy_pos); // 공격할 적의 위치
				}

				// 공격
				for (int[] curTarget : enemyLocSet) {
					if (curTarget[0] == -1 && curTarget[1] == -1)
						continue;
					if (new_graph[curTarget[0]][curTarget[1]] == 1) { // 적이 있는 자리면 죽이면서 카운팅해주고, 죽음 처리
						count++;
						new_graph[curTarget[0]][curTarget[1]] = 0;
					}
				}
			}

			MAX = Integer.max(MAX, count); // 최대값 비교
			return;
		}

		for (int i = 0; i < M; i++) {
			archers[depth] = i;
			placeArcher(depth + 1, i + 1);
		}
	}

	public static int[][] move(int[][] board) {
		for (int j = 0; j < M; j++) {
			for (int i = N - 1; i >= 0; i--) {
				if (i == 0)
					board[i][j] = 0; // 마지막이면 0으로 처리
				else {
					board[i][j] = board[i - 1][j]; // 위에꺼 땡겨옴
				}
			}
		}
		return board;

	}

	public static int[] find(int x, int y) {
		int MIN = Integer.MAX_VALUE;
		int targetX = -1;
		int targetY = -1;
		for (int j = 0; j < M; j++) {
			for (int i = N - 1; i >= 0; i--) {
				if (new_graph[i][j] == 0)
					continue; // 적이 있는 장소만 탐색

				int temp = Math.abs(i - x) + Math.abs(j - y); // 절대거리 구하기
				if (temp > D)
					continue; // 사정거리 안일때만 비교
				if (MIN > temp) {
					MIN = temp;
					targetX = i;
					targetY = j;
				}
			}
		}
		int[] target = new int[] { targetX, targetY };
		return target;
	}

}