package date0803.bj11659;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MainDp {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("HW/HW/src/date0803/bj11659/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N];
		int[] dp  = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i) {
			nums[i]= Integer.parseInt(st.nextToken());
		}
		
		dp[0] = 0;
		for(int i=1; i < nums.length+1; ++i) {
			dp[i] = dp[i-1] + nums[i-1];
		}
		
		System.out.println(Arrays.toString(dp));
		
		for(int t=0; t<M; ++t) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			System.out.println(dp[end] - dp[start-1]);
		}
		
		
	}
}
