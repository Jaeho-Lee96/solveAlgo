package date0808.bj1158;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1158_요세푸스순열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for(int i=1; i<=N; ++i) {
			q.offer(i);
		}
		int cnt = 1;
		while(q.size() != 1) {
			if(cnt == K) {
				sb.append(q.poll() + ", ");
				cnt = 1;
			} else {
				q.offer(q.poll());
				cnt++;
			}
		}
		
		sb.append(q.poll());
		sb.append(">");
		System.out.println(sb);
	}
}
