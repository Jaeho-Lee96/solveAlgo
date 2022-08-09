package src.date0809.sw1861;

import java.io.*;
import java.util.*;

public class Solution_1861_정사각형방 {
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int[][] rooms;
    static int count = 1;
    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        System.setIn(new FileInputStream("src/date0809/sw1861/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            rooms = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    rooms[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int room = Integer.MAX_VALUE;
            int max = 0;


            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    count = 1;
                    dfs(i, j); // 현재 방의 횟수
                    int temp_room = rooms[i][j]; // 현재 방에 적힌 숫자
                    if (max < count) {
                        max = count;
                        room = temp_room;
                    } else if (max == count) {
                        room = Math.min(room, temp_room);
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(room).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    static int dfs(int r, int c) {
        for (int i = 0; i < dx.length; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];
            if (0 <= nr && nr < N && 0 <= nc && nc < N) { // 범위 안에 들어오
                if (rooms[nr][nc] - rooms[r][c] == 1) {
                    count++;
                    dfs(nr, nc);
                }
            }
        }
        return count;
    }
}