package date0817.sw5644;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static int M, A, ax, ay, bx, by, sum;
	
	static int[] dx = {0, 0, 1, 0, -1};
	static int[] dy = {0, -1, 0, 1, 0};
	
	static int[] moveA;
	static int[] moveB;

	static int[][] BC;
	static final int size = 10;
	static PriorityQueue<Integer>[][] map;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("HW/HW/src/date0816/sw5644/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());

			StringTokenizer stA = new StringTokenizer(br.readLine());
			StringTokenizer stB = new StringTokenizer(br.readLine());
			moveA = new int[M];
			moveB = new int[M];
			for (int i = 0; i < M; i++) {
				moveA[i] = Integer.parseInt(stA.nextToken());
				moveB[i] = Integer.parseInt(stB.nextToken());
			}

			BC = new int[A][4]; // X, Y, C 충전 범위 , P 처리량
			// 동시에 2개 접근 불가능

			map = new PriorityQueue[size][size];

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					map[i][j] = new PriorityQueue<>(Collections.reverseOrder());
				}
			}

			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken())-1;
				int Y = Integer.parseInt(st.nextToken())-1;
				int C = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				
				placeBC(X, Y, C, P);
				
			}
			System.out.println(Arrays.deepToString(map));
			
			
			ax = ay = 0;
			bx = by = 9;
			
			for(int i=0; i<M; i++) {
				ax = ax + dx[moveA[i]];
				ax = ay + dy[moveA[i]];
				bx = bx + dx[moveB[i]];
				bx = by + dy[moveB[i]];
			}
			
		}
	}
	
	
	//static void 
	
	static void getSum(int ax, int ay, int bx, int by) {
		if(ax == bx && ay == by && map[ax][ay] != null) {
			int tempA = map[bx][by].poll();
			sum += tempA;
			return;
		}
		
		if(map[ax][ay] != null) {
			int tempA = map[ax][ay].poll();
			sum += tempA;
		}
		
	}
	

	static void placeBC(int x, int y, int c, Integer p) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if((Math.abs(x-i)) + Math.abs(y-j) <= c) {
					map[i][j].add(p);
				}
			}
		}
	}
}
