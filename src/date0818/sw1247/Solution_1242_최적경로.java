package date0818.sw1247;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1242_최적경로 {

    static int N;
    static int myOffice[] = new int[2];
    static int myHome[] = new int[2];
    static int customers[][];
    static int choiced[];
    static boolean visited[];
    static int min;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/date0818/sw1247/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            min = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());

            customers = new int[N][2];
            choiced = new int[N];
            visited = new boolean[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            myOffice[0] = Integer.parseInt(st.nextToken());
            myOffice[1] = Integer.parseInt(st.nextToken());
            myHome[0] = Integer.parseInt(st.nextToken());
            myHome[1] = Integer.parseInt(st.nextToken());

            for(int i=0; i<N; i++) {
                customers[i][0] = Integer.parseInt(st.nextToken());
                customers[i][1] = Integer.parseInt(st.nextToken());
            }

            dfs(0);
            System.out.println("#" + t + " " + min);
        }
    }

    static void dfs(int depth) {
        if(depth == N) {
            int sum = getAllDist();
            if(sum < min) {
                min = sum;
            }
            return;
        }

        for(int i=0; i<N; i++) {
            if(visited[i]) continue;
            choiced[depth] = i;
            visited[i] = true;
            dfs(depth+1);
            visited[i] = false;
        }
    }

    static int getAllDist() {
        int sum = 0;
         sum += calDist(myOffice, customers[choiced[0]]);

        for(int i=0; i<N-1; i++) {
            sum += calDist(customers[choiced[i]], customers[choiced[i+1]]);
        }

        sum += calDist(customers[choiced[N-1]], myHome);
        return sum;
    }

    static int calDist(int[] a, int[] b) {
        int dist = Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
        return dist;
    }
}
