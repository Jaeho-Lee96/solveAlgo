package date0802.mission;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ArraySortTest3 {
	
	static class Person implements Comparator<Person>, Comparable<Person>{ //인터페이스 쓰기 싫으면 
		String name;
		int age;
		String job;
		int score;

		public Person() {
			// TODO Auto-generated constructor stub
		}

		public Person(String name, int age, String job, int score) {
			super();
			this.name = name;
			this.age = age;
			this.job = job;
			this.score = score;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Person [name=");
			builder.append(name);
			builder.append(", age=");
			builder.append(age);
			builder.append(", job=");
			builder.append(job);
			builder.append(", score=");
			builder.append(score);
			builder.append("]\n");
			return builder.toString();
		}

		//==> Person이름의 오름차순 정렬하시오.
		@Override
		public int compareTo(Person o) {//정렬의 기준을 (사용자가) 정의
			//this(Person)의 속성과 o(Person)의 속성을 비교
			//비교방법  this.속성 -  o.속성
			//결과: 음수, 0, 양수  ==> 음수의 경우 swap을 해줌  ==> 오름차순 정렬
			
			return this.age - o.age; //오름차순정렬
//			return this.name - o.name;
//			return this.name.compareTo(o.name); //문자열의 경우는 오버라이드 메서드 사용
//			return 0;
			
			//만약 (나이기준)내림차순 정렬을 하고 싶다!!
//			return o.age -  this.age;
//			return -(this.age - o.age);
		}

		@Override
		public int compare(Person o1, Person o2) {
			//오름 차순
//			return o1.age - o2.age;
			//내림 차순
			return -(o1.age - o2.age);
		}

	}
	
	
   public static void main(String[] args) {

	   ArrayList<Person> list = new ArrayList<>();
	      list.add(new Person("갓길동",11,"학생",95));
	      list.add(new Person("빛길동",19,"학생",80));
	      list.add(new Person("남길동",14,"학생",100));
	      list.add(new Person("여길동",17,"학생",99));
	      list.add(new Person("킹길동",15,"학생",56));
	   
	   //Person배열(list)정렬~!!   ==> 나이순으로 정렬
//	   Arrays.sort(list); //에러발생!! ==> Arrays클래스의 sort메소드를 통해 Collection(List)의 정렬을 할 수 없음~!!
	      
	    //해결방법은???  Collections의 sort메서드 사용
	   Collections.sort(list);//list가 관리하는 클래스가 Comparable일때
//	   Collections.sort(list,new Person());//list가 관리하는 클래스가 Comparator일때  
	                                       //Collections.sort(list, Comparator객체);
	   System.out.println(list);
	   Collections.sort(list, new Person());
	   
	   System.out.println(list);//배열의 값을 문자열형태로 출력
	   
	   
   }//main
}












