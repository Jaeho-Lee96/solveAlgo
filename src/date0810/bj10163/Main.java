package date0810.bj10163;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int size = 1001;
    static int[][] board = new int[size][size];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int n = 1; n <= N; ++n) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            placePaper(x1, y1, x2, y2, n);
        }

        for (int n = 1; n <= N; ++n) {
            int sum = 0;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (board[i][j] == n) {
                        sum += 1;
                    }
                }
            }
            System.out.println(sum);
        }
    }
    private static int[] placePaper(int x1, int y1, int x2, int y2, int n) {
        for (int i = x1; i < x1 + x2; i++) {
            for (int j = y1; j < y1 + y2; j++) {
                board[i][j] = n;
            }
        }
        int sum = 0;

        return new int[]{0, 1, 2};
    }
}
