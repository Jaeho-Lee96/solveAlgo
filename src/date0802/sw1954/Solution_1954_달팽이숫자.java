package date0802.sw1954;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1954_달팽이숫자 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; ++t) {
			int N = Integer.parseInt(br.readLine());

			int[][] snail = new int[N][N];
			int sum = 0;
			int x = 0;
			int y = 0;
			int[] dx = { 0, 1, 0, -1 };
			int[] dy = { 1, 0, -1, 0 };
			int flag =0;
			
			for(int i=0; i<N*N; ++i) {
				snail[x][y] = i+1;
				
				int nx = x + dx[flag];
				int ny = y + dy[flag];
				
				if(nx <0 || nx >= N || ny <0 || ny >= N || snail[nx][ny] != 0) {
					flag = (flag+1) % 4;
				}
				
				x = x + dx[flag];
				y = y + dy[flag];
				
			}
			
			sb.append("#" + (t+1) + "\n");
			for(int i=0; i<N; ++i) {
				for(int j=0; j<N; ++j) {
					sb.append(snail[i][j] + " ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

}
