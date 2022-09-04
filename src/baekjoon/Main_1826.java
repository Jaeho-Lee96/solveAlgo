package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1826 {

    static int N, L, P;
    static Deque<int[]> gasStations;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        Deque<int[]> gasStations = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int loc = Integer.parseInt(st.nextToken());
            int fuel = Integer.parseInt(st.nextToken());
            gasStations.offer(new int[]{loc, fuel});

        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());


        int answer = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> -(o1[1] - o2[1]));
//        System.out.println(P + " " + L);

        while (P < L) {
            while (!gasStations.isEmpty() && gasStations.peek()[0] <= P) {
                pq.add(gasStations.poll());
            }
            if (pq.isEmpty()) {
                answer = -1;
                break;
            }
            answer++;
            P += pq.poll()[1];

        }
        System.out.println(answer);
    }
}
