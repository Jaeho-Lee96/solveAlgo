package date0811.sw5215;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Soultion_5215_햄버거다이어트 {
    static int T, N, L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            int[] arr = new int[N + 1];
            int[] cal = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());

                arr[i] = Integer.parseInt(st.nextToken());
                cal[i] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[N + 1][L + 1];

            for (int i = 1; i < dp.length; i++) {
                for (int j = 0; j < dp[i].length; j++) {
                    if (cal[i] > j) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(arr[i] + dp[i - 1][j - cal[i]], dp[i - 1][j]);
                    }
                }
            }

            System.out.printf("#%d %d\n", t, dp[N][L]);


        }

    }

}