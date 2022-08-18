import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1541_잃어버린괄호 {
/*
   문제분석)
   1. 문자열은 0~9, +, - 문자로만 구성
   2. 임의의 괄호를 묶어 사칙연산의 결과가 최소값이 나오게 한다.
   3. 예) 55-50+40  --> 55-(50+40)
       ==> 음수(-) 괄호를 묶어주면 괄호안의 모든 양수가 부호가 바뀌어 음수가 된다!!
  
   적용)      
   1. 음수(-) 문자를 뽑아서 그 뒤의 숫자를 모두 음수로 바꾸어 주면 되지 않을까?
   2. 음수(-)가 여러개 있다면 어떻게 해야하지?    
   3. 특정문자를 통한 문자열 분리 ==> indexOf와 substring,  split, StringTokenizer    
 */
   public static void main(String[] args) throws Exception{
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  String str = br.readLine();
	  //"55-50+40" "10+20+30+40"  "00009-00009"
	  //추가 문자열 "13+55-50+40-70+90"
	  
	  
	  StringTokenizer minusTokens = new StringTokenizer(str,"-");
	  
//	  while(minusTokens.hasMoreTokens()) {
//		  System.out.println(minusTokens.nextToken());
//	  }
	  
	  int sum=0;
	  boolean flag = true;//최초 숫자 확인용 (맨앞의 양수를 확인)
	  
	  while(minusTokens.hasMoreTokens()) {
		  int value=0;
	   String subStr = minusTokens.nextToken();
	   
	   StringTokenizer plusTokens = new StringTokenizer(subStr,"+");
	   
		  while(plusTokens.hasMoreTokens()) {
			   value += Integer.parseInt(plusTokens.nextToken());
		  }
		   
	      if(flag) { //맨 앞의 숫자로 sum을 초기화
	    	  sum = value;
	    	  flag=false;
	      }else {
	    	  sum -=value;
	      }
	  }
	  System.out.println(sum);
	  br.close();
   }//main
}//end class
