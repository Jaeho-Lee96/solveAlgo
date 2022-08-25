package date0825.bj1197;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1197_최소스패닝트리 {

    static int V, E;
    static int[] parents;
    static int[][] EdgeList;
    static int totalWeight = 0;

    static void make() {
        parents = new int[V];
        for(int i=0; i<V; i++) {
            parents[i] = i;
        }
    }
    public static int find(int x) {
        if(parents[x] ==x ) return x;
        return parents[x] = find(parents[x]);
    }

    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot != bRoot) parents[b] = a;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        make();
        EdgeList = new int[E][3];


        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            EdgeList[i][0] = Integer.parseInt(st.nextToken())-1;
            EdgeList[i][1] = Integer.parseInt(st.nextToken())-1;
            EdgeList[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(EdgeList, ((o1, o2) -> o1[2] - o2[2]));
        for(int[] edge : EdgeList) {
            int a = find(edge[0]);
            int b = find(edge[1]);
            if(a != b) {
                union(a, b); // find로 합쳐줘야함

                totalWeight += edge[2];
            }
        }

        System.out.println(totalWeight);

    }
}
