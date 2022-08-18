package date0817.sw5644;

import java.io.*;
import java.util.*;

public class Solution1 {
	static int M, A, ax, ay, bx, by, SUM;
	static int[] moveA, moveB;
	static int[] dx = { 0, 0, 1, 0, -1 };
	static int[] dy = { 0, -1, 0, 1, 0 };
	static int[][] BC;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());

		for (int tc = 0; tc < T; tc++) {

			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 사용자의 이동 시간
			A = Integer.parseInt(st.nextToken()); // BC의 개수

			moveA = new int[M];
			moveB = new int[M];
			StringTokenizer stA = new StringTokenizer(br.readLine());
			StringTokenizer stB = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				moveA[i] = Integer.parseInt(stA.nextToken());
				moveB[i] = Integer.parseInt(stB.nextToken());
			}

			BC = new int[A][4];
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				BC[i][0] = Integer.parseInt(st.nextToken());
				BC[i][1] = Integer.parseInt(st.nextToken()); // 좌표
				BC[i][2] = Integer.parseInt(st.nextToken()); // 충전 범위
				BC[i][3] = Integer.parseInt(st.nextToken()); // 처리 량
			}

			ax = ay = 1; // A의 시작 위치
			bx = by = 10; // B의 시작 위치
			SUM = getCharge(ax, ay, bx, by); // 초기 충전량

			for (int idx = 0; idx < M; idx++) {
				ax = ax + dx[moveA[idx]];
				ay = ay + dy[moveA[idx]];
				bx = bx + dx[moveB[idx]];
				by = by + dy[moveB[idx]];

				SUM += getCharge(ax, ay, bx, by);
			}
			sb.append("#" + (tc + 1) + " " + SUM + "\n");
		}
		System.out.println(sb);
	}

	public static int getCharge(int ax, int ay, int bx, int by) {
		int[][] charge = new int[A][2];

		for (int i = 0; i < A; i++) {
			int dist = Math.abs(ax - BC[i][0]) + Math.abs(ay - BC[i][1]);
			if (dist <= BC[i][2]) {
				charge[i][0] = BC[i][3];
			}
		}

		for (int i = 0; i < A; i++) {
			int dist = Math.abs(bx - BC[i][0]) + Math.abs(by - BC[i][1]);
			if (dist <= BC[i][2]) {
				charge[i][1] = BC[i][3];
			}
		}

		int MAX = -1;
		for (int i = 0; i < A; i++) {
			for (int j = 0; j < A; j++) {
				int temp = charge[i][0] + charge[j][1];

				if (i == j && charge[i][0] == charge[j][1])
					temp = temp / 2;
				MAX = Math.max(MAX, temp);
			}
		}
		return MAX;
	}
}
