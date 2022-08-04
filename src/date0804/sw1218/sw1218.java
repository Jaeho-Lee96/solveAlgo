package date0804.sw1218;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class sw1218 {
	static final int T = 10;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/sw1218/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 0; t < T; ++t) {
		int size = Integer.parseInt(br.readLine());
	
		String s = br.readLine();
		Stack<Character> stack = new Stack();
		
		for(int i=0; i< size; ++i) {
			char c = s.charAt(i);
			if ( c == ')' && stack.peek() == '(') stack.pop();
			else if ( c == ']' && stack.peek() == '[') stack.pop();
			else if ( c == '}' && stack.peek() == '{') stack.pop();
			else if ( c == '>' && stack.peek() == '<') stack.pop();
			else stack.push(c);
		}
		System.out.print("#" + (t+1) + " ");
		if(stack.size() == 0) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
		}
	}
}
