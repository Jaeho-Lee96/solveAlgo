package date0812;

public class Recursive1 {
	public static void main(String[] args) {

		// 문제) 반복문을 재귀로
		int n = 0;
//		while(n<5) {
//			System.out.println(n);
//			n++;
//		}

		recur(n);

	}

	static void recur(int depth) {
		if (depth == 5)
			return;
		System.out.println(depth);
		recur(depth+1);
		//recur(++depth); // 백트래킹 안될 수 있음, parameter와 return value가 서로 다를 수 있음.
		//depth++ 안 됨. stackOverflowError
		System.out.println(">>>>" + depth); // => n: 0 1 2 3 4 => 리턴 : 1 2 3 4 5
	}
}
