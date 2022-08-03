package date0803.sw1873;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1873_상호의배틀필드 {

	static int[] loc = new int[3]; // x, y , [U, D, K, R, S]
	static int H;
	static int W;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("HW/HW/src/date0803/sw1873/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			char[][] map = new char[H][W];
			for (int i = 0; i < H; ++i) {
				String s = br.readLine();
				for (int j = 0; j < W; ++j) {
					map[i][j] = s.charAt(j);
					findTank(i, j, map);
				}
//				System.out.println(Arrays.toString(map[i]));
			}

			int cnt = Integer.parseInt(br.readLine());
			String action = br.readLine();

			for (int i = 0; i < action.length(); ++i) {
				char temp = action.charAt(i);
				
				if(temp == 'U') moveU(map);
				else if(temp == 'D') moveD(map);
				else if(temp == 'L') moveL(map);
				else if(temp == 'R') moveR(map);
				else if(temp == 'S') shoot(map);
				
//				for(int j=0; j<H; ++j) {
//					System.out.println(Arrays.toString(map[j]));
//				}
//				
//				System.out.println("===============================");
			}
			System.out.print("#" + (t+1) + " ");
			for(int i=0;i<H; ++i) {
				for(int j=0;j<W; ++j) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}

	}

	static void findTank(int x, int y, char[][] map) {
		if (map[x][y] == '^') {
			loc[0] = x;
			loc[1] = y;
			loc[2] = 0;
		} else if (map[x][y] == 'v') {
			loc[0] = x;
			loc[1] = y;
			loc[2] = 1;
		} else if (map[x][y] == '<') {
			loc[0] = x;
			loc[1] = y;
			loc[2] = 2;
		} else if (map[x][y] == '>') {
			loc[0] = x;
			loc[1] = y;
			loc[2] = 3;
		}
	}

	static void moveU(char[][] map) { // loc = x, y, dir
		if (loc[0]-1<H && loc[0]-1 >=0 && map[loc[0]-1][loc[1]] == '.') {
			loc[2] = 0;
			map[loc[0]][loc[1]] = '.';
			loc[0] -= 1;
			map[loc[0]][loc[1]] = '^';
		} else {
			loc[2] = 0;
			map[loc[0]][loc[1]] = '^';
		}
	}

	static void moveD(char[][] map) {
		if (loc[0] + 1 >= 0 && loc[0]+1<H && map[loc[0] + 1][loc[1]] == '.') {
			loc[2] = 1;
			map[loc[0]][loc[1]] = '.';
			loc[0] += 1;
			map[loc[0]][loc[1]] = 'v';
		} else {
			loc[2] = 1;
			map[loc[0]][loc[1]] = 'v';
		}
	}

	static void moveL(char[][] map) {
		if (0 <= loc[1]-1&& loc[1]-1 < W && map[loc[0]][loc[1] - 1] == '.') {
			loc[2] = 2;
			map[loc[0]][loc[1]] = '.';

			loc[1] -= 1;
			map[loc[0]][loc[1]] = '<';
		} else {
			loc[2] = 2;
			map[loc[0]][loc[1]] = '<';
		}
	}

	static void moveR(char[][] map) {
		if (loc[1] + 1 < W && loc[1]+1 >=0 && map[loc[0]][loc[1] + 1] == '.') {
			loc[2] = 3;
			map[loc[0]][loc[1]] = '.';

			loc[1] += 1;
			map[loc[0]][loc[1]] = '>';
		} else {
			loc[2] = 3;
			map[loc[0]][loc[1]] = '>';
		}
	}

	static void shoot(char[][] map) {
		if (loc[2] == 1) { // 위로 쏠 때
			for (int i = 1; i + loc[0] < H; ++i) {
				if (checkSteel(loc[0] + i, loc[1], map)) {
					break;
				}
				if (checkBrick(loc[0] + i, loc[1], map)) {
					map[loc[0] + i][loc[1]] = '.';
					break;
				}
			}
		}

		else if (loc[2] == 0) { // 위로 쏠 때
			for (int i = 1; 0 <= loc[0] - i; ++i) {
				if (checkSteel(loc[0] - i, loc[1], map)) {
					break;
				}
				if (checkBrick(loc[0] - i, loc[1], map)) {
					map[loc[0] - i][loc[1]] = '.';
					break;
				}
			}
		}
		
		else if (loc[2] == 2) { // 좌로 쏠 때
			for (int i = 1; loc[1]-i >=0; ++i) {
				if (checkSteel(loc[0], loc[1]-i, map)) {
					break;
				}
				if (checkBrick(loc[0], loc[1]-i, map)) {
					map[loc[0]][loc[1]-i] = '.';
					break;
				}
			}
		}
		
		else if (loc[2] == 3) { // 우로 쏠 때
			for (int i = 1; loc[1]+i <W; ++i) {
				if (checkSteel(loc[0], loc[1]+i, map)) {
					break;
				}
				if (checkBrick(loc[0], loc[1]+i, map)) {
					map[loc[0]][loc[1]+i] = '.';
					break;
				}
			}
		}

	}

	static boolean checkSteel(int x, int y, char[][] map) {
		if (map[x][y] == '#') {
			return true;
		}
		return false;
	}

	static boolean checkBrick(int x, int y, char[][] map) {
		if (map[x][y] == '*') {
			return true;
		}
		return false;
	}

}
