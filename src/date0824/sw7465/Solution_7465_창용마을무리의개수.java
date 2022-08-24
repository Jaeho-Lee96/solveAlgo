package date0824.sw7465;

import java.io.*;
import java.util.*;

public class Solution_7465_창용마을무리의개수 {

    static int[] parents;
    static int N, M;

    static void make() {
        parents = new int[N];

        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
    }

    static int find(int x) {
        if (parents[x] == x) return x;
//        return parents[x] = parents[parents[x]];
        return parents[x] = find(parents[x]);
    }

    static boolean union(int a, int b) {
		System.out.println(a + " " + b);
        System.out.println(Arrays.toString(parents));
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/date0824/sw7465/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());


            make();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                union(a, b);
            }
            // 매우 중요한 부분 Path Compression 다시 해야 함!!
            for (int i = 0; i < N; i++) {
                find(i);
            }

            int cnt = 0;
            List<Integer> groups = new ArrayList<>();
            for (int i = 0; i < parents.length; i++) {
                if (!groups.contains((Integer) parents[i])) {
                    groups.add(parents[i]);
                    cnt++;
                }
            }
            System.out.println(Arrays.toString(parents));
            System.out.println(groups);
            System.out.println("#" + (t + 1) + " " + cnt);

        }


    }
}
