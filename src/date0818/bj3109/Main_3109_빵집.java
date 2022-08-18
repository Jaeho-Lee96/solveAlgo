package date0818.bj3109;

import java.util.*;

public class Main_3109_빵집 {

    static int[] dx = {-1, 0, 1};
    static int[] dy = {1, 1, 1};
    static int r, c;
    static char[][] board;
    static boolean[][] memo;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        r = scan.nextInt();
        c = scan.nextInt();
        scan.nextLine();

        board = new char[r][c];
        for(int i = 0; i < r; i++) {
            String str = scan.nextLine();
            for(int j = 0; j < c; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        memo = new boolean[r][c];
        int count = 0;
        for(int i = 0; i < r; i++) {
            if(dfs(i, 0)) count++;
        }

        System.out.println(count);
    }

    public static boolean dfs(int x, int y) {
        for(int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < r && ny < c) {
                if(memo[nx][ny] == false && board[nx][ny] == '.') {
                    memo[nx][ny] = true;
                    if(ny == c - 1) return true;
                    if(dfs(nx, ny)) return true;
                }
            }
        }
        return false;
    }
}
