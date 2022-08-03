package date0802.sw1208;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	static final int T = 10;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("HW/src/date0802/sw1208/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 0; t < T; ++t) {
			int max_cnt = Integer.parseInt(br.readLine());
			int[] arr = new int[100];
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 100; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}


			for (int k = 0; k < max_cnt+1; ++k) {
				int max = Integer.MIN_VALUE;
				int min = Integer.MAX_VALUE;
				int maxIdx = -1;
				int minIdx = -1;
				for (int i = 0; i < 100; ++i) {
					if (arr[i] > max) {
						max = arr[i];
						maxIdx = i;
					}
					if (arr[i] < min) {
						min = arr[i];
						minIdx = i;
					}
				}
				arr[maxIdx] -= 1;
				arr[minIdx] += 1;
				
				if(k == max_cnt) {
					System.out.println("#" + (t+1) + " " + (max - min));
				}
			}
		}
		
		
	}
}
