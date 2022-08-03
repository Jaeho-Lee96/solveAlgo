package date0802.mission;

import java.util.Arrays;
import java.util.Collections;

public class Sorting {
	public static void main(String[] args) {
		int[] su = {13, 8, 7, 10, 100, 5};
		Arrays.sort(su);
		System.out.println(Arrays.toString(su)); 
		
		
		char[] ch = {'J', 'a', 'v', 'A'};
		String[] names = {"홍길동", "길라임", "김주원"};
		
		Arrays.sort(ch);
		System.out.println(Arrays.toString(ch));
		Arrays.sort(names);
		System.out.println(Arrays.toString(names));

		Person p = new Person("갓길동",11,"학생",95);
		Person[] persons= {p ,
		   	            new Person("빛길동",19,"학생",80),
			            new Person("남길동",14,"학생",100),
			            new Person("여길동",17,"학생",99),
			            new Person("킹길동",15,"학생",56)};
		
		Arrays.sort(persons);
		System.out.println(Arrays.toString(persons));
		
		Arrays.sort(persons, Collections.reverseOrder());
		System.out.println(Arrays.toString(persons));
		Integer[] su2 = {13, 8, 7, 10, 100, 5};
		//내림 차순 정렬
		Arrays.sort(su2, Collections.reverseOrder());
	}
}
