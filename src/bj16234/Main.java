package bj16234;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R;
    static int[][] A;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/bj16234/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new int[N][N];

        //인구 이동 인구 차이가 L이상 R이하면 하루 동안 개방
        //각 지점은 모두 나라
        //인구 이동 시작, 인접 칸만 이동하며, 그 나라를 오늘 하루 동안 연합이라 한다.
        //연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수 / 연합을 이루고 있는 칸의 개수)
        //국경 폐쇄.

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }
}
