package date0802.sw1210;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sol3 {
	static final int T = 10;
	static final int N = 100;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("HW/src/date0802/sw1210/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 0; t < T; ++t) {
			int[][] map = new int[N][N];
			boolean[][] visited = new boolean[N][N];
			br.readLine();
			int start = -1;
			for (int i = 0; i < N ; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N ; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 2) {
						start = j;
//						System.out.println(j);
					}
				}	
			}

			int x = 99;
			int y = start;
			
			while(true) {
				if(x == 0) {
					System.out.println("#" + (t+1) + " " + y);
					break;
				}
				int[] dx = {0, 0, -1};
				int[] dy = {-1, 1, 0};
				
				for(int i=0; i< 3; ++i) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					if(0<=nx && nx<N && 0<=ny && ny<N && map[nx][ny] == 1 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						x = nx;
						y = ny;
					} 
				}
			}
		}
	} // main



}
