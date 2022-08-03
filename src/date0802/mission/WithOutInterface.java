package date0802.mission;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class WithOutInterface {
	
	static class Person { //인터페이스 쓰기 싫으면 
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
	}
	
	
   public static void main(String[] args) {

	   ArrayList<Person> list = new ArrayList<>();
	      list.add(new Person("갓길동",11,"학생",95));
	      list.add(new Person("빛길동",19,"학생",80));
	      list.add(new Person("남길동",15,"학생",100));
	      list.add(new Person("여길동",17,"학생",99));
	      list.add(new Person("킹길동",15,"학생",56));
	   
	   //Person배열(list)정렬~!!   ==> 나이순으로 정렬
//	   Arrays.sort(list); //에러발생!! ==> Arrays클래스의 sort메소드를 통해 Collection(List)의 정렬을 할 수 없음~!!
	      

//	   Collections.sort(list, new Comparator<Person>() {
//
//		@Override
//		//문제 age 오름차순으로 하되 같은 age의 경우 score 내림차순
//		public int compare(Person o1, Person o2) {
//			return o1.age-o2.age;
//		}
//	   }.thenComparing(new Comparator<Person>() {
//
//		@Override
//		public int compare(Person o1, Person o2) {
//			return -(o1.age-o2.age);
//		}
//	}));
	   
	   Collections.sort(list, (o1, o2)->{return o1.age-o2.age;});
	   Collections.sort(list, (o1,o2)->o1.age-o2.age);
	   System.out.println(list);//배열의 값을 문자열형태로 출력
	   
	   
   }//main
}












