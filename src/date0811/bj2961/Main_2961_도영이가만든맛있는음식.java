package date0811.bj2961;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2961_도영이가만든맛있는음식 {
    static int N;
    static int[] S, B, choiced;
    static boolean[] visited;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        S = new int[N];
        B = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        // 신맛은 곱, 쓴맛은 합합 재료는 여러개
        for (int i = 1; i <= N; i++) {
            choiced = new int[i];
            dfs(0, 0, i);
        }

        System.out.println(min);

    }

    static void dfs(int idx, int depth, int targetDepth) {
        if (depth == targetDepth) {
            int sour = 1;
            int bitter = 0;
            for (int i = 0; i < targetDepth; i++) {
                sour *= S[choiced[i]];
                bitter += B[choiced[i]];
            }
            if(Math.abs(sour-bitter) < min ) {
                min = Math.abs(sour-bitter);
            }
            return;
        }

        for (int i = idx; i < N; i++) {
            if (visited[i]) continue;
            choiced[depth] = i;
            visited[i] = true;
            dfs(idx + 1, depth + 1, targetDepth);
            visited[i] = false;
        }


    }

}
