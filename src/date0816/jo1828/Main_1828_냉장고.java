package date0816.jo1828;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1828_냉장고 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =Integer.parseInt(br.readLine());

        int[][] chems = new int[N][2];
        int count = 1;

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            chems[i][0] = Integer.parseInt(st.nextToken());
            chems[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(chems, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        int maxCelcious = chems[0][1];

        for(int i=1; i<N; i++) {
            if(chems[i][0] <= maxCelcious) {
                if(chems[i][1] < maxCelcious) {
                    maxCelcious = chems[i][1];
                }
                continue;
            } else {
                maxCelcious = chems[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
