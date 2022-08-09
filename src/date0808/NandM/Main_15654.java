package date0808.NandM;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15654 {

    static int N;
    static int M;
    static int[] nums;
    static int[] answer;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/date0808/NandM/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        nums = new int[N];
        answer = new int[M];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        dfs(0,0);

        System.out.println(sb);
    }

    private static void dfs(int idx, int depth) {
        if (depth == M) {
            for (int n : answer) {
                sb.append(n + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if(visited[i]) continue;
            answer[depth] = nums[i];
            visited[i] = true;
            dfs(idx+1, depth+1);
            visited[i] = false;
        }

    }
}
