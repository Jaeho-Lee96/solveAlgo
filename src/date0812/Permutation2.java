package date0812;

import java.util.Arrays;

public class Permutation2 {

	static int N, totalCount;
	static int[] numbers = { 3, 5, 7, 8 };
	static boolean[] selected;
	static int[] ans;

	public static void main(String[] args) {
		N = numbers.length;
		ans = new int[N];
		selected = new boolean[N];
		go(0);
		System.out.println("===> " + totalCount);
	}

	private static void go(int count) {
		if (count == N) {
			totalCount++;
			System.out.println(Arrays.toString(ans));
			return;
		}
		for (int i = 0; i < N; i++) {

			if (!selected[i]) {

				selected[i] = true;

				ans[count] = numbers[i];
				go(count + 1);

				for (int j = i+1; j < N; j++) {
					selected[j] = false;
				}

			}
		}
	}
}
