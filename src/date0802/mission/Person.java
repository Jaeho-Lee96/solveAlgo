package date0802.mission;

public class Person implements Comparable<Person> {
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
		builder.append("]");
		return builder.toString();
	}
	
	@Override
	public int compareTo(Person o) {
		//this 의 속성과 o 의 속성을 비교
		//비교 방법 this.속성 - o.속성
		//결과: 음수, 0, 양수 ==> 음수의 경우 swap ==> 오름차순 정렬
//		return this.age - o.age; // 오름차순
//		return 0;
		
//		return this.name.compareTo(o.name);
		//내림 차순 
		//return o.age - this.age
		return o.name.compareTo(this.name);

	}

}
