package date0803.sw2001;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("HW/HW/src/date0803/sw2001/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		System.out.println(T);
		for (int t = 0; t < T; ++t) {	
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] map = new int[N + 1][N + 1];
			for (int i = 1; i < N + 1; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < N + 1; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
				System.out.println(Arrays.toString(map[i]));
			}

			System.out.println("=======================");
			
			int[][] dp = new int[N + 1][N + 1];

			for (int i = 1; i < N + 1; ++i) {
				for (int j = 1; j < N + 1; ++j) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + map[i][j];
				}
				System.out.println(Arrays.toString(dp[i]));
			}
			
			System.out.println("=============");

		}
	}
}
