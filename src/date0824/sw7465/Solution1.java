package date0824.sw7465;


import java.util.*;
import java.io.*;

public class Solution1 {

    private static int[] parents;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/date0824/sw7465/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            parents = new int[N + 1];
            for (int i = 1; i <= N; i++) parents[i] = i;

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }

            Set<Integer> set = new HashSet<>();
            for (int i = 1; i <= N; i++) set.add(find(i));
            System.out.println(set);
            System.out.println(Arrays.toString(parents));
            bw.write("#" + tc + " " + set.size() + "\n");
        }

        bw.flush();
        bw.close();
    }

    // a가 속한 집합의 대표자 찾기
    private static int find(int a) {
        if (a == parents[a]) return a; // 자신이 대표자인 경우
        return parents[a] = find(parents[a]); // 자신이 속한 집합의 대표자를 자신의 부모로 설정
    }

    // 두 원소를 하나의 집합으로 합치기 (대표자를 이용해서 합침)
    private static boolean union(int a, int b) {
        System.out.println(a + " " + b);
        int aRoot = find(a);
        int bRoot = find(b);
        System.out.println(Arrays.toString(parents));
        if (aRoot == bRoot) return false; // 이미 같은 집합으로 합치지 않음
        parents[bRoot] = aRoot;
        return true;
    }

}