package date0812.bj15686;

import java.io.*;
import java.util.*;

public class Main_15686_치킨배달2 {
	static int N, M, MIN;
	static int[][] graph;
	static ArrayList<Integer[]> house, chicken;
	static int[] arr;
	static boolean[] visit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // N * N 크기의 도시
		M = Integer.parseInt(st.nextToken()); // M개의 치킨집 생존
		MIN = Integer.MAX_VALUE;
		
		house = new ArrayList<>(); // 집의 위치 
		chicken = new ArrayList<>(); // 치킨집의 위치
		
		graph = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if (graph[i][j] == 1) house.add(new Integer[] {i, j});
				else if (graph[i][j] == 2) chicken.add(new Integer[] {i, j});
			}
		} // 주어진 도시 정보
		arr = new int[M];
		visit = new boolean [chicken.size()];

		make_candi(0);
		System.out.println(MIN);
	}
	
	
	static void make_candi(int depth) {
		if (depth == M) {
			int SUM = 0; // 치킨집까지의 거리 합
			
			for (int i = 0; i < house.size(); i++) {
				Integer[] now_house = house.get(i);
				int temp = Integer.MAX_VALUE;
				for (int j = 0; j < M; j++) {
					Integer[] now_chicken = chicken.get(arr[j]);
					temp = Math.min(temp, Math.abs(now_house[0] - now_chicken[0]) + Math.abs(now_house[1] - now_chicken[1]));
				}
				SUM += temp;
			}
			
			MIN = Math.min(MIN, SUM);
			return;
		}
		
		for (int i = 0; i < chicken.size(); i++) {
			if (!visit[i]) {
				visit[i] = true;
				arr[depth] = i;
				make_candi(depth + 1);
				for (int j = i + 1; j < chicken.size(); j++) {
					visit[j] = false;					
				}
			}
		}
	}
}