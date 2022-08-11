package date0811.sw5215;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
    static int max = 0;
    static int N, L;
    static int[] taste;
    static int[] K;
    static int[] ingred;
    static int[] ingredK;
    static boolean[] visited;
    static int sum = 0;
    static int kSum = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/date0811/sw5215/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; ++t) {
            StringTokenizer st = new StringTokenizer(br.readLine());


            N = Integer.parseInt(st.nextToken()); // 재료 개수
            L = Integer.parseInt(st.nextToken()); // 제한 칼로리

            taste = new int[N]; // 맛 점수
            K = new int[N]; // 칼로리
            visited = new boolean[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                taste[i] = Integer.parseInt(st.nextToken());
                K[i] = Integer.parseInt(st.nextToken());

            }

            ingred = new int[N];
            ingredK = new int[N];
            dfs(0, 0);

            sb.append("#" +(t+1) + " " +  max + "\n");
        }
        System.out.println(sb);
    }

    static void dfs(int idx, int depth) {

        for(int i=0; i<depth; i++) {
            kSum += ingredK[i];
        }
        if (kSum > 1000) {
            for (int i = 0; i < depth - 1; i++) {
                sum += ingred[i];
            }

            if (sum > max) {
                max = sum;
            }
            kSum = 0;
            sum = 0;
            return;
        }
        kSum =0;
        for (int i = idx; i < N; i++) {
            if(visited[i]) continue;
            ingred[depth] = taste[i];
            ingredK[depth] = K[i];
            visited[i] = true;
            dfs(idx + 1, depth + 1);
            visited[i] = false;
        }
    }
}
