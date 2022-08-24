package date0823.bj16236;

import java.io.*;
import java.util.*;

public class Main_16236_아기상어 {

	static int[][] graph;
	static int[][] visited;
	static ArrayList<Integer[]> fishes = new ArrayList<>();
	static int N, size; // N<=20
	static int[] dx = { -1, 0, 1, 0 }; // 상 하 좌 우
	static int[] dy = { 0, -1, 0, 1 };
	static int[] shark = new int[2];
	static int eatCnt = 0;
	static int timer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		graph = new int[N][N];
		visited = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if (graph[i][j] == 9) {
					shark[0] = i;
					shark[1] = j;
					graph[i][j] = 0;
				} else if (graph[i][j] != 0) {
					fishes.add(new Integer[] { i, j });
				}
			}
		}

		// 처음 아기상어 크기 2
		size = 2; // 크기가 크면 못지나감.

		while (true) {
			if (shark[0] == -1) {
				break;
			}
			bfsEat(shark[0], shark[1]);
		}
		System.out.println(timer);

	}

	static List<Integer[]> edibleFishes() {
		List<Integer[]> edible = new LinkedList<Integer[]>();
		for (Integer[] fish : fishes) {
			if (graph[fish[0]][fish[1]] < size) {
				edible.add(fish);
			}
		}
		return edible;
	}

	static void increaseSize() {
		if (eatCnt == size) {
			size++;
			eatCnt = 0;
		}
	}

	static void bfsEat(int x, int y) {
		int[][] tempVisited = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tempVisited[i][j] = visited[i][j];
			}
		}

		Deque<Integer[]> dq = new LinkedList<Integer[]>();
		dq.add(new Integer[] { x, y });
		tempVisited[x][y] = 1;
		int minDist = Integer.MAX_VALUE;
		int[] minLoc = new int[2];
		minLoc[0] = -1;
		minLoc[1] = -1;

		while (!dq.isEmpty()) {
			Integer[] temp = dq.poll();
			x = temp[0];
			y = temp[1];
//			System.out.println(dq);
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (0 <= nx && nx < N && 0 <= ny && ny < N && tempVisited[nx][ny] == 0) {
					if (graph[nx][ny] <= size) {
						dq.add(new Integer[] { nx, ny });
						tempVisited[nx][ny] = tempVisited[x][y] + 1;
						if (graph[nx][ny] != 0 && graph[nx][ny] < size) {
							if (tempVisited[nx][ny] < minDist) {
								minDist = tempVisited[nx][ny];
								minLoc[0] = nx;
								minLoc[1] = ny;
							} else if (tempVisited[nx][ny] == minDist) {
								if (nx < minLoc[0]) {
									minLoc[0] = nx;
									minLoc[1] = ny;
								} else if (nx == minLoc[0]) {
									if (ny < minLoc[1]) {
										minLoc[1] = ny;
									}
								}

							}
						}
					}
				}
			}
		}

		shark[0] = minLoc[0];
		shark[1] = minLoc[1];

		if (minLoc[0] != -1) {
//			System.out.println(minLoc[0] + " " + minLoc[1]);
//			System.out.println(minDist - 1);
			graph[minLoc[0]][minLoc[1]] = 0;
			eatCnt++;
			increaseSize();
			timer += minDist - 1;
		}

	}

}
