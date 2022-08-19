package date0819.bj1697;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1697_술래잡기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int MAX = (int) Math.pow(10, 5);

        int[] dist = new int[100001];
        Deque<Integer> dq = new LinkedList<>();
        dq.offer(N);

        while(!dq.isEmpty()) {
            int x = dq.poll();
            if (x == K) {
                System.out.println(dist[x]);
                break;
            }
            int[] nxArr = {x+1, x-1, x*2};
            for(int nx : nxArr) {
                if(0<=nx && nx <= MAX && dist[nx] == 0) {
                    dist[nx] = dist[x] +1;
                    dq.add(nx);
                }
            }
        }
    }
}
