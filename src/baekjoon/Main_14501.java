package baekjoon;

import java.io.*;
import java.util.*;

public class Main_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] T = new int[N + 2];
        int[] P = new int[N + 2];
        int[] dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i > 0; i--) {
            int next = i + T[i];
            if (next > N + 1) { // 일할 수 있는 날짜를 넘어가는 경우
                dp[i] = dp[i + 1];
            } else {    // 돈을 더 많이 버는 경우를 게산
                dp[i] = Math.max(dp[i + 1], dp[next] + P[i]);
            }
        }
        sb.append(dp[1]).append("\n");

        System.out.println(sb);
    }
}