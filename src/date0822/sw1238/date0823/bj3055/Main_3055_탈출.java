package date0822.sw1238.date0823.bj3055;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_3055_탈출{
	static int R, C;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static char[][] graph;
	static int[][] floodMap, spikeMap;
	static int[] beaver = new int[2], spike = new int[2];
	static List<int[]> flood = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		Deque<int[]> floodQ = new ArrayDeque<>();
		Deque<int[]> spikeQ = new ArrayDeque<>();

		graph = new char[R][C];
		floodMap = new int[R][C];
		spikeMap = new int[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				graph[i][j] = s.charAt(j);

				if (graph[i][j] == 'S') {
					spike[0] = i;
					spike[1] = j;
					spikeQ.add(spike);
					spikeMap[i][j] = 1;

				} else if (graph[i][j] == 'D') {
					beaver[0] = i;
					beaver[1] = j;
				} else if (graph[i][j] == '*') {
					floodQ.add(new int[] { i, j });
					floodMap[i][j] = 1;
				}
			}
		}
		
		while (!floodQ.isEmpty()) {
			int[] curFlood = floodQ.poll();
			int fx = curFlood[0];
			int fy = curFlood[1];
			for (int i = 0; i < 4; i++) {
				int nfx = fx + dx[i];
				int nfy = fy + dy[i];

				if (checkBounds(nfx, nfy) && graph[nfx][nfy] != 'X' && graph[nfx][nfy] != 'D') {
					if (floodMap[nfx][nfy] == 0) {
						floodMap[nfx][nfy] = floodMap[fx][fy] + 1;
						floodQ.add(new int[] { nfx, nfy });
					}
				}
			}
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(floodMap[i][j] == 0) {
					floodMap[i][j] = 300;
				}
			}
		}
	
		floodMap[beaver[0]][beaver[1]] = 999;

		boolean flag = false;
		while (!spikeQ.isEmpty()) {
			int[] curSpike = spikeQ.poll();
			
		
			
			int x = curSpike[0];
			int y = curSpike[1];
			
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				
				if(checkBounds(nx, ny) && graph[nx][ny] != 'X' && spikeMap[nx][ny] == 0) {
					if(floodMap[nx][ny] > spikeMap[x][y]+1) {
						spikeMap[nx][ny] = spikeMap[x][y] + 1;
						spikeQ.add(new int[] {nx, ny});

						if(floodMap[nx][ny] == 999) {
							System.out.println(spikeMap[nx][ny]-1);
							flag = true;
							break;
						}
					}
				}
			}
			
			if(flag) {
				break;
			}
			
		}
		
		
		if(!flag) {
			System.out.println("KAKTUS");
		}
				
		// 고슴도치가 비버 굴로 갈려고
		// 빈곳 . 물 *, 돌 X, 비버 굴 D, 고믓도치 S
		// 물은 매칸 확장 된다. 돌 통과 X 물 비버 소굴 X

		// 물이 찰 예정칸 이동 X

		// 물 먼저 이동

	}

	static boolean checkBounds(int x, int y) {
		if (0 <= x && x < R && 0 <= y && y < C) {
			return true;
		} else {
			return false;
		}

	}

}
