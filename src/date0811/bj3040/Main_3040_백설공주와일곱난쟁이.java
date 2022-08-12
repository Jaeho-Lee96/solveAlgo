package date0811.bj3040;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_3040_백설공주와일곱난쟁이 {
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] s = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            s[i] = Integer.parseInt(br.readLine());
            sum += s[i];
        }

        int spy1 = -1, spy2 = -1;

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if(sum - s[i] - s[j] == 100) {
                    spy1 = i;
                    spy2 = j;
                }
            }
        }

        for(int i=0; i<9; i++) {
            if (i == spy1 || i == spy2) continue;

            System.out.println(s[i]);
        }
    }
}
