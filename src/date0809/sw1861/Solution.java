package src.date0809.sw1861;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int[][] square;
    static boolean[][] visited;
    static int N;
    static int max = 0;
    static int roomNum = Integer.MAX_VALUE;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("src/date0809/sw1861/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            square = new int[N][N];
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    square[i][j] = Integer.parseInt(st.nextToken());
                }
//                System.out.println(Arrays.toString(square[i])
            }
            System.out.println(Arrays.deepToString(square));

            for(int i=0; i<N; ++i) {
                for(int j=0; j<N; j++ ){
                    int cnt = dfs(i, j);
                    int temp = square[i][j];
                    if(max < cnt) {
                        max = cnt;
                        roomNum = temp;
                    } else if (max == cnt) {
                        roomNum = Math.min(roomNum, temp);
                    }
                }
            }

            System.out.println("#" + t +  " " +roomNum  + " " + max);
        }

    }

    private static int dfs(int x, int y) {
//        System.out.println("x : " + x + " y: " + y);
//        System.out.println(square[x][y]);
        int cnt = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                if (Math.abs(square[nx][ny]-square[x][y]) == 1) {
                    cnt++;
                    if(visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    dfs(nx,ny);
                }
            }
        }
        return cnt;
    }

}
