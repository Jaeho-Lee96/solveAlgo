package date0805.bj15652;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] nums;
	static boolean[] visited;
	static int N;
	static int M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		nums = new int[M+1];
		visited = new boolean[N+1];
	}
	
	static void permu(int cnt, int start) {
		if(cnt == M) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		for(int i=start; i<=N; ++i) {
			nums[cnt] = i;
			permu(cnt+1, start+1);
		}
	}
}
