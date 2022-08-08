package date0808.NandM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainNandM4 {

    static int N; // 1~N 숫자
    static int M; // 고를 숫자 수
    static boolean[] visited;
    static int[] nums;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        nums = new int[M];

        combi(1, 0);
        System.out.println(sb);
    }

    private static void combi(int idx, int cnt) {
        if(cnt == M) {
            for(int n : nums) {
                sb.append(n +  " ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1; i<=N; ++i) {
            //중복 체크
            if(cnt > 0 && nums[cnt-1] > i) continue;
            nums[cnt] = i;
            combi(idx, cnt+1);

        }
    }
}
