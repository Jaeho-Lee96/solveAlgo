package date0819.sw3234;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3234_양팔저울 {
	
	static int N;
	static Integer[] weights;
	static boolean[] visited;
	static Integer[] left;
	static Integer[] right;	
		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			
			N = Integer.parseInt(br.readLine());
			
			
			weights = new Integer[N];
			visited = new boolean[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			System.out.println(N + " ");
			
			for(int i=0; i<N; i++) {
				weights[i] = Integer.parseInt(st.nextToken());
			}
			
			System.out.println(Arrays.toString(weights));
			
			for(int i=1; i<N; i++) {
				left = new Integer[i];
				right = new Integer[N-i];
//				dfs(0, i);
			}
		}
	}
	
	static void dfs(int depth, int targetDepth) {
		if(targetDepth == depth) {
			checkRight();
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			left[depth] = weights[i];
			visited[i] = true;
			dfs(depth+1, targetDepth);
			visited[i] = false;
		}
	}
	
	static void checkRight() {
		int idxR = 0;
		for(int i=0; i<N; i++) {
			if(!Arrays.asList(left).contains(weights[i])) {
				right[idxR++] = weights[i];
			}
		}
	}
}
