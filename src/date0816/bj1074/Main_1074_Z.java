package date0816.bj1074;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074_Z {
    static int N, r, c, cnt;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        check((int) Math.pow(2, N), 0, 0);
    }

    static void check(int n, int y, int x) {
        if (y == r && x == c) {
            System.out.println(cnt);
            System.exit(0);
        }

        if (y<=r && r< (y+n) && x <= c && c < (x+n)) {
            int nn = n / 2;
            check(nn, y, x);
            check(nn, y, x+nn);
            check(nn, y+nn, x);
            check(nn, y+nn, x+nn);
        } else
            cnt += n*n;
    }

}
