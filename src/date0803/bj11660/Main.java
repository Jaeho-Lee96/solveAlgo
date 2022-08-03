package date0803.bj11660;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("HW/HW/src/date0803/bj11660/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] list = new int[N + 1][N + 1];
		int[][] dp = new int[N + 1][N + 1];

		for (int i = 1; i < N + 1; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; ++j) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(list[i]));
		}

//		for(int i=0; i<N; ++i) {
//			dp[0][i] = list[0][i];
//			dp[i][0] = list[i][0];
//		}

		for (int i = 1; i < N + 1; ++i) {
			for (int j = 1; j < N + 1; ++j) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + list[i][j];
			}
		}


		for (int t = 0; t < M; ++t) {
			int[] start = new int[2];
			int[] end = new int[2];
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int answer = dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1];
			System.out.println(answer);
		}
	}
}
