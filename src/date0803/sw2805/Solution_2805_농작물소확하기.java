package date0803.sw2805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_2805_농작물소확하기 {

	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("HW/src/date0803/sw2805/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; ++t) {
			N = Integer.parseInt(br.readLine());
			int mid = N / 2;

			int[][] field = new int[N][N];

			for (int i = 0; i < N; ++i) {
				String s = br.readLine();
				for (int j = 0; j < N; ++j) {
					field[i][j] = (int) s.charAt(j) - '0';
				}
//				System.out.println(Arrays.toString(field[i]));
			}
			int answer = 0;
			int width = 0;
			int i = 0;
			boolean flag = false;
			while (i < N) {
				answer += field[i][mid];
				for(int j=1; j<width+1;++j) {
//					System.out.println("i: " + i + " j: " + j);
					answer += field[i][mid+j];
					answer +=field[i][mid-j];
				}
				
				if(width == mid) {
					flag = true;
				}
				
				if(!flag) {
					width++;
				} else  {
					width--;
				}
				++i;
			}

			System.out.println("#" + (t + 1) + " " + answer);
		}

	}
}
