package date0810.bj16935;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16935_배열돌리기3{
    static int N;
    static int M;
    static int R;
    static int[][] arr;
    static int[][] tempArr;


    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/date0810/bj16935/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
//            System.out.println(Arrays.toString(arr[i]));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            int opN = Integer.parseInt(st.nextToken());

            switch (opN) {
                case 1:
                    rotate1();
                    break;
                case 2:
                    rotate2();
                    break;
                case 3:
                    rotate3();
                    break;
                case 4:
                    rotate4();
                    break;
                case 5:
                    rotate5();
                    break;
                case 6:
                    rotate6();
                    break;
            }

        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void rotate1() {
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[N - 1 - i][j];
                arr[N - 1 - i][j] = temp;
            }
        }
    }

    static void rotate2() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][M - 1 - j];
                arr[i][M - 1 - j] = temp;
            }
        }
    }

    static void rotate3() {
        tempArr = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempArr[j][N - i - 1] = arr[i][j];
            }
        }
        arr = tempArr;
        int tmp;
        tmp = N;
        N = M;
        M = tmp;
    }

    static void rotate4() {
        rotate3();
        rotate3();
        rotate3();
    }

    static void rotate5() {
        int[][] tempArr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                //1번 구역일 때, 4번 구역
                if (i < N / 2 && j < M / 2) tempArr[i][j] = arr[i + N / 2][j];
                //2번 구역일 때 ,1번 구역
                else if (i < N / 2 && j >= M / 2) tempArr[i][j] = arr[i][j - M / 2];
                //4번 구역일 때 ,3번 구역
                else if (i >= N / 2 && j < M / 2) tempArr[i][j] = arr[i][j + M / 2];
                //3번 구역일 때, 2번 구역
                else if (i >= N / 2 && j >= M / 2) tempArr[i][j] = arr[i - N / 2][j];
            }
        }
        arr = tempArr;
    }

    static void rotate6() {
        int[][] tempArr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 1번 구역일 때, 2번 구역
                if (i < N / 2 && j < M / 2) tempArr[i + N / 2][j] = arr[i][j];
                    // 2번 구역일 때 3번 구역
                else if (i < N / 2 && j >= M / 2) tempArr[i][j - M / 2] = arr[i][j];
                    //4 번 구역일 때 1번 구역
                else if (i >= N / 2 && j < M / 2) tempArr[i][j + M / 2] = arr[i][j];
                    //3 번 구역에는 4번 구역
                else if (i >= N / 2 && j >= M / 2) tempArr[i - N / 2][j] = arr[i][j];
            }
        }
        arr = tempArr;
    }
}
