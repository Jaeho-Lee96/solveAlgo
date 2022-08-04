package date0804.sw1225;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class sw1225 {

	static int T = 10;
	static int D = 1;
	static Queue<Integer> queue;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("HW\\src\\date0804\\sw1225\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 0; t < T; t++) {
			String trash = br.readLine();
			queue = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; ++i) {
				int temp = Integer.parseInt(st.nextToken());
				queue.add(temp);
			}
			
			int delta = 1;
			while(true) {
				int cur = queue.poll() - delta;
				
				if(cur<=0) {
					queue.offer(0);
					break;
				} else {
					queue.offer(cur);
				}
				
				delta = (delta % 5) + 1;
			}
			System.out.print("#" + (t+1) + " ");
			for(int i=0; i<8; ++i) {
				System.out.print(queue.poll() + " ");
			}
			System.out.println();
		}

	}
}
