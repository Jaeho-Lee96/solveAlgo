package date0809.sw2563;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2563_색종이 {
    static int[][] board = new int[100][100];
    static final int size = 10;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/date0809/sw2563/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int r=x; r<x+size; r++) {
                for(int j=y; j<y+size; j++) {
                    board[r][j] = 1;
                }
            }
        }
        for (int c = 0; c < board.length; ++c) {
            for (int j = 0; j < board.length; ++j) {
                if (board[c][j] == 1) {
                    sum += 1;
                }
            }
        }
        System.out.println(sum);
    }
}
