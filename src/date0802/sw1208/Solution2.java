package date0802.sw1208;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution2 {
	static final int T = 10;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("HW/HW/src/date0802/sw1208/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int t = 0; t < T; ++t) {
			int max_cnt = Integer.parseInt(br.readLine());
			int[] arr = new int[100];
			int[] map = new int[101];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < 100; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
				map[arr[i]] += 1;
				if (arr[i] > max) {
					max = arr[i];
				}
				if (arr[i] < min) {
					min = arr[i];
				}
			}

			for (int i = 0; i < max_cnt; ++i) {
				map[max] -= 1;
				map[max - 1] += 1;
				map[min] -= 1;
				map[min + 1] += 1;
				if (map[max] == 0) {
					for (int j = max - 1; j > 0; --j) {
						if (map[j] != 0) {
							max = j;
							break;
						}
					}
				}
				if (map[min] == 0) {
					for (int j = min; j < map.length; ++j) {
						if (map[j] != 0) {
							min = j;
							break;
						}
					}
				}
			}

			bw.write("#" + (t + 1) + " " + (max - min) + "\n");
			bw.flush();

		}

	}
}
