package date0803.bj20057;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int N;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("HW/HW/src/date0803/bj20057/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		System.out.println(N);
		map = new int[N][N];
		int center = (N-1)/2;
		for(int i=0;i<N;++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			System.out.println(Arrays.toString(map[i]));
		}
		int n =0;
		while(n<N*N) {
			//move dir L D R U
			int[] dx = {0, -1, 0, 1};
			int[] dy = {-1, 0, 1, 0};
		}
	}
	
	static void whirl(int x,int y, int dir) {
		int[] dx = {0, -1, 0, 1};
		int[] dy = {-1, 0, 1, 0};
		int nx = x + dx[dir];
		int ny = y + dy[dir];
	}
	
	static int sum() {
		int sum = 0;
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j) {
				sum += map[i][j];
			}
		}
		return sum;
	}
	
}
