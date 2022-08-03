package date0803.sw2805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("HW/HW/src/date0803/sw2805/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		System.out.println(T);
		for (int t = 0; t < T; ++t) {
			N = Integer.parseInt(br.readLine());

			int[][] field = new int[N][N];

			for (int i = 0; i < N; ++i) {
				String s = br.readLine();
				for (int j = 0; j < N; ++j) {
					field[i][j] = (int) s.charAt(j) - '0';
				}
//				System.out.println(Arrays.toString(field[i]));
			}
			int answer = 0;
			int[] dx = { 1, -1 };
			for (int i = 0; i < (N - 1) / 2; ++i) {
				answer += field[i][(N - 1) / 2];
				for (int j = 1; j <= i; ++j) {
					answer += field[i][(N - 1) / 2 + j];
					answer += field[i][(N - 1) / 2 - j];
				}
			}
			
			for(int i=0; i< N; ++i) {
				answer += field[(N-1)/2][i];
			}
			
			for (int i = (N-1)/2 +1; i<N; ++i) {
				answer += field[i][(N - 1) / 2];
				for(int j=i-(N-1)/2; j< N-i; ++j) {
					answer += field[i][j];
					answer += field[i][N-1-j];
				}				
			}
			
			System.out.println("#" + (t+1) + " " + answer);
		}

	}
}
