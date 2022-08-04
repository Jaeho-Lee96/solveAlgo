package date0804.bj2164;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main_2164_카드2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> q = new LinkedList<>();
		
		for(int i=1; i<=N; ++i ) {
			q.add(i);
		}
		
		
		while(q.size()!=1) {
			q.pollFirst();
			
			int temp = q.pollFirst();
			q.offerLast(temp);
			
		}
		
		System.out.println(q.poll());
	}
}
