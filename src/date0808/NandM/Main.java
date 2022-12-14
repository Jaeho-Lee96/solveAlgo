package date0808.NandM;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

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

        nums = new int[N];
        visited = new boolean[N];
        answer = new int[M];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        dfs(0,0);
        System.out.println(sb);

    }

    private static void dfs(int idx, int depth) {
        if(depth == M) {
            for(int n : answer) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=idx; i<nums.length; i++) {
            //if(visited[i]) continue;
            if(visited[i] || idx >= 1 && answer[depth-1] > nums[i]) continue;
            answer[depth] = nums[i];
            visited[i]= true;
            dfs(idx+1, depth+1);
            visited[i] = false;
        }
    }

}
