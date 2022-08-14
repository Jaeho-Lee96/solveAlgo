package bj14889;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] stats;
    static Integer[] team1, team2, team2avail;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt((br.readLine()));

        stats = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                stats[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        team1 = new Integer[N/2];
        team2avail = new Integer[N/2];
        //team 2 available 배열에서 가져오기
        dfs(0, 0, N/2);


        System.out.println(min);
    }

    static void dfs(int idx, int depth, int targetDepth) {
        if (depth == targetDepth) {
            team2 = new Integer[N - team1.length];
            int k = 0;
            for (int i = 0; i < N; i++) {
                if (!Arrays.asList(team1).contains(i)) {
                    team2[k++] = i;
                }
            }
            compareStats();
            return;
        }

        for (int i = idx; i < N; i++) {
            team1[depth] = i;
            dfs(i + 1, depth + 1, targetDepth);
        }
    }

    static void compareStats() {
        int team1Sum = 0;
        int team2Sum = 0;
        for (int i = 0; i < team1.length; i++) {
            for (int j = 0; j < team1.length; j++) {
                team1Sum += stats[team1[i]][team1[j]];
                team2Sum += (stats[team2[i]][team2[j]]);
            }
        }
        min = Math.min(min, Math.abs(team1Sum - team2Sum));
    }
}
