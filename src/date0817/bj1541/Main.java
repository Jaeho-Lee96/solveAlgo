package date0817.bj1541;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		
		int max = 0;
		
		
		int res = 0;
		int i = 0;

		while(st.hasMoreTokens()) {
			String s = st.nextToken();
			LinkedList<Integer> arr = new LinkedList<>();
			StringTokenizer stSum = new StringTokenizer(s, "+");
			int sum = 0;
			while(stSum.hasMoreTokens()) {
				if(i == 0) {
					sum += Integer.parseInt(stSum.nextToken());
					res = sum;
					i++;

				} else {
					res -=sum;
				}
			}
			
			if(sum > max) {
				max = sum;
			}
			

		}
		System.out.println(res);
		
	}
}
