package date0808.sw1228;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static final int T = 10;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/sw1228/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			List<String> pw = new LinkedList<>();
			
			for(int i=0; i<10;++i) {
				pw.add(i, st.nextToken());
			}
			
			int orderCnt = Integer.parseInt(br.readLine());
			String[] order = new String[orderCnt];
			st = new StringTokenizer(br.readLine(), "I");
			for(int i=0; i< orderCnt; ++i) {
				String temp[] = st.nextToken().split(" ");
				System.out.println(Arrays.toString(temp));
//				System.out.println(Arrays.toString(temp));
				int loc = Integer.parseInt(temp[1]);
				int howManyWords = Integer.parseInt(temp[2]);
				if(loc<10) {
					int c = 1;
					for(int j=loc; c < howManyWords; ++j) {
						System.out.println("j:" + j +  " " + 2+c);
						pw.add(j, temp[2+c]);
						System.out.println(pw);
						++c;
					}
				}
			}
			System.out.println(pw);
			
			
		}
	}
}
