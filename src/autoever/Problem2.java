package autoever;

import java.util.*;
import java.io.*;

public class Problem2 {
    static long nums[] = {1, 3, 5, 7, 13, 12, 11, 9, 2};
    static int N = 9;
    static int K = 5;
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<Long> dq = new ArrayDeque<>();
        // N 은 배열의 길이
        // K 는 찾으려는 K번 쨰 최소 값
        for(int i=0; i<N; i++) {
            dq.add(nums[i]);
        }
        int cnt = 0;
        int target;
        while(cnt == K) {
            long left = dq.pollFirst();
            long right = dq.pollFirst();

            if(left < right) {
                dq.offerLast(right);
                cnt++;
                if(cnt == K) {
                    System.out.println(left);
                }
            } else {
                dq.offerFirst(left);
                cnt++;
                if(cnt == K) {
                    System.out.println(right);
                }
            }
        }

    }
}
