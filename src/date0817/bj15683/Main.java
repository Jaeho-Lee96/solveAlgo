package date0817.bj15683;

import java.io.*;
import java.util.*;


public class Main {
	static int N, M, answer = Integer.MAX_VALUE;
	static int[][] graph;
	static int[][] tempGraph;
	
    static int[] dx = {0, 0, -1, 1}; // 상 하 좌 우
    static int[] dy = {-1, 1, 0, 0};
	
    
    static int[][][] rotations = {
    		{{0}}, 
    		{{0}, {1}, {2}, {3}}, 
    		{{0,1}, {2,3}}, 
    		{{0,3}, {3, 1}, {1, 2}, {2,0}},
    		//U,R    R, D    D  L    L U 
    		{{0, 2, 3}, {2, 3, 1}, {3, 1, 0}, {1, 0, 2}},
    		{{0,1,2,3}}
    		};
	
	static ArrayList<Integer[]> cameras = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("HW/HW/src/date0817/bj15683/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//CCTV 8개, 사무실 크기 N, M
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		tempGraph = new int[N][M];
		
		int spaceCnt = N*M;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				tempGraph[i][j]= graph[i][j];
				if(graph[i][j] != 0 && graph[i][j] != 6) {
					cameras.add(new Integer[] {i, j, graph[i][j]});
					spaceCnt--;
				} else if (graph[i][j] == 6) {
					spaceCnt--;
				}
			}
		}
		
		rotateFOV(0, spaceCnt, graph);
		
		System.out.println(answer);
		
	}
	
	static int checkFOV(int x, int y, int dir, int[][] map) {
		
		int cnt = 0;
		while(true) {
			x += dx[dir];
			y += dy[dir];

			if(x < 0 || x >=N || y<0 || y>=M || map[x][y] == 6) return cnt;		
			if((map[x][y] > 0 && map[x][y] < 6) || map[x][y] == -1) continue;
			map[x][y] = -1;
			cnt++;
		}
	}
	
	
	static void rotateFOV(int depth, int spaceCnt, int[][] map) {
		if(depth == cameras.size()) {
			answer =  Math.min(answer, spaceCnt);
			return;
		}
		
		int x = cameras.get(depth)[0];
		int y = cameras.get(depth)[0];
		int type = cameras.get(depth)[2];

		int[][] tempMap = new int[N][M];
		copy(tempMap, map);
		for(int i=0; i<rotations[type].length; i++) {
			int check = 0;
			for(int j=0; j < rotations[type][i].length; j++) {
				int dir = rotations[type][i][j];
				check += checkFOV(x, y, dir, tempMap);
			}
			rotateFOV(depth+1, spaceCnt- check, tempMap);
			copy(tempMap, map);
		}
	}
	
	static void copy(int[][] target, int[][] origin) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				target[i][j] = origin[i][j];
			}
		}
	}
	
}
