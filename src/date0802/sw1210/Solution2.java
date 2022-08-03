package date0802.sw1210;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution2 {
    static final int T = 10;
    static final int N = 100;
    static int[][] map = new int[N][N];
    static int t;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (t = 0; t < T; ++t) {
 
            br.readLine();
            int start = -1;
            for (int i = 0; i < N; ++i) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; ++j) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 2) {
                        start = j;
                    }
 
                }
            }
            goLadderDown(99, start);
        }
    } // main
 
    // 한방향으로만 내려가다가 건널목에서 확인
    static void goLadderDown(int x, int y) {
//      System.out.println("x: " + x + " y:" + y);
        if (x == 0) {
            System.out.println("#" + (t + 1) + " " + y);
            return;
        }
        if (y - 1 >= 0 && y - 1 < N && map[x][y - 1] == 1) {
            for (int i = 0; i <= y - 1; ++i) {
                if (y - i == 0 || map[x][y - i] == 0) {
//                  System.out.print(" L: " + (i + 1) + " ");
                    goLadderDown(x - 1, y - i + 1);
                    return;
                }
            }
        }
        // 아래로 보낸다
        if (y + 1 < N && y + 1 >= 0 && map[x][y + 1] == 1) {
            for (int i = 0; i <= N - y + 1; ++i) {
                if (y + i == N || map[x][y + i] == 0) {
//                  System.out.print(" R: " + (i - 1) + " ");
                    goLadderDown(x - 1, y + i - 1);
                    return;
                }
            }
        }
//      System.out.print("U");
        goLadderDown(x - 1, y);
    }
}