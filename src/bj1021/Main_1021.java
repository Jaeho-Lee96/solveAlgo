package bj1021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1021 {

    static Deque<Integer> dq;
    static int cnt = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        dq = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken()); // size of Q
        int M = Integer.parseInt(st.nextToken()); // 뽑아 내려는 수

        for (int i = 1; i <= N; i++) {
            dq.add(i);
        }

        // 첫 번쨰 원소 뽑기
        // 큐 좌 우로 이동 시키기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; ++i) {
            int target = Integer.parseInt(st.nextToken());
            operate(target);
        }

        System.out.println(cnt);

    }

    public static void operate(int target) {
        boolean dir = false;
        LinkedList<Integer> list = (LinkedList<Integer>) dq;
        for(int i = 0; i<= dq.size()/2; i++) {
            if(list.get(i) == target) {
                dir = true;
            }
        }
        while (true) {
            if (dq.peekFirst() == target) {
                dq.poll();
                break;
            }
            if(dir) {
                dq.offer(dq.poll());
                cnt++;
            } else {
                dq.offerFirst(dq.pollLast());
                cnt++;
            }

        }
    }
}
