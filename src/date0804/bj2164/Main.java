package date0804.bj2164;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int n = 1;
		
		while(n<N) {
			n*=2;
		}
		n/=2;
		
		if(N==1) System.out.println(1);
		else System.out.println((N-n)*2);
	}
}
