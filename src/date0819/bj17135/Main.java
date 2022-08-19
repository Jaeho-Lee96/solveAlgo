package date0819.bj17135;

import java.io.*;
import java.util.*;

public class Main {

	static int N, M, D, killCount=0;

	static Integer[][] board;

	static int[] archers = new int[3];
	static boolean[] visited;
	
	static List<Integer[]> enemy = new ArrayList<>();
	static List<Integer[]> enemyTemp = new ArrayList<>();

	static int dx = 1;
	
	static int max = -1;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("hw/HW/src/date0819/bj17135/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		System.out.println(1);

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		board = new Integer[N + 1][M];
		visited = new boolean[M];
		
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) {
					enemy.add(new Integer[] { i, j });
				}
			}
		}
		
		for(Integer[] e : enemy) {
			enemyTemp.add(e);
		}
		
//		for(Integer[] e : enemy) {
//			System.out.println(Arrays.toString(e));
//		}
		setArcher(0, 0);
		
		
		System.out.println(max);
	}

	static public class Enemy {
		int x, y;
	}

	static void setArcher(int depth, int idx) {
		if (depth == 3) {
			System.out.println(Arrays.toString(archers));
			
			for(Integer[] e : enemyTemp) {
				enemy.add(e);
			}
			playGame();
			return;
		}

		for (int i = idx; i < M; i++) {
			if (visited[i])
				continue;
			archers[depth] = i;
			visited[i] = true;
			setArcher(depth + 1, i + 1);
			visited[i] = false;
		}
	}

	static void playGame() {
		
		System.out.println("playGame");
		killCount = 0;
		
		while (!enemy.isEmpty()) {
			System.out.println("size: " + enemy.size());
			getDistAndKill();
			moveEnemy();
		}
		
		Math.max(killCount, max);
	}

	static void moveEnemy() {
		for (int i = 0; i < enemy.size(); i++) {

			enemy.get(i)[0] -= 1;

			if (enemy.get(i)[0] == N) {
				enemy.remove(i);
				--i;
				killCount++;
			}
		}
	}

	static void getDistAndKill() {
		int[] KilledEnemyDist = new int[3];

		KilledEnemyDist[0] = Integer.MAX_VALUE;

		HashSet<Integer> set = new HashSet<>();

		for (int i = 0; i < 3; i++) {
			KilledEnemyDist[i] = Integer.MAX_VALUE;
			for (int j = 0; j < enemy.size(); j++) {
				int dist = getDist(archers[i], N, enemy.get(j)[0], enemy.get(j)[1]);
				if (dist > D)
					continue;
				if (KilledEnemyDist[i] < dist) {
					KilledEnemyDist[i] = dist;
					set.add(j);
				}
			}
		}

		for (Integer i : set) {
			enemy.remove(i);
			
		}
	}

	static int getDist(int ax, int ay, int ex, int ey) {
		return Math.abs(ax - ex) + Math.abs(ay - ey);
	}
}
