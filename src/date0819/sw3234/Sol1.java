package date0819.sw3234;

import java.io.*;
import java.util.*;

public class Sol1 {
	static int answer;
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        
        for (int tc = 0; tc < T; tc++) {
        	st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] weights = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
            	weights[i] = Integer.parseInt(st.nextToken());
            }
            boolean[] visited = new boolean[N];
            answer = 0;
            check(0, 0, 0, weights, N, visited);
        	sb.append("#" + (tc + 1) + " " + answer + "\n");
        }
        System.out.println(sb);
	}
	public static void check(int idx, int leftWeight, int rightWeight, int[] weights, int N, boolean[] visited) {
		if (idx == N) { 
			answer++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				
				check(idx + 1, leftWeight + weights[i], rightWeight, weights, N, visited);
				
				// 오른쪽 무게 올리기  
				if (rightWeight + weights[i] <= leftWeight) check(idx + 1, leftWeight, rightWeight + weights[i], weights, N, visited);

				visited[i] = false;
			}
		}
	}
}