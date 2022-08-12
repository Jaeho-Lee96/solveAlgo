package date0805.bj2493;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("HW/HW/src/date0805/bj2493/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int towers[] = new int[N];
		Stack<Integer> tStack = new Stack<>();
		for(int i=0; i<N; ++i) {
			tStack.push(Integer.parseInt(st.nextToken()));

		}
		
		int cnt = 1;
		int curMinIdx = 0;
		int curMax = Integer.MIN_VALUE;
		int[] answer = new int[N];
		Stack<Integer> stack = new Stack<>();
		// 감소하면 스택에 넣기
		// 값이 크면 스택에서 빼기
		int cur = tStack.pop();
		int idx = 0;
		stack.add(cur);
		System.out.println(stack.peek());
		while(tStack.size() != 0) {
			cur = tStack.pop();
			if(stack.size() == 0 || cur < stack.peek()) {
				cnt++;
				stack.push(cur);
			} else {
				stack.pop();
				for(int i=0;i<cnt; ++i) {
					System.out.print(cur + " ");
				}
				cnt=1;
			}
		}

		
		
		
	}
}
