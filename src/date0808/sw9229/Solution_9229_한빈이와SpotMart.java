package date0808.sw9229;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_9229_한빈이와SpotMart {
	static int N;
	static int M;
	static int[] cookies;
	static int[] choiced = new int[2];
	static int max;
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("HW\\src\\date0808\\sw9229\\sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N =Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			max = -1;
			
			cookies = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				cookies[i] = Integer.parseInt(st.nextToken());
			}
						
			dfs(0,0);
			sb.append("#" + (t+1) + " " + max + "\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int cnt, int idx) {
		if(cnt == 2) {
			int sum = choiced[0] + choiced[1];
			if(sum > max && sum <= M) {
				max = sum;
//				System.out.println(choiced[0] + "  " + choiced[1]);
			}
			return;
		}
		
		for(int i=idx; i<cookies.length; ++i) {
			choiced[cnt] = cookies[i];
			dfs(cnt+1, i+1);
		}
		
	}
}
