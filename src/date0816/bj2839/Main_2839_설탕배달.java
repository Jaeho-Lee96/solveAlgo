package date0816.bj2839;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_2839_설탕배달 {
    public static void main(String[] args) throws Exception {
        // 5kg 봉지, 3kg 봉지
        System.setIn(new FileInputStream("src/date0816/bj2839/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N % 5 == 0) {
            System.out.println(N/5);
        } else {
            int p = 0;
            while(N > 0) {
                N -= 3;
                p += 1;
                if(N % 5 == 0 ) {
                    p += N/5;
                    System.out.println(p);
                    break;
                } else if (N < 3) {
                    System.out.println(-1);
                    break;
                } else if (N == 0 ) {
                    System.out.println(p);
                    break;
                }
            }
        }
    }
}
