package com.jingjiajia.student;

public class Student implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private int age;
	
	public Student() {
		super();
	}
	public Student(int id, String name, int age) throws IdException, AgeException {
		super();
		setId(id);
		setName(name);
		setAge(age);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) throws IdException {
		if(id > 0){
			this.id = id;
		}
		else{
			throw new IdException("ѧ�Ų�����");
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) throws AgeException {
		if(age >= 4 && age <= 60){
			this.age = age;
		}
		else{
			throw new AgeException("���䲻����");
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
