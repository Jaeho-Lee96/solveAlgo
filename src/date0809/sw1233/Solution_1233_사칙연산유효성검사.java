package date0809.sw1233;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_1233_사칙연산유효성검사 {
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("HW/src/date0809/sw1233/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		// 테스트케이스는 10번
		for(int t=1; t<=10; t++) {
			int N = Integer.parseInt(br.readLine());
			boolean isValid = true;
			sb.append("#"+t+" ");
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();

				char temp = st.nextToken().charAt(0);
				// 자식이 있을 때
				if(st.hasMoreTokens()) {
					if(temp >= '0' && temp <= '9')
						isValid = false;
				}
				// 자식이 없을 때
				else {
					if(temp < '0' || temp > '9')
						isValid = false;
				}
			}
			
			if(isValid == false) 
				sb.append(0+"\n");
			else 
				sb.append(1+"\n");
			
		}
		System.out.println(sb);
	}
}