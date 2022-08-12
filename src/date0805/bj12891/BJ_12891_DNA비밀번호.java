package date0805.bj12891;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_12891_DNA비밀번호 {

	static int alpha(char c) {
		return c == 'A' ? 0 : c == 'C' ? 1 : c == 'G' ? 2 : 3;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt();
		int P = sc.nextInt();
		String str = sc.next();

		int[] t = new int[4];
		int[] arr = new int[4];

		for (int i = 0; i < 4; i++)
			t[i] = sc.nextInt();

		Queue<Character> q = new LinkedList<Character>();

		int answer = 0;
		char c;

		for (int i = 0; i < S; i++) {
			c = str.charAt(i);
			q.offer(c);
			arr[alpha(c)]++;
			if (q.size() == P + 1)
				arr[alpha(q.poll())]--;
			if (q.size() == P && arr[0] >= t[0] && arr[1] >= t[1] && arr[2] >= t[2] && arr[3] >= t[3])
				answer++;
		}
		System.out.println(answer);
	}
}