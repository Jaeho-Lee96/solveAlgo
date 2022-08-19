package date0819.bj13460;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int N, M;

	static Character[][] board;

	static int[] red = new int[2];
	static int[] blue = new int[2];
	static int[] goal = new int[2];
	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0}; // 좌 우 상 하

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new Character[N][M];

		for (int i = 0; i < N; i++) {
			String temp = br.readLine();

			for (int j = 0; j < M; j++) {
				board[i][j] = temp.charAt(j);
				if (board[i][j] == 'R') {
					red[0] = i;
					red[1] = j;
				} else if (board[i][j] == 'B') {
					blue[0] = i;
					blue[0] = j;
				} else if (board[i][j] == 'O') {
					goal[0] = i;
					goal[1] = j;
				}
			}
				
		}
	}
}
