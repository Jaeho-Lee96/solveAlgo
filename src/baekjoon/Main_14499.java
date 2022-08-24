package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14499 {

    static int N, M, x, y, K;
    static int[][] graph;
    static int[] orders;
    static int[] dice = new int[]{0, 0, 0, 0, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int order = Integer.parseInt(st.nextToken());
            boolean flag = move(order);
            if(flag) {
                fillDice();
                System.out.println(dice[0]);
            }

        }




    }

    static boolean checkBounds() {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    static void fillDice() {
        if(graph[x][y] == 0) graph[x][y] = dice[5];
        else {
            dice[5] = graph[x][y];
            graph[x][y] = 0;
        }
    }

    static boolean move(int order) {
        int temp = 0;
        temp = dice[0];
        if (order == 1) { // 동쪽 이동
            y++;
            if(!checkBounds()) {
                y--;
                return false;
            }
            dice[0] = dice[3];
            dice[3] = dice[5];
            dice[5] = dice[2];
            dice[2] = temp;

        } else if (order == 2) { // 서쪽 이동
            y--;
            if(!checkBounds())  {
                y++;
                return false;
            }
            dice[0] = dice[2];
            dice[2] = dice[5];
            dice[5] = dice[3];
            dice[3] = temp;

        } else if (order == 3) { // 북쪽 이동
            x--;
            if(!checkBounds()) {
                x++;
                return false;
            }
            dice[0] = dice[1];
            dice[1] = dice[5];
            dice[5] = dice[4];
            dice[4] = temp;

        } else if (order == 4) { // 남쪽 이동
            x++;
            if(!checkBounds()) {
                x--;
                return false;
            }
            dice[0] = dice[4];
            dice[4] = dice[5];
            dice[5] = dice[1];
            dice[1] = temp;

        }
        return true;
    }

}
