package date0810.bj17406;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main_17406_배열돌리기4 {
    static int K, N, M;

    static int[][] arr;
    static int[][] arrOrigin;
    static int[] nums;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
    static int[][] A;
    static int[] dx = {0, 1, 0, -1}; // 우 하 좌 상
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/date0810/bj17406/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        arr = new int[N][M];
        arrOrigin = new int[N][M];
        nums = new int[K];
        visited = new boolean[K];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            arrOrigin[i] = arr[i].clone();
        }
        A = new int[K][3];

        for (int i = 0; i < K; ++i) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            A[i] = new int[]{r, c, s};
//            System.out.println("================================");
//            System.out.println(Arrays.toString(A[i]));
//            System.out.println("================================");
        }

        dfs(0);

        System.out.println(min);

    }

    static void rotate(int r, int c, int s) {

        spin(arr, r-s, c-s, 0);

//        int[][] temp = new int[1 + 2 * s][1 + 2 * s];
//        int x = 0;
//        for (int j = r - s; j < r + s + 1; j++) {
//            int y = 0;
//            for (int k = c - s; k < c + s + 1; k++) {
//                temp[x][y] = arr[j][k];
//                y++;
//            }
////            System.out.println(Arrays.toString(temp[x]));
//            x++;
//        }
//
//        spin(temp, 1 + 2 * s, 1 + 2 * s, 0);
//
//        x = 0;
//        for (int j = r - s; j < r + s + 1; j++) {
//            int y = 0;
//            for (int k = c - s; k < c + s + 1; k++) {
//                arr[j][k] = temp[x][y];
//                y++;
//            }
////            System.out.println(Arrays.toString(temp[x]));
//            x++;
//        }

        //print arr
//        System.out.println("===========arr===================");
//        for(int i=0; i<N; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }
//        System.out.println("================================");
    }

    static void spin(int[][] temp, int x, int y, int depth) {
        if (x < 2 || y < 2) return;
//        System.out.println(x + " " + y);
//        System.out.println("=================");

        int px = depth;
        int py = depth;
        int d = 0;

        Deque<Integer> q = new LinkedList<>();

        while (d < 4) {
//            System.out.println(px + " " + py);
            q.offer(temp[px][py]);
            px = px + dx[d];
            py = py + dy[d];
            if (py + dy[d] > depth + x - 1) d++;
            else if (px + dx[d] > depth + x - 1) d++;
            else if (py + dy[d] < depth) d++;
            else if (px + dx[d] < depth) d++;
        }

        q.offerFirst(q.pollLast());
//        System.out.println(q);
        d = 0;

        while (d < 4) {
            temp[px][py] = q.poll();
            px = px + dx[d];
            py = py + dy[d];
            if (py + dy[d] > depth + x - 1) d++;
            else if (px + dx[d] > depth + x - 1) d++;
            else if (py + dy[d] < depth) d++;
            else if (px + dx[d] < depth) d++;
        }

//        System.out.println("completeRotated");
        for (int[] ints : temp) {
//            System.out.println(Arrays.toString(ints));
        }

        spin(temp, x - 2, y - 2, depth + 1);


    }

    static void dfs(int depth) {
        if (depth == K) {
//            System.out.println(Arrays.toString(nums));
            for (int n : nums) {
//                System.out.println(A[n][0] + " " +  A[n][1] + " " + A[n][2]);
                rotate(A[n][0], A[n][1], A[n][2]);
            }
            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int j = 0; j < M; j++) {
                    sum+= arr[i][j];
                }
                if(sum < min) min = sum;
            }
//            System.out.println("min: " + min);
            for(int i=0; i<N; i++) {
                arr[i] = arrOrigin[i].clone();
            }
            return;
        }

        for (int i = 0; i < K; i++) {
            if(visited[i]) continue;
            nums[depth] = i;
            visited[i] = true;
            dfs(depth + 1);
            visited[i] = false;
        }
    }


}
