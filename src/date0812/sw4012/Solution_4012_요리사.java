package date0812.sw4012;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_4012_요리사 {

	static int N;
	static int[][] map;
	static Integer[] dish1, dish2, wholeDish;
	static int taste1, taste2;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		System.setIn(new FileInputStream("HW/HW/src/date0812/sw4012/sample_input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			
			//식재료를 N/2 씩 나누어 두개의 요리
			// A, B 맛 음식 맛 차이 최소화...
			
			//식재료 i, j 는 다 다르며 궁합이 다르다
			
			//식재료수 4<= N <= 16 이하 짝수

			map = new int[N][N];
			dish1 = new Integer[N/2];
			dish2 = new Integer[N/2];
			wholeDish = new Integer[N];
			for(int i=0; i<N; i++) {
				wholeDish[i] = i;
			}
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++ ) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			dfs(0,0);
			sb.append("#" + (t+1) + " " + min + "\n");
			
		}
		
		System.out.println(sb);
		
	}
	
	static void dfs(int idx, int depth) {
//		System.out.println(idx + " " + depth);
		if(depth == N/2) {
			taste1 = 0;
			taste2 = 0;
//			System.out.println(Arrays.toString(dish1));
			checkDish();
//			System.out.println(Arrays.toString(dish2));
			for(int i=0; i<N/2; i++) {
				for(int j=0; j<N/2; j++) {
					taste1 += map[dish1[i]][dish1[j]];
					taste2 += map[dish2[i]][dish2[j]];
				}
			}
			
			if(Math.abs(taste2-taste1) < min) {
				min = Math.abs(taste2-taste1);
			}
			return;
		}
		
		for(int i=idx; i<N; i++) {
			dish1[depth] = i;
			dfs(i+1, depth+1);
		}
	}
	
	static void checkDish() {
		int k =0;
		for(int i=0; i<N; i++) {
			if(!Arrays.asList(dish1).contains(i)) {
				dish2[k++] = i;
			}
		}
	}
}
